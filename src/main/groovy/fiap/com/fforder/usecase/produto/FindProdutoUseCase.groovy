package fiap.com.fforder.usecase.produto

import fiap.com.fforder.entity.produto.exception.ProdutoNotFoundException
import fiap.com.fforder.entity.produto.gateway.ProdutoGateway

class FindProdutoUseCase {
    private final ProdutoGateway produtoGateway

    FindProdutoUseCase(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway
    }

    def execute(Long id) {
        produtoGateway.findById(id).orElseThrow { new ProdutoNotFoundException() }
    }
}
