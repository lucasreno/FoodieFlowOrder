package fiap.com.fforder.usecase.imagem

import fiap.com.fforder.entity.imagem.exception.ImagemNotFoundException
import fiap.com.fforder.entity.imagem.gateway.ImagemGateway
import fiap.com.fforder.entity.imagem.model.Imagem

class UpdateImagemUseCase {
    private final ImagemGateway imagemGateway

    UpdateImagemUseCase(ImagemGateway imagemGateway) {
        this.imagemGateway = imagemGateway
    }

    Imagem execute(Imagem imagem) {
        imagemGateway.findById(imagem.id).orElseThrow { new ImagemNotFoundException() }
        imagemGateway.update(imagem)
    }
}
