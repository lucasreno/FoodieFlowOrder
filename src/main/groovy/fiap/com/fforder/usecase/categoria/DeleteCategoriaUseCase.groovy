package fiap.com.fforder.usecase.categoria

import fiap.com.fforder.entity.categoria.exception.CategoriaNotFoundException
import fiap.com.fforder.entity.categoria.gateway.CategoriaGateway
import fiap.com.fforder.entity.categoria.model.Categoria

class DeleteCategoriaUseCase {
    private final CategoriaGateway categoriaGateway

    DeleteCategoriaUseCase(CategoriaGateway categoriaGateway) {
        this.categoriaGateway = categoriaGateway
    }

    Categoria execute(Long id) {
        Categoria categoria = categoriaGateway.findById(id).orElseThrow { new CategoriaNotFoundException() }
        categoriaGateway.delete(id)
        categoria
    }
}
