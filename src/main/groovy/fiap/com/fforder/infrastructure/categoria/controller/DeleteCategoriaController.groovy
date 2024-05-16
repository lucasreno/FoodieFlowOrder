package fiap.com.fforder.infrastructure.categoria.controller

import fiap.com.fforder.entity.categoria.exception.CategoriaNotFoundException
import fiap.com.fforder.usecase.categoria.DeleteCategoriaUseCase
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class DeleteCategoriaController {

    private final DeleteCategoriaUseCase deleteCategoriaUseCase

    DeleteCategoriaController(DeleteCategoriaUseCase deleteCategoriaUseCase) {
        this.deleteCategoriaUseCase = deleteCategoriaUseCase
    }

    @DeleteMapping("/categoria/{id}")
    void delete(@PathVariable Long id) throws CategoriaNotFoundException{
        deleteCategoriaUseCase.execute(id)
    }
}
