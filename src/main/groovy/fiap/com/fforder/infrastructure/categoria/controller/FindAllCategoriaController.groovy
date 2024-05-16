package fiap.com.fforder.infrastructure.categoria.controller

import fiap.com.fforder.usecase.categoria.FindAllCategoriaUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FindAllCategoriaController {

    private final FindAllCategoriaUseCase getAllCategoriaUseCase

    FindAllCategoriaController(FindAllCategoriaUseCase getAllCategoriaUseCase) {
        this.getAllCategoriaUseCase = getAllCategoriaUseCase
    }

    @GetMapping("/categoria")
    List getAll() {
        getAllCategoriaUseCase.execute()
    }
}
