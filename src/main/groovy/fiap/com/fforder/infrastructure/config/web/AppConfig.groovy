package fiap.com.fforder.infrastructure.config.web

import fiap.com.fforder.entity.categoria.gateway.CategoriaGateway
import fiap.com.fforder.entity.cliente.gateway.ClienteGateway
import fiap.com.fforder.entity.imagem.gateway.ImagemGateway
import fiap.com.fforder.entity.ingrediente.gateway.IngredienteGateway
import fiap.com.fforder.entity.pedido.gateway.PedidoGateway
import fiap.com.fforder.entity.produto.gateway.ProdutoGateway
import fiap.com.fforder.entity.status.gateway.StatusGateway
import fiap.com.fforder.infrastructure.cliente.gateway.ClienteDatabaseGateway
import fiap.com.fforder.infrastructure.config.db.repository.*
import fiap.com.fforder.infrastructure.categoria.gateway.CategoriaDatabaseGateway
import fiap.com.fforder.infrastructure.imagem.gateway.ImagemDatabaseGateway
import fiap.com.fforder.infrastructure.ingrediente.gateway.IngredienteDatabaseGateway
import fiap.com.fforder.infrastructure.initializer.*
import fiap.com.fforder.infrastructure.pedido.gateway.PedidoDatabaseGateway
import fiap.com.fforder.infrastructure.produto.gateway.ProdutoDatabaseGateway
import fiap.com.fforder.infrastructure.status.gateway.StatusDatabaseGateway
import fiap.com.fforder.usecase.categoria.*
import fiap.com.fforder.usecase.cliente.*
import fiap.com.fforder.usecase.imagem.CreateImagemUseCase
import fiap.com.fforder.usecase.imagem.DeleteImagemUseCase
import fiap.com.fforder.usecase.imagem.FindAllImagemUseCase
import fiap.com.fforder.usecase.imagem.FindImagemByProdutoUseCase
import fiap.com.fforder.usecase.imagem.FindImagemUseCase
import fiap.com.fforder.usecase.imagem.UpdateImagemUseCase
import fiap.com.fforder.usecase.ingrediente.*
import fiap.com.fforder.usecase.pedido.CreatePedidoUseCase
import fiap.com.fforder.usecase.pedido.DeletePedidoUseCase
import fiap.com.fforder.usecase.pedido.FindAllPedidoUseCase
import fiap.com.fforder.usecase.pedido.FindPedidoByClienteUseCase
import fiap.com.fforder.usecase.pedido.FindPedidoByCodigoUseCase
import fiap.com.fforder.usecase.pedido.FindPedidoByStatusUseCase
import fiap.com.fforder.usecase.pedido.FindPedidoUseCase
import fiap.com.fforder.usecase.pedido.UpdatePedidoUseCase
import fiap.com.fforder.usecase.produto.CreateProdutoUseCase
import fiap.com.fforder.usecase.produto.DeleteProdutoUseCase
import fiap.com.fforder.usecase.produto.FindProdutoByCategoriaUseCase
import fiap.com.fforder.usecase.produto.FindProdutoByNomeUseCase
import fiap.com.fforder.usecase.produto.FindAllProdutoUseCase
import fiap.com.fforder.usecase.produto.FindProdutoUseCase
import fiap.com.fforder.usecase.produto.UpdateProdutoUseCase
import fiap.com.fforder.usecase.status.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {
    @Bean
    CategoriaInitializer categoriaInitializer(CreateCategoriaUseCase createCategoriaUseCase) {
        new CategoriaInitializer(createCategoriaUseCase)
    }

    @Bean
    IngredienteInitializer ingredienteInitializer(CreateIngredienteUseCase createIngredienteUseCase) {
        new IngredienteInitializer(createIngredienteUseCase)
    }

    @Bean
    StatusInitializer statusInitializer(CreateStatusUseCase createStatusUseCase) {
        new StatusInitializer(createStatusUseCase)
    }

    @Bean
    ClienteInitializer clienteInitializer(CreateClienteUseCase createClienteUseCase) {
        new ClienteInitializer(createClienteUseCase)
    }

    @Bean
    ProdutoInitializer produtoInitializer(CreateProdutoUseCase createProdutoUseCase, FindIngredienteByNomeUseCase findIngredienteByNomeUseCase, FindCategoriaByNomeUseCase findCategoriaByNomeUseCase) {
        new ProdutoInitializer(createProdutoUseCase, findIngredienteByNomeUseCase, findCategoriaByNomeUseCase)
    }

    @Bean
    ImagemInitializer imagemInitializer(CreateImagemUseCase createImagemUseCase, FindProdutoByNomeUseCase findProdutoByNomeUseCase) {
        new ImagemInitializer(createImagemUseCase, findProdutoByNomeUseCase)
    }

    @Bean
    PedidoInitializer pedidoInitializer(CreatePedidoUseCase createPedidoUseCase, FindProdutoByNomeUseCase findProdutoByNomeUseCase, FindStatusByNomeUseCase findStatusByNomeUseCase, FindClienteByNomeUseCase findClienteByNomeUseCase, FindAllPedidoUseCase findAllPedidoUseCase) {
        new PedidoInitializer(createPedidoUseCase, findProdutoByNomeUseCase, findStatusByNomeUseCase, findClienteByNomeUseCase, findAllPedidoUseCase)
    }

    @Bean
    CreateCategoriaUseCase createCategoriaUseCase(CategoriaRepository categoriaRepository) {
        CategoriaGateway categoriaGateway = new CategoriaDatabaseGateway(categoriaRepository)
        new CreateCategoriaUseCase(categoriaGateway)
    }

    @Bean
    DeleteCategoriaUseCase deleteCategoriaUseCase(CategoriaRepository categoriaRepository) {
        CategoriaGateway categoriaGateway = new CategoriaDatabaseGateway(categoriaRepository)
        new DeleteCategoriaUseCase(categoriaGateway)
    }

    @Bean
    FindAllCategoriaUseCase getAllCategoriaUseCase(CategoriaRepository categoriaRepository) {
        CategoriaGateway categoriaGateway = new CategoriaDatabaseGateway(categoriaRepository)
        new FindAllCategoriaUseCase(categoriaGateway)
    }

    @Bean
    FindCategoriaByNomeUseCase findCategoriaByNomeUseCase(CategoriaRepository categoriaRepository) {
        CategoriaGateway categoriaGateway = new CategoriaDatabaseGateway(categoriaRepository)
        new FindCategoriaByNomeUseCase(categoriaGateway)
    }

    @Bean
    FindCategoriaUseCase getCategoriaUseCase(CategoriaRepository categoriaRepository) {
        CategoriaGateway categoriaGateway = new CategoriaDatabaseGateway(categoriaRepository)
        new FindCategoriaUseCase(categoriaGateway)
    }

    @Bean
    UpdateCategoriaUseCase updateCategoriaUseCase(CategoriaRepository categoriaRepository) {
        CategoriaGateway categoriaGateway = new CategoriaDatabaseGateway(categoriaRepository)
        new UpdateCategoriaUseCase(categoriaGateway)
    }

    @Bean
    CreateIngredienteUseCase createIngredienteUseCase(IngredienteRepository ingredienteRepository) {
        IngredienteGateway ingredienteGateway = new IngredienteDatabaseGateway(ingredienteRepository)
        new CreateIngredienteUseCase(ingredienteGateway)
    }

    @Bean
    DeleteIngredienteUseCase deleteIngredienteUseCase(IngredienteRepository ingredienteRepository) {
        IngredienteGateway ingredienteGateway = new IngredienteDatabaseGateway(ingredienteRepository)
        new DeleteIngredienteUseCase(ingredienteGateway)
    }

    @Bean
    FindIngredienteByNomeUseCase findIngredienteByNomeUseCase(IngredienteRepository ingredienteRepository) {
        IngredienteGateway ingredienteGateway = new IngredienteDatabaseGateway(ingredienteRepository)
        new FindIngredienteByNomeUseCase(ingredienteGateway)
    }

    @Bean
    FindAllIngredienteUseCase getAllIngredienteUseCase(IngredienteRepository ingredienteRepository) {
        IngredienteGateway ingredienteGateway = new IngredienteDatabaseGateway(ingredienteRepository)
        new FindAllIngredienteUseCase(ingredienteGateway)
    }

    @Bean
    FindIngredienteUseCase getIngredienteUseCase(IngredienteRepository ingredienteRepository) {
        IngredienteGateway ingredienteGateway = new IngredienteDatabaseGateway(ingredienteRepository)
        new FindIngredienteUseCase(ingredienteGateway)
    }

    @Bean
    UpdateIngredienteUseCase updateIngredienteUseCase(IngredienteRepository ingredienteRepository) {
        IngredienteGateway ingredienteGateway = new IngredienteDatabaseGateway(ingredienteRepository)
        new UpdateIngredienteUseCase(ingredienteGateway)
    }

    @Bean
    CreateStatusUseCase createStatusUseCase(StatusRepository statusRepository) {
        StatusGateway statusGateway = new StatusDatabaseGateway(statusRepository)
        new CreateStatusUseCase(statusGateway)
    }

    @Bean
    FindStatusByNomeUseCase findStatusByNomeUseCase(StatusRepository statusRepository) {
        StatusGateway statusGateway = new StatusDatabaseGateway(statusRepository)
        new FindStatusByNomeUseCase(statusGateway)
    }

    @Bean
    FindAllStatusUseCase getAllStatusUseCase(StatusRepository statusRepository) {
        StatusGateway statusGateway = new StatusDatabaseGateway(statusRepository)
        new FindAllStatusUseCase(statusGateway)
    }

    @Bean
    FindStatusUseCase getStatusUseCase(StatusRepository statusRepository) {
        StatusGateway statusGateway = new StatusDatabaseGateway(statusRepository)
        new FindStatusUseCase(statusGateway)
    }

    @Bean
    CreateClienteUseCase createClienteUseCase(ClienteRepository clienteRepository) {
        ClienteGateway clienteGateway = new ClienteDatabaseGateway(clienteRepository)
        new CreateClienteUseCase(clienteGateway)
    }

    @Bean
    DeleteClienteUseCase deleteClienteUseCase(ClienteRepository clienteRepository) {
        ClienteGateway clienteGateway = new ClienteDatabaseGateway(clienteRepository)
        new DeleteClienteUseCase(clienteGateway)
    }

    @Bean
    FindClienteByCpfUseCase findClienteByCpfUseCase(ClienteRepository clienteRepository) {
        ClienteGateway clienteGateway = new ClienteDatabaseGateway(clienteRepository)
        new FindClienteByCpfUseCase(clienteGateway)
    }

    @Bean
    FindClienteByNomeUseCase findClienteByNomeUseCase(ClienteRepository clienteRepository) {
        ClienteGateway clienteGateway = new ClienteDatabaseGateway(clienteRepository)
        new FindClienteByNomeUseCase(clienteGateway)
    }

    @Bean
    FindAllClienteUseCase getAllClienteUseCase(ClienteRepository clienteRepository) {
        ClienteGateway clienteGateway = new ClienteDatabaseGateway(clienteRepository)
        new FindAllClienteUseCase(clienteGateway)
    }

    @Bean
    FindClienteUseCase getClienteUseCase(ClienteRepository clienteRepository) {
        ClienteGateway clienteGateway = new ClienteDatabaseGateway(clienteRepository)
        new FindClienteUseCase(clienteGateway)
    }

    @Bean
    UpdateClienteUseCase updateClienteUseCase(ClienteRepository clienteRepository) {
        ClienteGateway clienteGateway = new ClienteDatabaseGateway(clienteRepository)
        new UpdateClienteUseCase(clienteGateway)
    }

    @Bean
    CreateProdutoUseCase createProdutoUseCase(ProdutoRepository produtoRepository) {
        ProdutoGateway produtoGateway = new ProdutoDatabaseGateway(produtoRepository)
        new CreateProdutoUseCase(produtoGateway)
    }

    @Bean
    DeleteProdutoUseCase deleteProdutoUseCase(ProdutoRepository produtoRepository) {
        ProdutoGateway produtoGateway = new ProdutoDatabaseGateway(produtoRepository)
        new DeleteProdutoUseCase(produtoGateway)
    }

    @Bean
    FindProdutoByCategoriaUseCase findProdutoByCategoriaUseCase(ProdutoRepository produtoRepository) {
        ProdutoGateway produtoGateway = new ProdutoDatabaseGateway(produtoRepository)
        new FindProdutoByCategoriaUseCase(produtoGateway)
    }

    @Bean
    FindProdutoByNomeUseCase findProdutoByNomeUseCase(ProdutoRepository produtoRepository) {
        ProdutoGateway produtoGateway = new ProdutoDatabaseGateway(produtoRepository)
        new FindProdutoByNomeUseCase(produtoGateway)
    }

    @Bean
    FindAllProdutoUseCase getAllProdutoUseCase(ProdutoRepository produtoRepository) {
        ProdutoGateway produtoGateway = new ProdutoDatabaseGateway(produtoRepository)
        new FindAllProdutoUseCase(produtoGateway)
    }

    @Bean
    FindProdutoUseCase getProdutoUseCase(ProdutoRepository produtoRepository) {
        ProdutoGateway produtoGateway = new ProdutoDatabaseGateway(produtoRepository)
        new FindProdutoUseCase(produtoGateway)
    }

    @Bean
    UpdateProdutoUseCase updateProdutoUseCase(ProdutoRepository produtoRepository) {
        ProdutoGateway produtoGateway = new ProdutoDatabaseGateway(produtoRepository)
        new UpdateProdutoUseCase(produtoGateway)
    }

    @Bean
    CreateImagemUseCase createImagemUseCase(ImagemRepository imagemRepository) {
        ImagemGateway imagemGateway = new ImagemDatabaseGateway(imagemRepository)
        new CreateImagemUseCase(imagemGateway)
    }

    @Bean
    DeleteImagemUseCase deleteImagemUseCase(ImagemRepository imagemRepository) {
        ImagemGateway imagemGateway = new ImagemDatabaseGateway(imagemRepository)
        new DeleteImagemUseCase(imagemGateway)
    }

    @Bean
    FindAllImagemUseCase findAllImagemUseCase(ImagemRepository imagemRepository) {
        ImagemGateway imagemGateway = new ImagemDatabaseGateway(imagemRepository)
        new FindAllImagemUseCase(imagemGateway)
    }

    @Bean
    FindImagemByProdutoUseCase findImagemByProdutoUseCase(ImagemRepository imagemRepository) {
        ImagemGateway imagemGateway = new ImagemDatabaseGateway(imagemRepository)
        new FindImagemByProdutoUseCase(imagemGateway)
    }

    @Bean
    FindImagemUseCase findImagemUseCase(ImagemRepository imagemRepository) {
        ImagemGateway imagemGateway = new ImagemDatabaseGateway(imagemRepository)
        new FindImagemUseCase(imagemGateway)
    }

    @Bean
    UpdateImagemUseCase updateImagemUseCase(ImagemRepository imagemRepository) {
        ImagemGateway imagemGateway = new ImagemDatabaseGateway(imagemRepository)
        new UpdateImagemUseCase(imagemGateway)
    }

    @Bean
    CreatePedidoUseCase createPedidoUseCase(PedidoRepository pedidoRepository) {
        PedidoGateway pedidoGateway = new PedidoDatabaseGateway(pedidoRepository)
        new CreatePedidoUseCase(pedidoGateway)
    }

    @Bean
    DeletePedidoUseCase deletePedidoUseCase(PedidoRepository pedidoRepository) {
        PedidoGateway pedidoGateway = new PedidoDatabaseGateway(pedidoRepository)
        new DeletePedidoUseCase(pedidoGateway)
    }

    @Bean
    FindAllPedidoUseCase findAllPedidoUseCase(PedidoRepository pedidoRepository) {
        PedidoGateway pedidoGateway = new PedidoDatabaseGateway(pedidoRepository)
        new FindAllPedidoUseCase(pedidoGateway)
    }

    @Bean
    FindPedidoByClienteUseCase findPedidoByClienteUseCase(PedidoRepository pedidoRepository) {
        PedidoGateway pedidoGateway = new PedidoDatabaseGateway(pedidoRepository)
        new FindPedidoByClienteUseCase(pedidoGateway)
    }

    @Bean
    FindPedidoByCodigoUseCase findPedidoByCodigoUseCase(PedidoRepository pedidoRepository) {
        PedidoGateway pedidoGateway = new PedidoDatabaseGateway(pedidoRepository)
        new FindPedidoByCodigoUseCase(pedidoGateway)
    }

    @Bean
    FindPedidoByStatusUseCase findPedidoByStatusUseCase(PedidoRepository pedidoRepository) {
        PedidoGateway pedidoGateway = new PedidoDatabaseGateway(pedidoRepository)
        new FindPedidoByStatusUseCase(pedidoGateway)
    }

    @Bean
    FindPedidoUseCase findPedidoUseCase(PedidoRepository pedidoRepository) {
        PedidoGateway pedidoGateway = new PedidoDatabaseGateway(pedidoRepository)
        new FindPedidoUseCase(pedidoGateway)
    }

    @Bean
    UpdatePedidoUseCase updatePedidoUseCase(PedidoRepository pedidoRepository) {
        PedidoGateway pedidoGateway = new PedidoDatabaseGateway(pedidoRepository)
        new UpdatePedidoUseCase(pedidoGateway)
    }
}

