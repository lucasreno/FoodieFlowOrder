package fiap.com.fforder.infrastructure.config.db.repository

import fiap.com.fforder.infrastructure.config.db.schema.IngredienteSchema
import org.springframework.data.jpa.repository.JpaRepository

interface IngredienteRepository extends JpaRepository<IngredienteSchema, Long> {
    List<IngredienteSchema> findAllByNome(String nome)
}
