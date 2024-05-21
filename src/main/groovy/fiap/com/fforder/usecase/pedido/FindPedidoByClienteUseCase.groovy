package fiap.com.fforder.usecase.pedido

import fiap.com.fforder.entity.pedido.exception.PedidoNotFoundException
import fiap.com.fforder.entity.pedido.gateway.PedidoGateway
import fiap.com.fforder.entity.pedido.model.Pedido

class FindPedidoByClienteUseCase {
    private final PedidoGateway pedidoGateway

    FindPedidoByClienteUseCase(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway
    }

    List<Pedido> execute(Long clienteId) {
        List<Pedido> pedidos = pedidoGateway.findAllByClienteId(clienteId)
        if (pedidos.isEmpty()) {
            throw new PedidoNotFoundException()
        }
        return pedidos
    }
}
