package fiap.com.fforder.usecase.ingrediente

import fiap.com.fforder.entity.ingrediente.exception.IngredienteAlreadyExistsException
import fiap.com.fforder.entity.ingrediente.gateway.IngredienteGateway
import fiap.com.fforder.entity.ingrediente.model.Ingrediente

class CreateIngredienteUseCase {
    private final IngredienteGateway ingredienteGateway

    CreateIngredienteUseCase(IngredienteGateway ingredienteGateway) {
        this.ingredienteGateway = ingredienteGateway
    }

    Ingrediente execute(String nome) {
        Ingrediente ingrediente = new Ingrediente(nome: nome)
        if(ingredienteGateway.findAllByNome(nome).isEmpty()) {
            return ingredienteGateway.create(ingrediente)
        } else {
            throw new IngredienteAlreadyExistsException()
        }
    }
}
