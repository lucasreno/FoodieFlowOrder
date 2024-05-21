package fiap.com.fforder.entity.pedido.exception

import jakarta.persistence.EntityExistsException

class PedidoAlreadyExistsException extends EntityExistsException {
    PedidoAlreadyExistsException() {
        super("Pedido já existe")
    }
}
