package fiap.com.fforder.infrastructure.config.db.schema

import fiap.com.fforder.entity.cliente.model.Cliente
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "cliente")
class ClienteSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    @Column(nullable = false)
    String nome

    @Column
    String email

    @Column(unique = true)
    String cpf

    Cliente toCliente() {
        new Cliente(id: id, nome: nome, email: email, cpf: cpf)
    }
}
