package fiap.com.fforder.infrastructure.produto.controller

import fiap.com.fforder.entity.produto.model.Produto
import fiap.com.fforder.usecase.produto.CreateProdutoUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class CreateProdutoController {

    private final CreateProdutoUseCase createProdutoUseCase

    CreateProdutoController(CreateProdutoUseCase createProdutoUseCase) {
        this.createProdutoUseCase = createProdutoUseCase
    }

    @PostMapping("/produto")
    @ResponseStatus(HttpStatus.CREATED)
    Produto create(@RequestBody Produto produto) {
        createProdutoUseCase.execute(produto)
    }

}
