package fiap.com.fforder.infrastructure.initializer


import fiap.com.fforder.entity.categoria.model.Categoria
import fiap.com.fforder.entity.ingrediente.model.Ingrediente
import fiap.com.fforder.entity.produto.model.Produto
import fiap.com.fforder.usecase.categoria.FindCategoriaByNomeUseCase
import fiap.com.fforder.usecase.ingrediente.FindIngredienteByNomeUseCase
import fiap.com.fforder.usecase.produto.CreateProdutoUseCase

class ProdutoInitializer {

    private final CreateProdutoUseCase createProdutoUseCase
    private final FindIngredienteByNomeUseCase findIngredienteByNomeUseCase
    private final FindCategoriaByNomeUseCase findCategoriaByNomeUseCase

    ProdutoInitializer(CreateProdutoUseCase createProdutoUseCase, FindIngredienteByNomeUseCase findIngredienteByNomeUseCase, FindCategoriaByNomeUseCase findCategoriaByNomeUseCase) {
        this.createProdutoUseCase = createProdutoUseCase
        this.findIngredienteByNomeUseCase = findIngredienteByNomeUseCase
        this.findCategoriaByNomeUseCase = findCategoriaByNomeUseCase
        this.init()
    }

    private Categoria getCategoria(String nome) {
        return findCategoriaByNomeUseCase.execute(nome).get(0)
    }

    private List<Ingrediente> getIngredientes(List<String> nomes) {
        List<Ingrediente> ingredientes = []
        nomes.each {
            ingredientes.add(findIngredienteByNomeUseCase.execute(it).get(0))
        }
        return ingredientes
    }

    void init() {
        println "Inicializando produtos..."

        List<Produto> PRODUTOS = [new Produto(nome: 'Hambúrguer Clássico', descricao: 'Um delicioso hambúrguer de carne grelhada, queijo derretido, alface fresca, tomate e molho especial, tudo servido em um pão macio.', preco: 15, categoria: getCategoria('Lanche'), ingredientes: getIngredientes(['Pão', 'Hambúrguer de Carne', 'Queijo', 'Alface', 'Tomate', 'Molho Especial'])),
                                  new Produto(nome: 'Big Bacon Burger', descricao: 'Um delicioso hambúrguer de carne grelhada, queijo derretido, alface fresca, bacon e molho especial, tudo servido em um pão macio.', preco: 18, categoria: getCategoria('Lanche'), ingredientes: getIngredientes(['Pão', 'Hambúrguer de Carne', 'Queijo', 'Alface', 'Bacon', 'Molho Especial'])),
                                  new Produto(nome: 'Hambúrguer Vegetariano', descricao: 'Um delicioso queijo derretido, alface fresca, tomate, picles e molho especial, tudo servido em um pão macio.', preco: 12, categoria: getCategoria('Lanche'), ingredientes: getIngredientes(['Pão', 'Queijo', 'Alface', 'Tomate', 'Picles', 'Molho Especial'])),
                                  new Produto(nome: 'Batata Frita', descricao: 'Porção de batata frita crocante e sequinha.', preco: 5, categoria: getCategoria('Acompanhamento'), ingredientes: getIngredientes(['Batata Frita'])),
                                  new Produto(nome: 'Onion Rings', descricao: 'Porção de anéis de cebola empanados e fritos.', preco: 5, categoria: getCategoria('Acompanhamento'), ingredientes: getIngredientes(['Onion Rings'])),
                                  new Produto(nome: 'Água Mineral', descricao: 'Garrafa de água mineral sem gás.', preco: 3, categoria: getCategoria('Bebida'), ingredientes: getIngredientes(['Água'])),
                                  new Produto(nome: 'Refrigerante', descricao: 'Lata de refrigerante de cola.', preco: 4, categoria: getCategoria('Bebida'), ingredientes: getIngredientes(['Refrigerante'])),
                                  new Produto(nome: 'Suco de Laranja', descricao: 'Copo de suco de laranja natural.', preco: 5, categoria: getCategoria('Bebida'), ingredientes: getIngredientes(['Suco de Laranja'])),
                                  new Produto(nome: 'Sorvete de Chocolate', descricao: 'Taça de sorvete de chocolate com calda de chocolate e chantilly.', preco: 8, categoria: getCategoria('Sobremesa'), ingredientes: getIngredientes(['Sorvete', 'Calda de Chocolate', 'Chantilly']))]

        PRODUTOS.each {
            try {
                createProdutoUseCase.execute(it)
            } catch (Exception e) {
                // do nothing
            }
        }
    }
}
