package fiap.com.fforder.usecase.pedido

import fiap.com.fforder.entity.pedido.gateway.PedidoGateway
import fiap.com.fforder.entity.pedido.model.Pedido

class FindAllPedidoUseCase {
    private final PedidoGateway pedidoGateway

    FindAllPedidoUseCase(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway
    }

    List<Pedido> execute() {
        pedidoGateway.findAll()
    }
}
