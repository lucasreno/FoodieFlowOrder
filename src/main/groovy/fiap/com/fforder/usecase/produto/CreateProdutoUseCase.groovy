package fiap.com.fforder.usecase.produto

import fiap.com.fforder.entity.produto.exception.ProdutoAlreadyExistsException
import fiap.com.fforder.entity.produto.gateway.ProdutoGateway
import fiap.com.fforder.entity.produto.model.Produto

class CreateProdutoUseCase {
    private final ProdutoGateway produtoGateway

    CreateProdutoUseCase(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway
    }

    Produto execute(Produto produto) {
        if(produtoGateway.findAllByNome(produto.nome).isEmpty()) {
            return produtoGateway.create(produto)
        } else {
            throw new ProdutoAlreadyExistsException()
        }
    }
}
