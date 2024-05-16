package fiap.com.fforder.entity.cliente.model

import fiap.com.fforder.entity.AbstractEntity

class Cliente  extends AbstractEntity<Long> {
    String nome
    String email
    String cpf
}
