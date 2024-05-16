package fiap.com.fforder.infrastructure.config.db.schema

import fiap.com.fforder.entity.imagem.model.Imagem
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "imagem")
class ImagemSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    @Column(nullable = false)
    String caminho

    @ManyToOne
    @JoinColumn(name = "produto_id")
    ProdutoSchema produto

    Imagem toImagem() {
        new Imagem(id: id,
                caminho: caminho,
                produto: produto?.toProduto())
    }
}
