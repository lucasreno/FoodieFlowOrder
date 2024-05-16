package fiap.com.fforder.entity.ingrediente.exception

import jakarta.persistence.EntityExistsException

class IngredienteAlreadyExistsException extends EntityExistsException {
    IngredienteAlreadyExistsException() {
        super("Ingrediente já existe")
    }
}
