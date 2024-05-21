package fiap.com.fforder.usecase.pedido

import fiap.com.fforder.entity.pedido.exception.PedidoNotFoundException
import fiap.com.fforder.entity.pedido.gateway.PedidoGateway

class DeletePedidoUseCase {
    private final PedidoGateway pedidoGateway

    DeletePedidoUseCase(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway
    }

    void execute(Long id) {
        pedidoGateway.findById(id).orElseThrow { new PedidoNotFoundException() }
        pedidoGateway.delete(id)
    }
}
