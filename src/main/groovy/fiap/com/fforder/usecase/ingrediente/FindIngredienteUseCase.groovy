package fiap.com.fforder.usecase.ingrediente

import fiap.com.fforder.entity.ingrediente.exception.IngredienteNotFoundException
import fiap.com.fforder.entity.ingrediente.gateway.IngredienteGateway
import fiap.com.fforder.entity.ingrediente.model.Ingrediente

class FindIngredienteUseCase {
    private final IngredienteGateway ingredienteGateway

    FindIngredienteUseCase(IngredienteGateway ingredienteGateway) {
        this.ingredienteGateway = ingredienteGateway
    }

    Ingrediente execute(Long id) {
        ingredienteGateway.findById(id).orElseThrow { new IngredienteNotFoundException() }
    }
}
