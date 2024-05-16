package fiap.com.fforder.usecase.categoria

import fiap.com.fforder.entity.categoria.exception.CategoriaAlreadyExistsException
import fiap.com.fforder.entity.categoria.gateway.CategoriaGateway
import fiap.com.fforder.entity.categoria.model.Categoria

class CreateCategoriaUseCase {
    private final CategoriaGateway categoriaGateway

    CreateCategoriaUseCase(CategoriaGateway categoriaGateway) {
        this.categoriaGateway = categoriaGateway
    }

    Categoria execute(String nome) {
        Categoria categoria = new Categoria(nome: nome)
        if(categoriaGateway.findAllByNome(nome).isEmpty()) {
            return categoriaGateway.create(categoria)
        } else {
            throw new CategoriaAlreadyExistsException()
        }
    }
}
