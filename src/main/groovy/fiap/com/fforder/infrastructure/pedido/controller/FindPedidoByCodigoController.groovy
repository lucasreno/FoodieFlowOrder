package fiap.com.fforder.infrastructure.pedido.controller

import fiap.com.fforder.usecase.pedido.FindPedidoByCodigoUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FindPedidoByCodigoController {

    private final FindPedidoByCodigoUseCase findPedidoByCodigoUseCase

    FindPedidoByCodigoController(FindPedidoByCodigoUseCase findPedidoByCodigoUseCase) {
        this.findPedidoByCodigoUseCase = findPedidoByCodigoUseCase
    }

    @GetMapping("/pedido/codigo/{codigo}")
    List find(@PathVariable("codigo") String codigo) {
        findPedidoByCodigoUseCase.execute(codigo)
    }
}
