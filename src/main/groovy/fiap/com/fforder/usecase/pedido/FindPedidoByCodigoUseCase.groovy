package fiap.com.fforder.usecase.pedido

import fiap.com.fforder.entity.pedido.exception.PedidoNotFoundException
import fiap.com.fforder.entity.pedido.gateway.PedidoGateway
import fiap.com.fforder.entity.pedido.model.Pedido

class FindPedidoByCodigoUseCase {
    private final PedidoGateway pedidoGateway

    FindPedidoByCodigoUseCase(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway
    }

    List<Pedido> execute(String codigo) {
        List<Pedido> pedidos = pedidoGateway.findAllByCodigo(codigo)
        if (pedidos.isEmpty()) {
            throw new PedidoNotFoundException()
        }
        return pedidos
    }
}
