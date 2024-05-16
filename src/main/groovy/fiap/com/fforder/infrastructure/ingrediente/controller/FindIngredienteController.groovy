package fiap.com.fforder.infrastructure.ingrediente.controller

import fiap.com.fforder.entity.ingrediente.model.Ingrediente
import fiap.com.fforder.usecase.ingrediente.FindIngredienteUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FindIngredienteController {

    private final FindIngredienteUseCase getIngredienteUseCase

    FindIngredienteController(FindIngredienteUseCase getIngredienteUseCase) {
        this.getIngredienteUseCase = getIngredienteUseCase
    }

    @GetMapping("/ingrediente/{id}")
    Ingrediente get(@PathVariable("id") Long id) {
        getIngredienteUseCase.execute(id)
    }
}
