package fiap.com.fforder.infrastructure.config.db.schema

import fiap.com.fforder.entity.ingrediente.model.Ingrediente

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "ingrediente")
class IngredienteSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    @Column(nullable = false, unique = true)
    String nome

    Ingrediente toIngrediente() {
        new Ingrediente(id: id, nome: nome)
    }
}