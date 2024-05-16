package fiap.com.fforder.infrastructure.config.db.schema

import fiap.com.fforder.entity.status.model.Status
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "status")
class StatusSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    @Column(unique = true)
    String nome

    Status toStatus() {
        new Status(id: id, nome: nome)
    }
}
