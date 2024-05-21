package fiap.com.fforder.infrastructure.initializer

import fiap.com.fforder.entity.cliente.model.Cliente
import fiap.com.fforder.entity.pedido.model.Pedido
import fiap.com.fforder.entity.produto.model.Produto
import fiap.com.fforder.entity.status.model.Status
import fiap.com.fforder.usecase.cliente.FindClienteByNomeUseCase
import fiap.com.fforder.usecase.pedido.CreatePedidoUseCase
import fiap.com.fforder.usecase.pedido.FindAllPedidoUseCase
import fiap.com.fforder.usecase.produto.FindProdutoByNomeUseCase
import fiap.com.fforder.usecase.status.FindStatusByNomeUseCase

class PedidoInitializer {

    private final CreatePedidoUseCase createPedidoUseCase
    private final FindProdutoByNomeUseCase findProdutoByNomeUseCase
    private final FindStatusByNomeUseCase findStatusByNomeUseCase
    private final FindClienteByNomeUseCase findClienteByNomeUseCase
    private final FindAllPedidoUseCase findAllPedidoUseCase

    PedidoInitializer(CreatePedidoUseCase createPedidoUseCase, FindProdutoByNomeUseCase findProdutoByNomeUseCase, FindStatusByNomeUseCase findStatusByNomeUseCase, FindClienteByNomeUseCase findClienteByNomeUseCase, FindAllPedidoUseCase findAllPedidoUseCase) {
        this.createPedidoUseCase = createPedidoUseCase
        this.findProdutoByNomeUseCase = findProdutoByNomeUseCase
        this.findStatusByNomeUseCase = findStatusByNomeUseCase
        this.findClienteByNomeUseCase = findClienteByNomeUseCase
        this.findAllPedidoUseCase = findAllPedidoUseCase
        this.init()
    }

    private List<Produto> getProdutos(List<String> nomes) {
        List<Produto> produtos = []
        nomes.each {
            produtos.add(findProdutoByNomeUseCase.execute(it).get(0))
        }
        return produtos
    }

    private Status getStatus(String nome) {
        return findStatusByNomeUseCase.execute(nome).get(0)
    }

    private Cliente getCliente(String nome) {
        return findClienteByNomeUseCase.execute(nome).get(0)
    }

    void init() {
        println "Inicializando pedidos..."

        if (findAllPedidoUseCase.execute().size() > 0) {
            return
        }

        List<Pedido> PEDIDOS = [new Pedido(cliente: getCliente('John Doe'), status: getStatus('Recebido'), produtos: getProdutos(['Hambúrguer Clássico', 'Batata Frita', 'Refrigerante'])),
                                new Pedido(cliente: getCliente('Jane Smith'), status: getStatus('Recebido'), produtos: getProdutos(['Big Bacon Burger', 'Onion Rings', 'Água Mineral'])),
                                new Pedido(cliente: getCliente('Bob Johnson'), status: getStatus('Finalizado'), produtos: getProdutos(['Hambúrguer Vegetariano', 'Batata Frita', 'Suco de Laranja'])),
                                new Pedido(cliente: getCliente('Bob Johnson'), status: getStatus('Em preparação'), produtos: getProdutos(['Hambúrguer Clássico', 'Onion Rings', 'Refrigerante'])),
                                new Pedido(cliente: getCliente('Alice Williams'), status: getStatus('Pronto'), produtos: getProdutos(['Big Bacon Burger', 'Batata Frita', 'Água Mineral']))]

        PEDIDOS.each {
            try {
                createPedidoUseCase.execute(it)
            } catch (Exception e) {
                // do nothing
            }
        }
    }
}
