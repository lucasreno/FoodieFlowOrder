package fiap.com.fforder.infrastructure.pedido.controller

import fiap.com.fforder.entity.pedido.model.Pedido
import fiap.com.fforder.usecase.pedido.UpdatePedidoUseCase
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UpdatePedidoController {

    private final UpdatePedidoUseCase updatePedidoUseCase

    UpdatePedidoController(UpdatePedidoUseCase updatePedidoUseCase) {
        this.updatePedidoUseCase = updatePedidoUseCase
    }

    @PutMapping("/pedido")
    Pedido update(@RequestBody Pedido pedido) {
        updatePedidoUseCase.execute(pedido)
    }
}
