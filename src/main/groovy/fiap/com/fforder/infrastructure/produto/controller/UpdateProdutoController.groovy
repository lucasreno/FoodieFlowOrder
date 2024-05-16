package fiap.com.fforder.infrastructure.produto.controller

import fiap.com.fforder.entity.produto.model.Produto
import fiap.com.fforder.usecase.produto.UpdateProdutoUseCase
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UpdateProdutoController {

    private final UpdateProdutoUseCase updateProdutoUseCase

    UpdateProdutoController(UpdateProdutoUseCase updateProdutoUseCase) {
        this.updateProdutoUseCase = updateProdutoUseCase
    }

    @PutMapping("/produto")
    Produto update(@RequestBody Produto produto) {
        updateProdutoUseCase.execute(produto)
    }
}
