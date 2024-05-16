package fiap.com.fforder.usecase.ingrediente

import fiap.com.fforder.entity.ingrediente.exception.IngredienteNotFoundException
import fiap.com.fforder.entity.ingrediente.gateway.IngredienteGateway
import fiap.com.fforder.entity.ingrediente.model.Ingrediente

class UpdateIngredienteUseCase {
    private final IngredienteGateway ingredienteGateway

    UpdateIngredienteUseCase(IngredienteGateway ingredienteGateway) {
        this.ingredienteGateway = ingredienteGateway
    }

    Ingrediente execute(Long id, String nome) {
        Ingrediente ingrediente = ingredienteGateway.findById(id).orElseThrow { new IngredienteNotFoundException() }
        ingrediente.setNome(nome)
        ingredienteGateway.update(ingrediente)
    }
}
