package fiap.com.fforder.usecase.produto

import fiap.com.fforder.entity.produto.exception.ProdutoNotFoundException
import fiap.com.fforder.entity.produto.gateway.ProdutoGateway
import fiap.com.fforder.entity.produto.model.Produto

class FindProdutoByNomeUseCase {
    private final ProdutoGateway produtoGateway

    FindProdutoByNomeUseCase(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway
    }

    List<Produto> execute(String nome) {
        List<Produto> produtos = produtoGateway.findAllByNome(nome)
        if (produtos.isEmpty()) {
            throw new ProdutoNotFoundException()
        }
        return produtos
    }
}
