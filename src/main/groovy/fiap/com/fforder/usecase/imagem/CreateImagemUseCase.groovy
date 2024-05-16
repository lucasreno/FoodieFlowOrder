package fiap.com.fforder.usecase.imagem

import fiap.com.fforder.entity.imagem.exception.ImagemAlreadyExistsException
import fiap.com.fforder.entity.imagem.gateway.ImagemGateway
import fiap.com.fforder.entity.imagem.model.Imagem

class CreateImagemUseCase {
    private final ImagemGateway imagemGateway

    CreateImagemUseCase(ImagemGateway imagemGateway) {
        this.imagemGateway = imagemGateway
    }

    Imagem execute(Imagem imagem) {
        if (!imagemGateway.isDuplicated(imagem)) {
            return imagemGateway.create(imagem)
        } else {
            throw new ImagemAlreadyExistsException()
        }
    }
}
