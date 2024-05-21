package fiap.com.fforder.infrastructure.pedido.controller

import fiap.com.fforder.usecase.pedido.FindPedidoUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FindPedidoController {

    private final FindPedidoUseCase findPedidoUseCase

    FindPedidoController(FindPedidoUseCase findPedidoUseCase) {
        this.findPedidoUseCase = findPedidoUseCase
    }

    @GetMapping("/pedido/{id}")
    List find(@PathVariable("id") Long id) {
        findPedidoUseCase.execute(id)
    }
}
