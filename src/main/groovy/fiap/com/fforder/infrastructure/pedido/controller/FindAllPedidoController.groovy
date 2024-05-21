package fiap.com.fforder.infrastructure.pedido.controller

import fiap.com.fforder.usecase.pedido.FindAllPedidoUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FindAllPedidoController {

    private final FindAllPedidoUseCase getAllPedidoUseCase

    FindAllPedidoController(FindAllPedidoUseCase getAllPedidoUseCase) {
        this.getAllPedidoUseCase = getAllPedidoUseCase
    }

    @GetMapping("/pedido")
    List find() {
        getAllPedidoUseCase.execute()
    }
}
