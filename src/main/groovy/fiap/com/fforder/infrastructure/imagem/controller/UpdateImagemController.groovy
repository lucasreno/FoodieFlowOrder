package fiap.com.fforder.infrastructure.imagem.controller

import fiap.com.fforder.entity.imagem.model.Imagem
import fiap.com.fforder.usecase.imagem.UpdateImagemUseCase
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UpdateImagemController {

    private final UpdateImagemUseCase updateImagemUseCase

    UpdateImagemController(UpdateImagemUseCase updateImagemUseCase) {
        this.updateImagemUseCase = updateImagemUseCase
    }

    @PutMapping("/imagem")
    Imagem update(@RequestBody Imagem imagem) {
        updateImagemUseCase.execute(imagem)
    }
}
