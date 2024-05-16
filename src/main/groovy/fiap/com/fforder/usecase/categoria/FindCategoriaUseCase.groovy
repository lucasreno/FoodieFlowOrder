package fiap.com.fforder.usecase.categoria

import fiap.com.fforder.entity.categoria.exception.CategoriaNotFoundException
import fiap.com.fforder.entity.categoria.gateway.CategoriaGateway
import fiap.com.fforder.entity.categoria.model.Categoria

class FindCategoriaUseCase {
    private final CategoriaGateway categoriaGateway

    FindCategoriaUseCase(CategoriaGateway categoriaGateway) {
        this.categoriaGateway = categoriaGateway
    }

    Categoria execute(Long id) {
        categoriaGateway.findById(id).orElseThrow { new CategoriaNotFoundException() }
    }
}
