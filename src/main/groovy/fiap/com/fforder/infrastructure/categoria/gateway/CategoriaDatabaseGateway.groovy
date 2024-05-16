package fiap.com.fforder.infrastructure.categoria.gateway

import fiap.com.fforder.entity.categoria.gateway.CategoriaGateway
import fiap.com.fforder.entity.categoria.model.Categoria
import fiap.com.fforder.infrastructure.config.db.repository.CategoriaRepository
import fiap.com.fforder.infrastructure.config.db.schema.CategoriaSchema

class CategoriaDatabaseGateway implements CategoriaGateway {

    private final CategoriaRepository categoriaRepository

    CategoriaDatabaseGateway(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository
    }

    @Override
    Categoria create(Categoria categoria) {
        categoriaRepository.save(new CategoriaSchema(nome: categoria.nome)).toCategoria()
    }

    @Override
    Categoria update(Categoria categoria) {
        categoriaRepository.save(new CategoriaSchema(id: categoria.id, nome: categoria.nome)).toCategoria()
    }

    @Override
    void delete(Long id) {
        categoriaRepository.deleteById(id)
    }

    @Override
    Optional<Categoria> findById(Long id) {
        categoriaRepository.findById(id).map { it.toCategoria() }
    }

    @Override
    List<Categoria> findAll() {
        categoriaRepository.findAll().collect { it.toCategoria() }
    }

    @Override
    List<Categoria> findAllByNome(String nome) {
        List<Categoria> categorias = categoriaRepository.findAllByNome(nome).collect { it.toCategoria() }
        categorias ?: []
    }
}
