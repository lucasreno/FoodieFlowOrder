package fiap.com.fforder.usecase.pedido

import fiap.com.fforder.entity.pedido.exception.PedidoNotFoundException
import fiap.com.fforder.entity.pedido.gateway.PedidoGateway
import fiap.com.fforder.entity.pedido.model.Pedido

class FindPedidoByStatusUseCase {
    private final PedidoGateway pedidoGateway

    FindPedidoByStatusUseCase(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway
    }

    List<Pedido> execute(Long statusId) {
        List<Pedido> pedidos = pedidoGateway.findAllByStatus(statusId)
        if (pedidos.isEmpty()) {
            throw new PedidoNotFoundException()
        }
        return pedidos
    }
}
