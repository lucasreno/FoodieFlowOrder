package fiap.com.fforder.usecase.produto

import fiap.com.fforder.entity.produto.exception.ProdutoNotFoundException
import fiap.com.fforder.entity.produto.gateway.ProdutoGateway
import fiap.com.fforder.entity.produto.model.Produto

class UpdateProdutoUseCase {
    private final ProdutoGateway produtoGateway

    UpdateProdutoUseCase(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway
    }

    void execute(Produto produto) {
        produtoGateway.findById(produto.id).orElseThrow { new ProdutoNotFoundException() }
        produtoGateway.update(produto)
    }
}
