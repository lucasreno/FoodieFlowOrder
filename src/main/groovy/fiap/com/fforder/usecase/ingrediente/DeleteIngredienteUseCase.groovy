package fiap.com.fforder.usecase.ingrediente

import fiap.com.fforder.entity.ingrediente.exception.IngredienteNotFoundException
import fiap.com.fforder.entity.ingrediente.gateway.IngredienteGateway

class DeleteIngredienteUseCase {
    private final IngredienteGateway ingredienteGateway

    DeleteIngredienteUseCase(IngredienteGateway ingredienteGateway) {
        this.ingredienteGateway = ingredienteGateway
    }

    void execute(Long id) {
        ingredienteGateway.findById(id).orElseThrow { new IngredienteNotFoundException() }
        ingredienteGateway.delete(id)
    }
}
