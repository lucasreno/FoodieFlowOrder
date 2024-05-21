package fiap.com.fforder.usecase.pedido

import fiap.com.fforder.entity.pedido.exception.PedidoAlreadyExistsException
import fiap.com.fforder.entity.pedido.gateway.PedidoGateway
import fiap.com.fforder.entity.pedido.model.Pedido

class CreatePedidoUseCase {
    private final PedidoGateway pedidoGateway

    CreatePedidoUseCase(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway
    }

    Pedido execute(Pedido pedido) {
        pedido.codigo = pedido.codigo ?: UUID.randomUUID().toString()
        if(pedidoGateway.findAllByCodigo(pedido.codigo).isEmpty()) {
            return pedidoGateway.create(pedido)
        } else {
            throw new PedidoAlreadyExistsException()
        }

    }
}
