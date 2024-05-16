package fiap.com.fforder.infrastructure.ingrediente.controller

import fiap.com.fforder.entity.ingrediente.exception.IngredienteNotFoundException
import fiap.com.fforder.usecase.ingrediente.DeleteIngredienteUseCase
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class DeleteIngredienteController {
    private final DeleteIngredienteUseCase deleteIngredienteUseCase

    DeleteIngredienteController(DeleteIngredienteUseCase deleteIngredienteUseCase) {
        this.deleteIngredienteUseCase = deleteIngredienteUseCase
    }

    @DeleteMapping("/ingrediente/{id}")
    void delete(@PathVariable Long id) throws IngredienteNotFoundException {
        deleteIngredienteUseCase.execute(id)
    }
}
