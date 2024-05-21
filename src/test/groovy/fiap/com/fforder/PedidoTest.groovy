package fiap.com.fforder

import fiap.com.fforder.entity.cliente.model.Cliente
import fiap.com.fforder.entity.pedido.exception.PedidoAlreadyExistsException
import fiap.com.fforder.entity.pedido.exception.PedidoNotFoundException
import fiap.com.fforder.entity.pedido.model.Pedido
import fiap.com.fforder.entity.produto.model.Produto
import fiap.com.fforder.entity.status.model.Status
import fiap.com.fforder.usecase.cliente.FindClienteByNomeUseCase
import fiap.com.fforder.usecase.pedido.CreatePedidoUseCase
import fiap.com.fforder.usecase.pedido.DeletePedidoUseCase
import fiap.com.fforder.usecase.pedido.FindAllPedidoUseCase
import fiap.com.fforder.usecase.pedido.FindPedidoByClienteUseCase
import fiap.com.fforder.usecase.pedido.FindPedidoByCodigoUseCase
import fiap.com.fforder.usecase.pedido.FindPedidoByStatusUseCase
import fiap.com.fforder.usecase.pedido.FindPedidoUseCase
import fiap.com.fforder.usecase.pedido.UpdatePedidoUseCase
import fiap.com.fforder.usecase.produto.FindProdutoByNomeUseCase
import fiap.com.fforder.usecase.status.FindStatusByNomeUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles("test")
class PedidoTest extends Specification {
    @Autowired
    CreatePedidoUseCase createPedidoUseCase

    @Autowired
    DeletePedidoUseCase deletePedidoUseCase

    @Autowired
    FindAllPedidoUseCase findAllPedidoUseCase

    @Autowired
    FindPedidoByClienteUseCase findPedidoByClienteUseCase

    @Autowired
    FindPedidoByCodigoUseCase findPedidoByCodigoUseCase

    @Autowired
    FindPedidoByStatusUseCase findPedidoByStatusUseCase

    @Autowired
    FindPedidoUseCase findPedidoUseCase

    @Autowired
    UpdatePedidoUseCase updatePedidoUseCase

    @Autowired
    FindProdutoByNomeUseCase findProdutoByNomeUseCase

    @Autowired
    FindStatusByNomeUseCase findStatusByNomeUseCase

    @Autowired
    FindClienteByNomeUseCase findClienteByNomeUseCase

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

    def "Create Pedido with same codigo"() {
        given:
        Pedido pedido = new Pedido(cliente: getCliente('John Doe'), status: getStatus('Recebido'), produtos: getProdutos(['Hambúrguer Clássico', 'Batata Frita', 'Refrigerante']))
        createPedidoUseCase.execute(pedido)
        when:
        createPedidoUseCase.execute(pedido)
        then:
        thrown PedidoAlreadyExistsException
    }

    def "Delete Pedido"() {
        given:
        Pedido pedido = new Pedido(cliente: getCliente('John Doe'), status: getStatus('Recebido'), produtos: getProdutos(['Hambúrguer Clássico', 'Batata Frita', 'Refrigerante']))
        Pedido pedidoCriado = createPedidoUseCase.execute(pedido)
        when:
        deletePedidoUseCase.execute(pedidoCriado.id)
        then:
        findAllPedidoUseCase.execute().findAll { it.codigo == pedidoCriado.codigo }.isEmpty()
    }

    def "Delete Pedido not found"() {
        when:
        deletePedidoUseCase.execute(9999L)
        then:
        thrown PedidoNotFoundException
    }

    def "Find Pedido by Cliente"() {
        given:
        Pedido pedido = new Pedido(cliente: getCliente('John Doe'), status: getStatus('Recebido'), produtos: getProdutos(['Hambúrguer Clássico', 'Batata Frita', 'Refrigerante']))
        Pedido pedidoCriado = createPedidoUseCase.execute(pedido)
        when:
        List<Pedido> pedidos = findPedidoByClienteUseCase.execute(pedidoCriado.cliente.id)
        then:
        pedidos.size() >= 1
        pedidos.find { it.id == pedidoCriado.id } != null
    }

    def "Find Pedido by Cliente not found"() {
        when:
        findPedidoByClienteUseCase.execute(9999L)
        then:
        thrown PedidoNotFoundException
    }

    def "Find Pedido by Codigo"() {
        given:
        Pedido pedido = new Pedido(cliente: getCliente('John Doe'), status: getStatus('Recebido'), produtos: getProdutos(['Hambúrguer Clássico', 'Batata Frita', 'Refrigerante']))
        Pedido pedidoCriado = createPedidoUseCase.execute(pedido)
        when:
        List<Pedido> pedidos = findPedidoByCodigoUseCase.execute(pedidoCriado.codigo)
        then:
        pedidos.size() == 1
        pedidos[0].id == pedidoCriado.id
    }

    def "Find Pedido by Codigo not found"() {
        when:
        findPedidoByCodigoUseCase.execute('9999')
        then:
        thrown PedidoNotFoundException
    }

    def "Find Pedido by Status"() {
        given:
        Pedido pedido = new Pedido(cliente: getCliente('John Doe'), status: getStatus('Recebido'), produtos: getProdutos(['Hambúrguer Clássico', 'Batata Frita', 'Refrigerante']))
        Pedido pedidoCriado = createPedidoUseCase.execute(pedido)
        when:
        List<Pedido> pedidos = findPedidoByStatusUseCase.execute(pedidoCriado.status.id)
        then:
        pedidos.size() >= 1
        pedidos.find { it.id == pedidoCriado.id } != null
    }

    def "Find Pedido by Status not found"() {
        when:
        findPedidoByStatusUseCase.execute(9999L)
        then:
        thrown PedidoNotFoundException
    }

    def "Find Pedido"() {
        given:
        Pedido pedido = new Pedido(cliente: getCliente('John Doe'), status: getStatus('Recebido'), produtos: getProdutos(['Hambúrguer Clássico', 'Batata Frita', 'Refrigerante']))
        Pedido pedidoCriado = createPedidoUseCase.execute(pedido)
        when:
        Pedido pedidoEncontrado = findPedidoUseCase.execute(pedidoCriado.id)
        then:
        pedidoEncontrado.id == pedidoCriado.id
    }

    def "Find Pedido not found"() {
        when:
        findPedidoUseCase.execute(9999L)
        then:
        thrown PedidoNotFoundException
    }

    def "Update Pedido"() {
        given:
        Pedido pedido = new Pedido(cliente: getCliente('John Doe'), status: getStatus('Recebido'), produtos: getProdutos(['Hambúrguer Clássico', 'Batata Frita', 'Refrigerante']))
        Pedido pedidoCriado = createPedidoUseCase.execute(pedido)
        pedidoCriado.status = getStatus('Em preparação')
        when:
        Pedido pedidoAtualizado = updatePedidoUseCase.execute(pedidoCriado)
        then:
        pedidoAtualizado.id == pedidoCriado.id
        pedidoAtualizado.status.id == getStatus('Em preparação').id
    }

    def "Update Pedido not found"() {
        when:
        updatePedidoUseCase.execute(new Pedido(id: 9999L))
        then:
        thrown PedidoNotFoundException
    }

}
