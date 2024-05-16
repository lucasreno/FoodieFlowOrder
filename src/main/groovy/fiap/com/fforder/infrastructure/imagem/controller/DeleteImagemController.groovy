package fiap.com.fforder.infrastructure.imagem.controller

import fiap.com.fforder.entity.imagem.exception.ImagemNotFoundException
import fiap.com.fforder.usecase.imagem.DeleteImagemUseCase
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class DeleteImagemController {

    private final DeleteImagemUseCase deleteImagemUseCase

    DeleteImagemController(DeleteImagemUseCase deleteImagemUseCase) {
        this.deleteImagemUseCase = deleteImagemUseCase
    }

    @DeleteMapping("/imagem/{id}")
    void delete(@PathVariable Long id) throws ImagemNotFoundException {
        deleteImagemUseCase.execute(id)
    }
}
