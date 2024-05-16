package fiap.com.fforder.infrastructure.config.db.repository

import fiap.com.fforder.infrastructure.config.db.schema.ImagemSchema
import org.springframework.data.jpa.repository.JpaRepository

interface ImagemRepository extends JpaRepository<ImagemSchema, Long> {
    List<ImagemSchema> findAllByProdutoId(Long produtoId)
    ImagemSchema findByCaminhoAndProdutoId(String caminho, Long produtoId)
}
