package fiap.com.fforder.entity.imagem.exception

import jakarta.persistence.EntityNotFoundException

class ImagemNotFoundException extends EntityNotFoundException {
    ImagemNotFoundException() { super("Imagem não encontrada") }
}
