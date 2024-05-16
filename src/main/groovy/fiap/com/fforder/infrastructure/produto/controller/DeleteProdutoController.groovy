package fiap.com.fforder.infrastructure.produto.controller

import fiap.com.fforder.entity.produto.exception.ProdutoNotFoundException
import fiap.com.fforder.usecase.produto.DeleteProdutoUseCase
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class DeleteProdutoController {

    private final DeleteProdutoUseCase deleteProdutoUseCase

    DeleteProdutoController(DeleteProdutoUseCase deleteProdutoUseCase) {
        this.deleteProdutoUseCase = deleteProdutoUseCase
    }

    @DeleteMapping("/produto/{id}")
    void delete(@PathVariable Long id) throws ProdutoNotFoundException {
        deleteProdutoUseCase.execute(id)
    }
}
