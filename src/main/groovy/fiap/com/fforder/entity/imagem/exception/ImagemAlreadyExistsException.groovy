package fiap.com.fforder.entity.imagem.exception

import jakarta.persistence.EntityExistsException

class ImagemAlreadyExistsException extends EntityExistsException {
    public ImagemAlreadyExistsException() { super("Imagem já cadastrada no sistema.") }
}
