package fiap.com.fforder.entity.produto.exception

import jakarta.persistence.EntityExistsException

class ProdutoAlreadyExistsException extends EntityExistsException {
    ProdutoAlreadyExistsException() {
        super("Produto já existe")
    }
}
