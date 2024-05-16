package fiap.com.fforder.usecase.imagem

import fiap.com.fforder.entity.imagem.gateway.ImagemGateway
import fiap.com.fforder.entity.imagem.model.Imagem

class FindImagemByProdutoUseCase {
    private final ImagemGateway imagemGateway

    FindImagemByProdutoUseCase(ImagemGateway imagemGateway) {
        this.imagemGateway = imagemGateway
    }

    List<Imagem> execute(Long produtoId) {
        imagemGateway.findAllByProdutoId(produtoId)
    }
}
