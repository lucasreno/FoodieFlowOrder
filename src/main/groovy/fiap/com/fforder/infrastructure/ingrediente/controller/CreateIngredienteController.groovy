package fiap.com.fforder.infrastructure.ingrediente.controller

import fiap.com.fforder.entity.ingrediente.model.Ingrediente
import fiap.com.fforder.usecase.ingrediente.CreateIngredienteUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class CreateIngredienteController {

    private final CreateIngredienteUseCase createIngredienteUseCase

    CreateIngredienteController(CreateIngredienteUseCase createIngredienteUseCase) {
        this.createIngredienteUseCase = createIngredienteUseCase
    }

    @PostMapping("/ingrediente")
    @ResponseStatus(HttpStatus.CREATED)
    Ingrediente create(@RequestBody Ingrediente ingrediente) {
        createIngredienteUseCase.execute(ingrediente.nome)
    }
}
