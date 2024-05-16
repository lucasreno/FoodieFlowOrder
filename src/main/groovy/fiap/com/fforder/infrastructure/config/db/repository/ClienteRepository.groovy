package fiap.com.fforder.infrastructure.config.db.repository

import fiap.com.fforder.infrastructure.config.db.schema.ClienteSchema
import org.springframework.data.jpa.repository.JpaRepository

interface ClienteRepository extends JpaRepository<ClienteSchema, Long> {
    List<ClienteSchema> findAllByNome(String nome)
    List<ClienteSchema> findAllByCpf(String cpf)
}