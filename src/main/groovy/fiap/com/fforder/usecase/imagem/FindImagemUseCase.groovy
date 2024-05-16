package fiap.com.fforder.usecase.imagem

import fiap.com.fforder.entity.imagem.exception.ImagemNotFoundException
import fiap.com.fforder.entity.imagem.gateway.ImagemGateway
import fiap.com.fforder.entity.imagem.model.Imagem

class FindImagemUseCase {
    private final ImagemGateway imagemGateway

    FindImagemUseCase(ImagemGateway imagemGateway) {
        this.imagemGateway = imagemGateway
    }

    Imagem execute(Long imagemId) {
        imagemGateway.findById(imagemId).orElseThrow { new ImagemNotFoundException() }
    }
}
