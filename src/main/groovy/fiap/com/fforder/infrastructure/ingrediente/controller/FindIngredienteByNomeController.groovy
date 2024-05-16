package fiap.com.fforder.infrastructure.ingrediente.controller

import fiap.com.fforder.usecase.ingrediente.FindIngredienteByNomeUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FindIngredienteByNomeController {

    private final FindIngredienteByNomeUseCase findIngredienteByNomeUseCase

    FindIngredienteByNomeController(FindIngredienteByNomeUseCase findIngredienteByNomeUseCase) {
        this.findIngredienteByNomeUseCase = findIngredienteByNomeUseCase
    }

    @GetMapping("/ingrediente/nome/{nome}")
    List find(@PathVariable("nome") String nome) {
        findIngredienteByNomeUseCase.execute(nome)
    }
}
