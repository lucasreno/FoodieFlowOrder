package fiap.com.fforder.entity.imagem.gateway

import fiap.com.fforder.entity.imagem.model.Imagem

interface ImagemGateway {
    Imagem create(Imagem imagem)

    Imagem update(Imagem imagem)

    void delete(Long id)

    Optional<Imagem> findById(Long id)

    List<Imagem> findAll()

    List<Imagem> findAllByProdutoId(Long produtoId)

    boolean isDuplicated(Imagem imagem)
}