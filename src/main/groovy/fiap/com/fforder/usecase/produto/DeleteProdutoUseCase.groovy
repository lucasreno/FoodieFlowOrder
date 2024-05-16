package fiap.com.fforder.usecase.produto

import fiap.com.fforder.entity.produto.exception.ProdutoNotFoundException
import fiap.com.fforder.entity.produto.gateway.ProdutoGateway

class DeleteProdutoUseCase {
    private final ProdutoGateway produtoGateway

    DeleteProdutoUseCase(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway
    }

    void execute(Long id) {
        produtoGateway.findById(id).orElseThrow { new ProdutoNotFoundException() }
        produtoGateway.delete(id)
    }
}
