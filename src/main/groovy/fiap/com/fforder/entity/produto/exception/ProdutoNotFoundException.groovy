package fiap.com.fforder.entity.produto.exception

import jakarta.persistence.EntityNotFoundException

class ProdutoNotFoundException extends EntityNotFoundException {
    ProdutoNotFoundException() {
        super("Produto não encontrado")
    }
}
