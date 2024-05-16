package fiap.com.fforder.usecase.imagem

import fiap.com.fforder.entity.imagem.gateway.ImagemGateway
import fiap.com.fforder.entity.imagem.model.Imagem

class FindAllImagemUseCase {
    private final ImagemGateway imagemGateway

    FindAllImagemUseCase(ImagemGateway imagemGateway) {
        this.imagemGateway = imagemGateway
    }

    List<Imagem> execute() {
        imagemGateway.findAll()
    }
}
