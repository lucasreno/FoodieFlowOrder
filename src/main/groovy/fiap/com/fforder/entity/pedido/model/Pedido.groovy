package fiap.com.fforder.entity.pedido.model

import fiap.com.fforder.entity.AbstractEntity
import fiap.com.fforder.entity.cliente.model.Cliente
import fiap.com.fforder.entity.produto.model.Produto
import fiap.com.fforder.entity.status.model.Status

import java.time.LocalDateTime

class Pedido extends AbstractEntity<Long> {
    String codigo
    LocalDateTime dataHoraCriacao
    Cliente cliente
    Status status
    List<Produto> produtos
}
