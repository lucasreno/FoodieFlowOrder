package fiap.com.fforder.entity.imagem.model

import fiap.com.fforder.entity.AbstractEntity
import fiap.com.fforder.entity.produto.model.Produto

class Imagem extends AbstractEntity<Long> {
    String caminho
    Produto produto
}
