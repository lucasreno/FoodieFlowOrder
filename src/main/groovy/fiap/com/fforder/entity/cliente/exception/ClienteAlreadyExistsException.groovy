package fiap.com.fforder.entity.cliente.exception

import jakarta.persistence.EntityExistsException

class ClienteAlreadyExistsException extends EntityExistsException {
    ClienteAlreadyExistsException() {
        super("Cliente já cadastrado")
    }
}
