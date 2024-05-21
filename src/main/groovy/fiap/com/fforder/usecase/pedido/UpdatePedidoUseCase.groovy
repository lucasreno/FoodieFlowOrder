package fiap.com.fforder.usecase.pedido

import fiap.com.fforder.entity.pedido.exception.PedidoNotFoundException
import fiap.com.fforder.entity.pedido.gateway.PedidoGateway
import fiap.com.fforder.entity.pedido.model.Pedido

class UpdatePedidoUseCase {
    private final PedidoGateway pedidoGateway

    UpdatePedidoUseCase(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway
    }

    def execute(Pedido pedido) {
        pedidoGateway.findById(pedido.id).orElseThrow { new PedidoNotFoundException() }
        pedidoGateway.update(pedido)
    }
}
