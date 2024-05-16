package fiap.com.fforder.infrastructure.imagem.gateway

import fiap.com.fforder.entity.imagem.gateway.ImagemGateway
import fiap.com.fforder.entity.imagem.model.Imagem
import fiap.com.fforder.infrastructure.config.db.repository.ImagemRepository
import fiap.com.fforder.infrastructure.config.db.schema.ImagemSchema
import fiap.com.fforder.infrastructure.config.db.schema.ProdutoSchema

class ImagemDatabaseGateway implements ImagemGateway{
    ImagemRepository imagemRepository

    ImagemDatabaseGateway(ImagemRepository imagemRepository) {
        this.imagemRepository = imagemRepository
    }

    @Override
    Imagem create(Imagem imagem) {
        ProdutoSchema produtoSchema = new ProdutoSchema(id: imagem.produto.id)
        ImagemSchema imagemSchema = new ImagemSchema(caminho: imagem.caminho, produto: produtoSchema)
        imagemRepository.save(imagemSchema).toImagem()
    }

    @Override
    Imagem update(Imagem imagem) {
        ProdutoSchema produtoSchema = new ProdutoSchema(id: imagem.produto.id)
        ImagemSchema imagemSchema = new ImagemSchema(id: imagem.id, caminho: imagem.caminho, produto: produtoSchema)
        imagemRepository.save(imagemSchema).toImagem()
    }

    @Override
    void delete(Long id) {
        imagemRepository.deleteById(id)
    }

    @Override
    Optional<Imagem> findById(Long id) {
        imagemRepository.findById(id).map { it.toImagem() }
    }

    @Override
    List<Imagem> findAll() {
        imagemRepository.findAll().collect { it.toImagem() }
    }

    @Override
    List<Imagem> findAllByProdutoId(Long produtoId) {
        List<Imagem> imagens = imagemRepository.findAllByProdutoId(produtoId).collect { it.toImagem() }
        return imagens ?: []
    }

    @Override
    boolean isDuplicated(Imagem imagem) {
        imagemRepository.findByCaminhoAndProdutoId(imagem.caminho, imagem.produto.id) != null
    }
}
