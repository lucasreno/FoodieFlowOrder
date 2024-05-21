package fiap.com.fforder.entity.pedido.exception

import jakarta.persistence.EntityNotFoundException

class PedidoNotFoundException extends EntityNotFoundException {
    PedidoNotFoundException() {
        super("Pedido não encontrado")
    }
}
