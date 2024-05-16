package fiap.com.fforder.entity.ingrediente.gateway

import fiap.com.fforder.entity.ingrediente.model.Ingrediente

interface IngredienteGateway {
    Ingrediente create(Ingrediente ingrediente)

    Ingrediente update(Ingrediente ingrediente)

    void delete(Long id)

    Optional<Ingrediente> findById(Long id)

    List<Ingrediente> findAll()

    List<Ingrediente> findAllByNome(String nome)
}
