package fiap.com.fforder.entity.categoria.exception

import jakarta.persistence.EntityNotFoundException

class CategoriaNotFoundException extends EntityNotFoundException {
    CategoriaNotFoundException() {
        super("Categoria não encontrada")
    }
}
