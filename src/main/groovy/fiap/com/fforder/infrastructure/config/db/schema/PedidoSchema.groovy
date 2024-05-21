package fiap.com.fforder.infrastructure.config.db.schema

import fiap.com.fforder.entity.pedido.model.Pedido
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

import java.sql.Timestamp

@Entity
@Table(name = "pedido")
class PedidoSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    Timestamp dataHoraCriacao

    @Column(nullable = false, unique = true)
    String codigo

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    ClienteSchema cliente

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id")
    StatusSchema status

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "pedido_produto",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id"))
    List<ProdutoSchema> produtos

    Pedido toPedido() {
        new Pedido(id: id,
                codigo: codigo,
                cliente: cliente?.toCliente(),
                status: status?.toStatus(),
                produtos: produtos.collect { it.toProduto() },
                dataHoraCriacao: dataHoraCriacao?.toLocalDateTime())
    }
}
