package fiap.com.fforder.entity.status.exception

import jakarta.persistence.EntityExistsException

class StatusAlreadyExistsException extends EntityExistsException {
    StatusAlreadyExistsException() {
        super("Status já existe")
    }
}
