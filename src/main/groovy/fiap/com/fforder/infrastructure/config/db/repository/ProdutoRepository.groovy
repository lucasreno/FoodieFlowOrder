package fiap.com.fforder.infrastructure.config.db.repository

import fiap.com.fforder.infrastructure.config.db.schema.ProdutoSchema
import org.springframework.data.jpa.repository.JpaRepository

interface ProdutoRepository extends JpaRepository<ProdutoSchema, Long> {
    List<ProdutoSchema> findAllByNome(String nome)
    List<ProdutoSchema> findAllByCategoriaId(Long categoriaId)
}