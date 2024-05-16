package fiap.com.fforder.usecase.categoria

import fiap.com.fforder.entity.categoria.exception.CategoriaNotFoundException
import fiap.com.fforder.entity.categoria.gateway.CategoriaGateway
import fiap.com.fforder.entity.categoria.model.Categoria

class UpdateCategoriaUseCase {
    private final CategoriaGateway categoriaGateway

    UpdateCategoriaUseCase(CategoriaGateway categoriaGateway) {
        this.categoriaGateway = categoriaGateway
    }

    Categoria execute(Long id, String nome) {
        Categoria categoria = categoriaGateway.findById(id).orElseThrow { new CategoriaNotFoundException() }
        categoria.setNome(nome)
        categoriaGateway.update(categoria)
    }
}
