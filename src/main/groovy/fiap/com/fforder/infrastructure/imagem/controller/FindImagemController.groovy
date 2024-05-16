package fiap.com.fforder.infrastructure.imagem.controller

import fiap.com.fforder.entity.imagem.model.Imagem
import fiap.com.fforder.usecase.imagem.FindImagemUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FindImagemController {

    private final FindImagemUseCase findImagemUseCase

    FindImagemController(FindImagemUseCase findImagemUseCase) {
        this.findImagemUseCase = findImagemUseCase
    }

    @GetMapping("/imagem/{id}")
    Imagem get(@PathVariable("id") Long id) {
        findImagemUseCase.execute(id)
    }
}
