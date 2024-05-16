package fiap.com.fforder

import fiap.com.fforder.entity.categoria.model.Categoria
import fiap.com.fforder.entity.produto.exception.ProdutoAlreadyExistsException
import fiap.com.fforder.entity.produto.exception.ProdutoNotFoundException
import fiap.com.fforder.entity.produto.model.Produto
import fiap.com.fforder.usecase.categoria.FindCategoriaByNomeUseCase
import fiap.com.fforder.usecase.produto.CreateProdutoUseCase
import fiap.com.fforder.usecase.produto.DeleteProdutoUseCase
import fiap.com.fforder.usecase.produto.FindAllProdutoUseCase
import fiap.com.fforder.usecase.produto.FindProdutoByCategoriaUseCase
import fiap.com.fforder.usecase.produto.FindProdutoByNomeUseCase
import fiap.com.fforder.usecase.produto.FindProdutoUseCase
import fiap.com.fforder.usecase.produto.UpdateProdutoUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles("test")
class ProdutoTest extends Specification {

    @Autowired
    CreateProdutoUseCase createProdutoUseCase

    @Autowired
    DeleteProdutoUseCase deleteProdutoUseCase

    @Autowired
    FindAllProdutoUseCase findAllProdutoUseCase

    @Autowired
    FindProdutoByCategoriaUseCase findProdutoByCategoriaUseCase

    @Autowired
    FindProdutoByNomeUseCase findProdutoByNomeUseCase

    @Autowired
    FindProdutoUseCase findProdutoUseCase

    @Autowired
    UpdateProdutoUseCase updateProdutoUseCase

    @Autowired
    FindCategoriaByNomeUseCase findCategoriaByNomeUseCase

    private Categoria getCategoria(String nome) {
        return findCategoriaByNomeUseCase.execute(nome).get(0)
    }

    private Categoria getCategoriaAcompanhamento() {
        return getCategoria("Acompanhamento")
    }

    def "Create Produto with same nome"() {
        given:
        Produto produto = new Produto(nome: "Produto 1", descricao: "Descricao 1", preco: 10.0, categoria: getCategoriaAcompanhamento())
        createProdutoUseCase.execute(produto)
        when:
        createProdutoUseCase.execute(produto)
        then:
        thrown ProdutoAlreadyExistsException
    }

    def "Delete Produto"() {
        given:
        Produto produto = new Produto(nome: "Produto 2", descricao: "Descricao 2", preco: 10.0, categoria: getCategoriaAcompanhamento())
        Produto produtoCriado = createProdutoUseCase.execute(produto)
        when:
        deleteProdutoUseCase.execute(produtoCriado.id)
        then:
        findAllProdutoUseCase.execute().findAll { it.id == produtoCriado.id }.isEmpty()
    }

    def "Delete Produto not found"() {
        when:
        deleteProdutoUseCase.execute(9999L)
        then:
        thrown ProdutoNotFoundException
    }

    def "Find Produto by Categoria"() {
        given:
        Produto produto = new Produto(nome: "Produto 3", descricao: "Descricao 3", preco: 10.0, categoria: getCategoriaAcompanhamento())
        Produto produtoCriado = createProdutoUseCase.execute(produto)
        when:
        List<Produto> produtos = findProdutoByCategoriaUseCase.execute(produtoCriado.categoria.id)
        then:
        produtos.size() >= 1
        produtos.find { it.id == produtoCriado.id } != null
    }

    def "Find Produto by Categoria not found"() {
        when:
        findProdutoByCategoriaUseCase.execute(9999L)
        then:
        thrown ProdutoNotFoundException
    }

    def "Find Produto by Nome"() {
        given:
        Produto produto = new Produto(nome: "Produto 4", descricao: "Descricao 4", preco: 10.0, categoria: getCategoriaAcompanhamento())
        Produto produtoCriado = createProdutoUseCase.execute(produto)
        when:
        List<Produto> produtos = findProdutoByNomeUseCase.execute(produtoCriado.nome)
        then:
        produtos.size() >= 1
        produtos.find { it.id == produtoCriado.id } != null
    }

    def "Find Produto by Nome not found"() {
        when:
        findProdutoByNomeUseCase.execute("Produto 0")
        then:
        thrown ProdutoNotFoundException
    }

    def "Find produto"() {
        given:
        Produto produto = new Produto(nome: "Produto 5", descricao: "Descricao 5", preco: 10.0, categoria: getCategoriaAcompanhamento())
        Produto produtoCriado = createProdutoUseCase.execute(produto)
        when:
        Produto produtoEncontrado = findProdutoUseCase.execute(produtoCriado.id)
        then:
        produtoEncontrado.id == produtoCriado.id
    }

    def "Find produto not found"() {
        when:
        findProdutoUseCase.execute(9999L)
        then:
        thrown ProdutoNotFoundException
    }

    def "Update Produto"() {
        given:
        Produto produto = new Produto(nome: "Produto 6", descricao: "Descricao 6", preco: 10.0, categoria: getCategoriaAcompanhamento())
        Produto produtoCriado = createProdutoUseCase.execute(produto)
        when:
        produtoCriado.nome = "Produto 6 Atualizado"
        updateProdutoUseCase.execute(produtoCriado)
        then:
        findProdutoUseCase.execute(produtoCriado.id).nome == "Produto 6 Atualizado"
    }

    def "Update Produto not found"() {
        when:
        updateProdutoUseCase.execute(new Produto(id: 9999L, nome: "Produto 7", descricao: "Descricao 7", preco: 10.0, categoria: getCategoriaAcompanhamento()))
        then:
        thrown ProdutoNotFoundException
    }


}
