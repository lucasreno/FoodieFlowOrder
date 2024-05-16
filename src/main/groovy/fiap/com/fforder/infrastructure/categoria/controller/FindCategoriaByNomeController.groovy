package fiap.com.fforder.infrastructure.categoria.controller

import fiap.com.fforder.usecase.categoria.FindCategoriaByNomeUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FindCategoriaByNomeController {

    private final FindCategoriaByNomeUseCase findCategoriaByNomeUseCase

    FindCategoriaByNomeController(FindCategoriaByNomeUseCase findCategoriaByNomeUseCase) {
        this.findCategoriaByNomeUseCase = findCategoriaByNomeUseCase
    }

    @GetMapping("/categoria/nome/{nome}")
    List find(@PathVariable("nome") String nome) {
        findCategoriaByNomeUseCase.execute(nome)
    }
}
