package fiap.com.fforder.infrastructure.categoria.controller

import fiap.com.fforder.entity.categoria.model.Categoria
import fiap.com.fforder.usecase.categoria.UpdateCategoriaUseCase
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UpdateCategoriaController {

    private final UpdateCategoriaUseCase updateCategoriaUseCase

    UpdateCategoriaController(UpdateCategoriaUseCase updateCategoriaUseCase) {
        this.updateCategoriaUseCase = updateCategoriaUseCase
    }

    @PutMapping("/categoria")
    Categoria update(@RequestBody Categoria categoria) {
        updateCategoriaUseCase.execute(categoria.id, categoria.nome)
    }

}
