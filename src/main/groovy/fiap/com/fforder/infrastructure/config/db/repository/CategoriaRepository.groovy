package fiap.com.fforder.infrastructure.config.db.repository

import fiap.com.fforder.infrastructure.config.db.schema.CategoriaSchema
import org.springframework.data.jpa.repository.JpaRepository

interface CategoriaRepository extends JpaRepository<CategoriaSchema, Long> {
    List<CategoriaSchema> findAllByNome(String nome)
}
