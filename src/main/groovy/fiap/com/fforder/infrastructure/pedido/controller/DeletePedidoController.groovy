package fiap.com.fforder.infrastructure.pedido.controller

import fiap.com.fforder.entity.pedido.exception.PedidoNotFoundException
import fiap.com.fforder.usecase.pedido.DeletePedidoUseCase
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class DeletePedidoController {

    private final DeletePedidoUseCase deletePedidoUseCase

    DeletePedidoController(DeletePedidoUseCase deletePedidoUseCase) {
        this.deletePedidoUseCase = deletePedidoUseCase
    }

    @DeleteMapping("/pedido/{id}")
    void delete(@PathVariable Long id) throws PedidoNotFoundException {
        deletePedidoUseCase.execute(id)
    }
}
