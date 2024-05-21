package fiap.com.fforder.infrastructure.produto.gateway

import fiap.com.fforder.entity.produto.gateway.ProdutoGateway
import fiap.com.fforder.entity.produto.model.Produto
import fiap.com.fforder.infrastructure.config.db.repository.ProdutoRepository
import fiap.com.fforder.infrastructure.config.db.schema.CategoriaSchema
import fiap.com.fforder.infrastructure.config.db.schema.IngredienteSchema
import fiap.com.fforder.infrastructure.config.db.schema.ProdutoSchema

class ProdutoDatabaseGateway implements ProdutoGateway{

    private final ProdutoRepository produtoRepository

    ProdutoDatabaseGateway(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository
    }

    @Override
    Produto create(Produto produto) {
        CategoriaSchema categoriaSchema = new CategoriaSchema(id: produto.categoria.id)
        Set<IngredienteSchema> ingredientesSchema = produto.ingredientes.collect { new IngredienteSchema(id: it.id) }
        ProdutoSchema produtoSchema = new ProdutoSchema(nome: produto.nome, descricao: produto.descricao, preco: produto.preco, categoria: categoriaSchema, ingredientes: ingredientesSchema)
        produtoRepository.save(produtoSchema).toProduto()
    }

    @Override
    Produto update(Produto produto) {
        CategoriaSchema categoriaSchema = new CategoriaSchema(id: produto.categoria.id)
        Set<IngredienteSchema> ingredientesSchema = produto.ingredientes.collect { new IngredienteSchema(id: it.id) }
        ProdutoSchema produtoSchema = new ProdutoSchema(id: produto.id, nome: produto.nome, descricao: produto.descricao, preco: produto.preco, categoria: categoriaSchema, ingredientes: ingredientesSchema)
        produtoRepository.save(produtoSchema).toProduto()
    }

    @Override
    void delete(Long id) {
        produtoRepository.deleteById(id)
    }

    @Override
    Optional<Produto> findById(Long id) {
        produtoRepository.findById(id).map { it.toProduto() }
    }

    @Override
    List<Produto> findAll() {
        produtoRepository.findAll().collect { it.toProduto() }
    }

    @Override
    List<Produto> findAllByCategoriaId(Long categoriaId) {
        List<Produto> produtos = produtoRepository.findAllByCategoriaId(categoriaId).collect { it.toProduto() }
        return produtos ?: []
    }

    @Override
    List<Produto> findAllByNome(String nome) {
        List<Produto> produtos = produtoRepository.findAllByNome(nome).collect { it.toProduto() }
        return produtos ?: []
    }
}
