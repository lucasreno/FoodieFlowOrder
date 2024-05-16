package fiap.com.fforder.infrastructure.cliente.controller

import fiap.com.fforder.usecase.cliente.FindAllClienteUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FindAllClienteController {

    private final FindAllClienteUseCase getAllClienteUseCase

    FindAllClienteController(FindAllClienteUseCase getAllClienteUseCase) {
        this.getAllClienteUseCase = getAllClienteUseCase
    }

    @GetMapping("/cliente")
    List getAll() {
        getAllClienteUseCase.execute()
    }
}
