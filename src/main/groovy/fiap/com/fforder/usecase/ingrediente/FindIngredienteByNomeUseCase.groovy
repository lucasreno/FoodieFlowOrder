package fiap.com.fforder.usecase.ingrediente

import fiap.com.fforder.entity.ingrediente.exception.IngredienteNotFoundException
import fiap.com.fforder.entity.ingrediente.gateway.IngredienteGateway
import fiap.com.fforder.entity.ingrediente.model.Ingrediente

class FindIngredienteByNomeUseCase {
    private final IngredienteGateway ingredienteGateway

    FindIngredienteByNomeUseCase(IngredienteGateway ingredienteGateway) {
        this.ingredienteGateway = ingredienteGateway
    }

    List<Ingrediente> execute(String nome) {
        List<Ingrediente> ingredientes = ingredienteGateway.findAllByNome(nome)
        if (ingredientes.isEmpty()) {
            throw new IngredienteNotFoundException()
        }
        return ingredientes
    }
}
