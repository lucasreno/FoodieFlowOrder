package fiap.com.fforder.entity.produto.model

import fiap.com.fforder.entity.AbstractEntity
import fiap.com.fforder.entity.categoria.model.Categoria
import fiap.com.fforder.entity.ingrediente.model.Ingrediente

class Produto extends AbstractEntity<Long> {
    String nome
    String descricao
    BigDecimal preco
    String imagem
    Categoria categoria
    List<Ingrediente> ingredientes
}
