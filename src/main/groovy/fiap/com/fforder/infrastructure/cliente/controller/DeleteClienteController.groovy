package fiap.com.fforder.infrastructure.cliente.controller

import fiap.com.fforder.usecase.cliente.DeleteClienteUseCase
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class DeleteClienteController {

    private final DeleteClienteUseCase deleteClienteUseCase

    DeleteClienteController(DeleteClienteUseCase deleteClienteUseCase) {
        this.deleteClienteUseCase = deleteClienteUseCase
    }

    @DeleteMapping("/cliente/{id}")
    void delete(@PathVariable Long id) {
        deleteClienteUseCase.execute(id)
    }
}
