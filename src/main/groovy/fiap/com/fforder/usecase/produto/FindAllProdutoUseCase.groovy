package fiap.com.fforder.usecase.produto

import fiap.com.fforder.entity.produto.gateway.ProdutoGateway
import fiap.com.fforder.entity.produto.model.Produto

class FindAllProdutoUseCase {
    private final ProdutoGateway produtoGateway

    FindAllProdutoUseCase(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway
    }

    List<Produto> execute() {
        produtoGateway.findAll()
    }
}
