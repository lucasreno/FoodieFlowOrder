package fiap.com.fforder.usecase.ingrediente

import fiap.com.fforder.entity.ingrediente.gateway.IngredienteGateway
import fiap.com.fforder.entity.ingrediente.model.Ingrediente

class FindAllIngredienteUseCase {
    private final IngredienteGateway ingredienteGateway

    FindAllIngredienteUseCase(IngredienteGateway ingredienteGateway) {
        this.ingredienteGateway = ingredienteGateway
    }

    List<Ingrediente> execute() {
        ingredienteGateway.findAll()
    }
}
