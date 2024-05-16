package fiap.com.fforder.infrastructure.config.db.repository

import fiap.com.fforder.infrastructure.config.db.schema.StatusSchema
import org.springframework.data.jpa.repository.JpaRepository

interface StatusRepository extends JpaRepository<StatusSchema, Long> {
    List<StatusSchema> findAllByNome(String nome)
}
