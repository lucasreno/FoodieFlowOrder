package fiap.com.fforder.entity.produto.gateway

import fiap.com.fforder.entity.produto.model.Produto

interface ProdutoGateway {
    Produto create(Produto produto)

    Produto update(Produto produto)

    void delete(Long id)

    Optional<Produto> findById(Long id)

    List<Produto> findAll()

    List<Produto> findAllByCategoriaId(Long categoriaId)

    List<Produto> findAllByNome(String nome)
}