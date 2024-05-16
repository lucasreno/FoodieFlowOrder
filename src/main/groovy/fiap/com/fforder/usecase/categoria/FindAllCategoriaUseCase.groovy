package fiap.com.fforder.usecase.categoria

import fiap.com.fforder.entity.categoria.gateway.CategoriaGateway
import fiap.com.fforder.entity.categoria.model.Categoria

class FindAllCategoriaUseCase {
    private final CategoriaGateway categoriaGateway

    FindAllCategoriaUseCase(CategoriaGateway categoriaGateway) {
        this.categoriaGateway = categoriaGateway
    }

    List<Categoria> execute() {
        categoriaGateway.findAll()
    }
}
