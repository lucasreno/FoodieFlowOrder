package fiap.com.fforder.infrastructure.pedido.controller

import fiap.com.fforder.usecase.pedido.FindPedidoByClienteUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FindPedidoByClienteController {

    private final FindPedidoByClienteUseCase findPedidoByClienteUseCase

    FindPedidoByClienteController(FindPedidoByClienteUseCase findPedidoByClienteUseCase) {
        this.findPedidoByClienteUseCase = findPedidoByClienteUseCase
    }

    @GetMapping("/pedido/cliente/{clienteId}")
    List find(@PathVariable("cliente") String clienteId) {
        findPedidoByClienteUseCase.execute(clienteId)
    }
}
