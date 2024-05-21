package fiap.com.fforder.usecase.pedido

import fiap.com.fforder.entity.pedido.exception.PedidoNotFoundException
import fiap.com.fforder.entity.pedido.gateway.PedidoGateway

class FindPedidoUseCase {
    private final PedidoGateway pedidoGateway

    FindPedidoUseCase(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway
    }

    def execute(Long id) {
        pedidoGateway.findById(id).orElseThrow { new PedidoNotFoundException() }
    }
}
