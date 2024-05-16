package fiap.com.fforder.infrastructure.config.db.schema

import fiap.com.fforder.entity.categoria.model.Categoria
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "categoria")
class CategoriaSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    @Column(nullable = false, unique = true)
    String nome

    Categoria toCategoria() {
        new Categoria(id: id, nome: nome)
    }
}
