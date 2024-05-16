package fiap.com.fforder.infrastructure.ingrediente.gateway

import fiap.com.fforder.entity.ingrediente.gateway.IngredienteGateway
import fiap.com.fforder.entity.ingrediente.model.Ingrediente
import fiap.com.fforder.infrastructure.config.db.repository.IngredienteRepository
import fiap.com.fforder.infrastructure.config.db.schema.IngredienteSchema

class IngredienteDatabaseGateway implements IngredienteGateway {

    private final IngredienteRepository ingredienteRepository

    IngredienteDatabaseGateway(IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository
    }

    @Override
    Ingrediente create(Ingrediente ingrediente) {
        ingredienteRepository.save(new IngredienteSchema(nome: ingrediente.nome)).toIngrediente()
    }

    @Override
    Ingrediente update(Ingrediente ingrediente) {
        ingredienteRepository.save(new IngredienteSchema(id: ingrediente.id, nome: ingrediente.nome)).toIngrediente()
    }

    @Override
    void delete(Long id) {
        ingredienteRepository.deleteById(id)
    }

    @Override
    Optional<Ingrediente> findById(Long id) {
        ingredienteRepository.findById(id).map { it.toIngrediente() }
    }

    @Override
    List<Ingrediente> findAll() {
        ingredienteRepository.findAll().collect { it.toIngrediente() }
    }

    @Override
    List<Ingrediente> findAllByNome(String nome) {
        List<Ingrediente> ingredientes = ingredienteRepository.findAllByNome(nome).collect { it.toIngrediente() }
        return ingredientes ?: []
    }
}
