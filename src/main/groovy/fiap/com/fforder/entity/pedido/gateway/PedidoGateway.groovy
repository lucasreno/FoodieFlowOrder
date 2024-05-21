package fiap.com.fforder.entity.pedido.gateway

import fiap.com.fforder.entity.pedido.model.Pedido

interface PedidoGateway {
    Pedido create(Pedido pedido)

    Pedido update(Pedido pedido)

    void delete(Long id)

    Optional<Pedido> findById(Long id)

    List<Pedido> findAll()

    List<Pedido> findAllByClienteId(Long clienteId)

    List<Pedido> findAllByStatus(Long statusId)

    List<Pedido> findAllByCodigo(String codigo)

}