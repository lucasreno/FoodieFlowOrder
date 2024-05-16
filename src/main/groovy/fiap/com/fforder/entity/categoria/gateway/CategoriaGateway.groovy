package fiap.com.fforder.entity.categoria.gateway

import fiap.com.fforder.entity.categoria.model.Categoria

interface CategoriaGateway {
    Categoria create(Categoria categoria)

    Categoria update(Categoria categoria)

    void delete(Long id)

    Optional<Categoria> findById(Long id)

    List<Categoria> findAll()

    List<Categoria> findAllByNome(String nome)
}
