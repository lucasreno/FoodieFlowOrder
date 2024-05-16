package fiap.com.fforder.infrastructure.imagem.controller

import fiap.com.fforder.usecase.imagem.FindImagemByProdutoUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FindImagemByProdutoController {

    private final FindImagemByProdutoUseCase findImagemByProdutoUseCase

    FindImagemByProdutoController(FindImagemByProdutoUseCase findImagemByProdutoUseCase) {
        this.findImagemByProdutoUseCase = findImagemByProdutoUseCase
    }

    @GetMapping("/imagem/produto/{produtoID}")
    List findImagemByProduto(@PathVariable("produtoID") Long id) {
        findImagemByProdutoUseCase.execute(id)
    }
}
