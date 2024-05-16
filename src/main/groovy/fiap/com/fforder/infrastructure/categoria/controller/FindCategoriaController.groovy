package fiap.com.fforder.infrastructure.categoria.controller

import fiap.com.fforder.entity.categoria.model.Categoria
import fiap.com.fforder.usecase.categoria.FindCategoriaUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FindCategoriaController {

    private final FindCategoriaUseCase getCategoriaUseCase

    FindCategoriaController(FindCategoriaUseCase getCategoriaUseCase) {
        this.getCategoriaUseCase = getCategoriaUseCase
    }

    @GetMapping("/categoria/{id}")
    Categoria get(@PathVariable("id") Long id) {
        getCategoriaUseCase.execute(id)
    }
}
