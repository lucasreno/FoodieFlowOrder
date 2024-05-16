package fiap.com.fforder.infrastructure.initializer

import fiap.com.fforder.entity.imagem.model.Imagem
import fiap.com.fforder.entity.produto.model.Produto
import fiap.com.fforder.usecase.imagem.CreateImagemUseCase
import fiap.com.fforder.usecase.produto.FindProdutoByNomeUseCase

class ImagemInitializer {

    private final CreateImagemUseCase createImagemUseCase
    private final FindProdutoByNomeUseCase findProdutoByNomeUseCase

    ImagemInitializer(CreateImagemUseCase createImagemUseCase, FindProdutoByNomeUseCase findProdutoByNomeUseCase) {
        this.createImagemUseCase = createImagemUseCase
        this.findProdutoByNomeUseCase = findProdutoByNomeUseCase
        this.init()
    }

    private Produto getProduto(String nome) {
        return findProdutoByNomeUseCase.execute(nome).get(0)
    }

    void init() {
        println "Inicializando imagens..."

        List<Imagem> IMAGENS = [new Imagem(caminho: 'https://cdn.pixabay.com/photo/2016/03/05/19/02/hamburger-1238246_960_720.jpg', produto: getProduto('Hambúrguer Clássico')),
                                new Imagem(caminho: 'https://cdn.pixabay.com/photo/2016/03/05/19/02/hamburger-1238246_960_720.jpg', produto: getProduto('Big Bacon Burger')),
                                new Imagem(caminho: 'https://cdn.pixabay.com/photo/2016/03/05/19/02/hamburger-1238246_960_720.jpg', produto: getProduto('Hambúrguer Vegetariano')),
                                new Imagem(caminho: 'https://cdn.pixabay.com/photo/2016/03/05/19/02/hamburger-1238246_960_720.jpg', produto: getProduto('Batata Frita')),
                                new Imagem(caminho: 'https://cdn.pixabay.com/photo/2016/03/05/19/02/hamburger-1238246_960_720.jpg', produto: getProduto('Onion Rings')),
                                new Imagem(caminho: 'https://cdn.pixabay.com/photo/2016/03/05/19/02/hamburger-1238246_960_720.jpg', produto: getProduto('Água Mineral')),
                                new Imagem(caminho: 'https://cdn.pixabay.com/photo/2016/03/05/19/02/hamburger-1238246_960_720.jpg', produto: getProduto('Refrigerante')),
                                new Imagem(caminho: 'https://cdn.pixabay.com/photo/2016/03/05/19/02/hamburger-1238246_960_720.jpg', produto: getProduto('Suco de Laranja')),
                                new Imagem(caminho: 'https://cdn.pixabay.com/photo/2016/03/05/19/02/hamburger-1238246_960_720.jpg', produto: getProduto('Sorvete de Chocolate'))]

        IMAGENS.each {
            try {
                createImagemUseCase.execute(it)
            } catch (Exception e) {
                // do nothing
            }
        }
    }
}
