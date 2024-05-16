package fiap.com.fforder

import fiap.com.fforder.entity.imagem.exception.ImagemAlreadyExistsException
import fiap.com.fforder.entity.imagem.exception.ImagemNotFoundException
import fiap.com.fforder.entity.imagem.model.Imagem
import fiap.com.fforder.entity.produto.model.Produto
import fiap.com.fforder.usecase.imagem.CreateImagemUseCase
import fiap.com.fforder.usecase.imagem.DeleteImagemUseCase
import fiap.com.fforder.usecase.imagem.FindAllImagemUseCase
import fiap.com.fforder.usecase.imagem.FindImagemByProdutoUseCase
import fiap.com.fforder.usecase.imagem.FindImagemUseCase
import fiap.com.fforder.usecase.imagem.UpdateImagemUseCase
import fiap.com.fforder.usecase.produto.FindProdutoByNomeUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles("test")
class ImagemTest extends Specification {

    @Autowired
    CreateImagemUseCase createImagemUseCase

    @Autowired
    DeleteImagemUseCase deleteImagemUseCase

    @Autowired
    FindAllImagemUseCase findAllImagemUseCase

    @Autowired
    FindImagemByProdutoUseCase findImagemByProdutoUseCase

    @Autowired
    FindImagemUseCase findImagemUseCase

    @Autowired
    UpdateImagemUseCase updateImagemUseCase

    @Autowired
    FindProdutoByNomeUseCase findProdutoByNomeUseCase

    private Produto getProduto(String nome) {
        return findProdutoByNomeUseCase.execute(nome).get(0)
    }

    def "Create Imagem with same produto"() {
        given:
        Produto produto = getProduto('Big Bacon Burger')
        Imagem imagem = new Imagem(produto: produto, caminho: "http://url.com.br/2.jpg")

        when:
        createImagemUseCase.execute(imagem)
        createImagemUseCase.execute(imagem)

        then:
        thrown ImagemAlreadyExistsException
    }

    def "Delete Imagem"() {
        given:
        Produto produto = getProduto('Hambúrguer Vegetariano')
        Imagem imagem = new Imagem(produto: produto, caminho: "http://url.com.br/3.jpg")
        Imagem imagemCriada = createImagemUseCase.execute(imagem)

        when:
        deleteImagemUseCase.execute(imagemCriada.id)

        then:
        noExceptionThrown()
    }

    def "Delete Imagem not found"() {
        when:
        deleteImagemUseCase.execute(9999)

        then:
        thrown ImagemNotFoundException
    }

    def "Find all Imagem"() {
        given:
        Produto produto = getProduto('Batata Frita')
        Imagem imagem = new Imagem(produto: produto, caminho: "http://url.com.br/4.jpg")
        Imagem imagemCriada = createImagemUseCase.execute(imagem)

        when:
        List<Imagem> imagens = findAllImagemUseCase.execute()

        then:
        imagens.size() >= 1
        imagens.find { it.id == imagemCriada.id } != null
    }

    def "Find Imagem by Produto"() {
        given:
        Produto produto = getProduto('Onion Rings')

        when:
        List<Imagem> imagensEncontradas = findImagemByProdutoUseCase.execute(produto.id)

        then:
        imagensEncontradas.size() >= 1
    }

    def "Find Imagem by id"() {
        given:
        Produto produto = getProduto('Água Mineral')
        Imagem imagem = new Imagem(produto: produto, caminho: "http://url.com.br/6.jpg")
        Imagem imagemCriada = createImagemUseCase.execute(imagem)

        when:
        Imagem imagemEncontrada = findImagemUseCase.execute(imagemCriada.id)

        then:
        imagemEncontrada.produto.id == produto.id
        imagemEncontrada.id == imagemCriada.id
        imagemEncontrada.caminho == imagemCriada.caminho
    }

    def "Find Imagem not found"() {
        when:
        findImagemUseCase.execute(9999)

        then:
        thrown ImagemNotFoundException
    }

    def "Update Imagem"() {
        given:
        Produto produto = getProduto('Refrigerante')
        Imagem imagem = new Imagem(produto: produto, caminho: "http://url.com.br/7.jpg")
        Imagem imagemCriada = createImagemUseCase.execute(imagem)

        when:
        Imagem imagemAtualizada = new Imagem(id: imagemCriada.id, produto: produto, caminho: "http://url.com.br/7_atualizada.jpg")
        Imagem imagemAtualizadaCriada = updateImagemUseCase.execute(imagemAtualizada)

        then:
        imagemAtualizadaCriada.produto.id == produto.id
        imagemAtualizadaCriada.id == imagemCriada.id
        imagemAtualizadaCriada.caminho == imagemAtualizada.caminho
    }

    def "Update Imagem not found"() {
        when:
        Produto produto = getProduto('Suco de Laranja')
        Imagem imagem = new Imagem(id: 9999, produto: produto, caminho: "http://url.com.br/8.jpg")
        updateImagemUseCase.execute(imagem)

        then:
        thrown ImagemNotFoundException
    }
}
