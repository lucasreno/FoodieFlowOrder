package fiap.com.fforder.infrastructure.pedido.gateway

import fiap.com.fforder.entity.pedido.gateway.PedidoGateway
import fiap.com.fforder.entity.pedido.model.Pedido
import fiap.com.fforder.infrastructure.config.db.repository.PedidoRepository
import fiap.com.fforder.infrastructure.config.db.schema.ClienteSchema
import fiap.com.fforder.infrastructure.config.db.schema.PedidoSchema
import fiap.com.fforder.infrastructure.config.db.schema.ProdutoSchema
import fiap.com.fforder.infrastructure.config.db.schema.StatusSchema

class PedidoDatabaseGateway implements PedidoGateway {

    private final PedidoRepository pedidoRepository

    PedidoDatabaseGateway(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository
    }

    @Override
    Pedido create(Pedido pedido) {
        ClienteSchema clienteSchema = new ClienteSchema(id: pedido.cliente.id)
        StatusSchema statusSchema = new StatusSchema(id: pedido.status.id)
        List<ProdutoSchema> produtosSchema = pedido.produtos.collect { new ProdutoSchema(id: it.id) }
        PedidoSchema pedidoSchema = new PedidoSchema(
                cliente: clienteSchema,
                status: statusSchema,
                codigo: pedido.codigo,
                produtos: produtosSchema
        )
        pedidoRepository.save(pedidoSchema).toPedido()
    }

    @Override
    Pedido update(Pedido pedido) {
        ClienteSchema clienteSchema = new ClienteSchema(id: pedido.cliente.id)
        StatusSchema statusSchema = new StatusSchema(id: pedido.status.id)
        List<ProdutoSchema> produtosSchema = pedido.produtos.collect { new ProdutoSchema(id: it.id) }
        PedidoSchema pedidoSchema = new PedidoSchema(
                id: pedido.id,
                cliente: clienteSchema,
                status: statusSchema,
                codigo: pedido.codigo,
                produtos: produtosSchema
        )
        pedidoRepository.save(pedidoSchema).toPedido()
    }

    @Override
    void delete(Long id) {
        pedidoRepository.deleteById(id)
    }

    @Override
    Optional<Pedido> findById(Long id) {
        pedidoRepository.findById(id).map { it.toPedido() }
    }

    @Override
    List<Pedido> findAll() {
        pedidoRepository.findAll().collect { it.toPedido() }
    }

    @Override
    List<Pedido> findAllByClienteId(Long clienteId) {
        List<Pedido> pedidos = pedidoRepository.findAllByClienteId(clienteId).collect { it.toPedido() }
        return pedidos ?: []
    }

    @Override
    List<Pedido> findAllByStatus(Long statusId) {
        List<Pedido> pedidos = pedidoRepository.findAllByStatusId(statusId).collect { it.toPedido() }
        return pedidos ?: []
    }

    @Override
    List<Pedido> findAllByCodigo(String codigo) {
        List<Pedido> pedidos = pedidoRepository.findAllByCodigo(codigo).collect { it.toPedido() }
        return pedidos ?: []
    }
}
