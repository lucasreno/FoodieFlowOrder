package fiap.com.fforder.infrastructure.config.db.schema

import fiap.com.fforder.entity.produto.model.Produto
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

@Entity
@Table(name = "produto")
class ProdutoSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    @Column(nullable = false, unique = true)
    String nome

    @Column
    String descricao

    @Column(nullable = false)
    BigDecimal preco

    @Column
    String imagem

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id")
    CategoriaSchema categoria

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "produto_ingrediente",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "ingrediente_id"))
    Set<IngredienteSchema> ingredientes

    Produto toProduto() {
        new Produto(id: id,
                nome: nome,
                descricao: descricao,
                preco: preco,
                imagem: imagem,
                categoria: categoria?.toCategoria(),
                ingredientes: ingredientes.collect { it.toIngrediente() })
    }
}
