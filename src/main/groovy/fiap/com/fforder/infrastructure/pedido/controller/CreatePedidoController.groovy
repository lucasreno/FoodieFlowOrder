package fiap.com.fforder.infrastructure.pedido.controller

import fiap.com.fforder.entity.pedido.model.Pedido
import fiap.com.fforder.usecase.pedido.CreatePedidoUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class CreatePedidoController {

    private final CreatePedidoUseCase createPedidoUseCase

    CreatePedidoController(CreatePedidoUseCase createPedidoUseCase) {
        this.createPedidoUseCase = createPedidoUseCase
    }

    @PostMapping("/pedido")
    @ResponseStatus(HttpStatus.CREATED)
    Pedido create(@RequestBody Pedido pedido) {
        createPedidoUseCase.execute(pedido)
    }
}
