package fiap.com.fforder.entity.ingrediente.exception

import jakarta.persistence.EntityNotFoundException

class IngredienteNotFoundException extends EntityNotFoundException {
    IngredienteNotFoundException() {
        super("Ingrediente não encontrado")
    }
}