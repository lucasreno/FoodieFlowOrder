package fiap.com.fforder.entity.cliente.exception

import jakarta.persistence.EntityNotFoundException

class ClienteNotFoundException extends EntityNotFoundException {
    ClienteNotFoundException() {
        super("Cliente não encontrado")
    }
}
