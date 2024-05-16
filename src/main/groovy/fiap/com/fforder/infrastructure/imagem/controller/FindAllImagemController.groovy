package fiap.com.fforder.infrastructure.imagem.controller

import fiap.com.fforder.entity.imagem.model.Imagem
import fiap.com.fforder.usecase.imagem.FindAllImagemUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FindAllImagemController {

    private final FindAllImagemUseCase findAllImagemUseCase

    FindAllImagemController(FindAllImagemUseCase findAllImagemUseCase) {
        this.findAllImagemUseCase = findAllImagemUseCase
    }

    @GetMapping("/imagem")
    List<Imagem> findAll() {
        return findAllImagemUseCase.execute()
    }
}
