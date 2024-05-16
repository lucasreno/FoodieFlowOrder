package fiap.com.fforder.usecase.imagem

import fiap.com.fforder.entity.imagem.exception.ImagemNotFoundException
import fiap.com.fforder.entity.imagem.gateway.ImagemGateway

class DeleteImagemUseCase {
    private final ImagemGateway imagemGateway

    DeleteImagemUseCase(ImagemGateway imagemGateway) {
        this.imagemGateway = imagemGateway
    }

    void execute(Long id) {
        imagemGateway.findById(id).orElseThrow { new ImagemNotFoundException() }
        imagemGateway.delete(id)
    }
}
