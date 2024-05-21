package fiap.com.fforder.infrastructure.config.db.repository

import fiap.com.fforder.infrastructure.config.db.schema.PedidoSchema
import org.springframework.data.jpa.repository.JpaRepository

interface PedidoRepository extends JpaRepository<PedidoSchema, Long> {
    List<PedidoSchema> findAllByClienteId(Long clienteId)
    List<PedidoSchema> findAllByStatusId(Long statusId)
    List<PedidoSchema> findAllByCodigo(String codigo)
}