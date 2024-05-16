package fiap.com.fforder.infrastructure.produto.controller

import fiap.com.fforder.usecase.produto.FindProdutoByCategoriaUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FindProdutoByCategoriaController {

    private final FindProdutoByCategoriaUseCase findProdutoByCategoriaUseCase

    FindProdutoByCategoriaController(FindProdutoByCategoriaUseCase findProdutoByCategoriaUseCase) {
        this.findProdutoByCategoriaUseCase = findProdutoByCategoriaUseCase
    }

    @GetMapping("/produto/categoria/{categoriaId}")
    List find(@PathVariable("categoria") String categoriaId) {
        findProdutoByCategoriaUseCase.execute(categoriaId)
    }
}
