package fiap.com.fforder.infrastructure.pedido.controller

import fiap.com.fforder.usecase.pedido.FindPedidoByStatusUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FindPedidoByStatusController {

    private final FindPedidoByStatusUseCase findPedidoByStatusUseCase

    FindPedidoByStatusController(FindPedidoByStatusUseCase findPedidoByStatusUseCase) {
        this.findPedidoByStatusUseCase = findPedidoByStatusUseCase
    }

    @GetMapping("/pedido/status/{status}")
    List find(@PathVariable("status") String status) {
        findPedidoByStatusUseCase.execute(status)
    }
}
