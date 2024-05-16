package fiap.com.fforder.infrastructure.cliente.controller

import fiap.com.fforder.entity.cliente.model.Cliente
import fiap.com.fforder.usecase.cliente.CreateClienteUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class CreateClienteController {

    private final CreateClienteUseCase createClienteUseCase

    CreateClienteController(CreateClienteUseCase createClienteUseCase) {
        this.createClienteUseCase = createClienteUseCase
    }

    @PostMapping("/cliente")
    @ResponseStatus(HttpStatus.CREATED)
    Cliente create(@RequestBody Cliente cliente) {
        createClienteUseCase.execute(cliente)
    }
}
