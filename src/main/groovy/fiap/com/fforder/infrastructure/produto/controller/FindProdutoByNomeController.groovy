package fiap.com.fforder.infrastructure.produto.controller

import fiap.com.fforder.usecase.produto.FindProdutoByNomeUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FindProdutoByNomeController {

    private final FindProdutoByNomeUseCase findProdutoByNomeUseCase

    FindProdutoByNomeController(FindProdutoByNomeUseCase findProdutoByNomeUseCase) {
        this.findProdutoByNomeUseCase = findProdutoByNomeUseCase
    }

    @GetMapping("/produto/nome/{nome}")
    List find(@PathVariable("nome") String nome) {
        findProdutoByNomeUseCase.execute(nome)
    }
}
