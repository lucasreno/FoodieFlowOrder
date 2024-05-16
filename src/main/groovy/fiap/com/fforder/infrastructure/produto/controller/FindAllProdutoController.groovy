package fiap.com.fforder.infrastructure.produto.controller

import fiap.com.fforder.usecase.produto.FindAllProdutoUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FindAllProdutoController {

    private final FindAllProdutoUseCase getAllProdutoUseCase

    FindAllProdutoController(FindAllProdutoUseCase getAllProdutoUseCase) {
        this.getAllProdutoUseCase = getAllProdutoUseCase
    }

    @GetMapping("/produto")
    List find() {
        getAllProdutoUseCase.execute()
    }
}
