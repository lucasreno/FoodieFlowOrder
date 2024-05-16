package fiap.com.fforder.usecase.produto

import fiap.com.fforder.entity.produto.exception.ProdutoNotFoundException
import fiap.com.fforder.entity.produto.gateway.ProdutoGateway
import fiap.com.fforder.entity.produto.model.Produto

class FindProdutoByCategoriaUseCase {
    private final ProdutoGateway produtoGateway

    FindProdutoByCategoriaUseCase(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway
    }

    List<Produto> execute(Long categoriaId) {
        List<Produto> produtos = produtoGateway.findAllByCategoriaId(categoriaId)
        if (produtos.isEmpty()) {
            throw new ProdutoNotFoundException()
        }
        return produtos
    }
}
