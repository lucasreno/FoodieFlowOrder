package fiap.com.fforder.infrastructure.imagem.controller

import fiap.com.fforder.entity.imagem.model.Imagem
import fiap.com.fforder.usecase.imagem.CreateImagemUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class CreateImagemController {

    private final CreateImagemUseCase createImagemUseCase

    CreateImagemController(CreateImagemUseCase createImagemUseCase) {
        this.createImagemUseCase = createImagemUseCase
    }

    @PostMapping("/imagem")
    @ResponseStatus(HttpStatus.CREATED)
    Imagem create(@RequestBody Imagem imagem) {
        createImagemUseCase.execute(imagem)
    }
}
