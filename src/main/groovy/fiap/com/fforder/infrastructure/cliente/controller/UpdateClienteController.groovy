package fiap.com.fforder.infrastructure.cliente.controller

import fiap.com.fforder.entity.cliente.model.Cliente
import fiap.com.fforder.usecase.cliente.UpdateClienteUseCase
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UpdateClienteController {

    private final UpdateClienteUseCase updateClienteUseCase

    UpdateClienteController(UpdateClienteUseCase updateClienteUseCase) {
        this.updateClienteUseCase = updateClienteUseCase
    }

    @PutMapping("/cliente/{id}")
    Cliente update(@RequestBody Cliente cliente) {
        updateClienteUseCase.execute(cliente)
    }

}
