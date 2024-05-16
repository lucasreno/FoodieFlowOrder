package fiap.com.fforder.infrastructure.categoria.controller

import fiap.com.fforder.entity.categoria.model.Categoria
import fiap.com.fforder.usecase.categoria.CreateCategoriaUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class CreateCategoriaController {

    private final CreateCategoriaUseCase createCategoriaUseCase

    CreateCategoriaController(CreateCategoriaUseCase createCategoriaUseCase) {
        this.createCategoriaUseCase = createCategoriaUseCase
    }

    @PostMapping("/categoria")
    @ResponseStatus(HttpStatus.CREATED)
    Categoria create(@RequestBody Categoria categoria) {
        createCategoriaUseCase.execute(categoria.nome)
    }
}
