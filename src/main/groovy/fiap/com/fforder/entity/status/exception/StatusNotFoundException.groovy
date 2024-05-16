package fiap.com.fforder.entity.status.exception

import jakarta.persistence.EntityExistsException

class StatusNotFoundException extends EntityExistsException {
    StatusNotFoundException() {
        super("Status não encontrado")
    }
}
