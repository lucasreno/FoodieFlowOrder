package fiap.com.fforder.entity.categoria.exception;

import jakarta.persistence.EntityExistsException;

public class CategoriaAlreadyExistsException extends EntityExistsException {
    public CategoriaAlreadyExistsException() {
        super("Categoria já cadastrada");
    }
}
