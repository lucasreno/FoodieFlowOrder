package fiap.com.fforder.infrastructure.ingrediente.controller

import fiap.com.fforder.entity.ingrediente.model.Ingrediente
import fiap.com.fforder.usecase.ingrediente.UpdateIngredienteUseCase
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UpdateIngredienteController {

    private final UpdateIngredienteUseCase updateIngredienteUseCase

    UpdateIngredienteController(UpdateIngredienteUseCase updateIngredienteUseCase) {
        this.updateIngredienteUseCase = updateIngredienteUseCase
    }

    @PutMapping("/ingrediente")
    Ingrediente update(@RequestBody Ingrediente ingrediente) {
        updateIngredienteUseCase.execute(ingrediente.id, ingrediente.nome)
    }
}
