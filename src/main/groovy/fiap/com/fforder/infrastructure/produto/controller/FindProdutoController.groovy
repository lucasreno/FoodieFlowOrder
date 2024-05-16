package fiap.com.fforder.infrastructure.produto.controller

import fiap.com.fforder.entity.produto.model.Produto
import fiap.com.fforder.usecase.produto.FindProdutoUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FindProdutoController {

    private final FindProdutoUseCase getProdutoUseCase

    FindProdutoController(FindProdutoUseCase getProdutoUseCase) {
        this.getProdutoUseCase = getProdutoUseCase
    }

    @GetMapping("/produto/{id}")
    Produto get(@PathVariable("id") Long id) {
        getProdutoUseCase.execute(id)
    }
}
