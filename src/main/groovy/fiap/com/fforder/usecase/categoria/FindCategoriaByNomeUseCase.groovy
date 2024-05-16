package fiap.com.fforder.usecase.categoria

import fiap.com.fforder.entity.categoria.exception.CategoriaNotFoundException
import fiap.com.fforder.entity.categoria.gateway.CategoriaGateway
import fiap.com.fforder.entity.categoria.model.Categoria

class FindCategoriaByNomeUseCase {
    private final CategoriaGateway categoriaGateway

    FindCategoriaByNomeUseCase(CategoriaGateway categoriaGateway) {
        this.categoriaGateway = categoriaGateway
    }

    List<Categoria> execute(String nome) {
        List<Categoria> categorias = categoriaGateway.findAllByNome(nome)
        if (categorias.isEmpty()) {
            throw new CategoriaNotFoundException()
        }
        return categorias
    }
}
