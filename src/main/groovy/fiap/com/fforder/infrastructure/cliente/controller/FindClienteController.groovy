package fiap.com.fforder.infrastructure.cliente.controller

import fiap.com.fforder.entity.cliente.model.Cliente
import fiap.com.fforder.usecase.cliente.FindClienteUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FindClienteController {

    private final FindClienteUseCase getClienteUseCase

    FindClienteController(FindClienteUseCase getClienteUseCase) {
        this.getClienteUseCase = getClienteUseCase
    }

    @GetMapping("/cliente/{id}")
    Cliente get(@PathVariable("id") Long id) {
        getClienteUseCase.execute(id)
    }
}
