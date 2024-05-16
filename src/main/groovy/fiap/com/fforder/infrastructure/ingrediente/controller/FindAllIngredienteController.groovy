package fiap.com.fforder.infrastructure.ingrediente.controller

import fiap.com.fforder.usecase.ingrediente.FindAllIngredienteUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FindAllIngredienteController {

    private final FindAllIngredienteUseCase getAllIngredienteUseCase

    FindAllIngredienteController(FindAllIngredienteUseCase getAllIngredienteUseCase) {
        this.getAllIngredienteUseCase = getAllIngredienteUseCase
    }

    @GetMapping("/ingrediente")
    List getAll() {
        getAllIngredienteUseCase.execute()
    }
}
