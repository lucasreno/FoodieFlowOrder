package fiap.com.fforder.infrastructure.cliente.controller

import fiap.com.fforder.usecase.cliente.FindClienteByNomeUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FindClienteByNomeController {
    private final FindClienteByNomeUseCase findClienteByNomeUseCase

    FindClienteByNomeController(FindClienteByNomeUseCase findClienteByNomeUseCase) {
        this.findClienteByNomeUseCase = findClienteByNomeUseCase
    }

    @GetMapping("/cliente/nome/{nome}")
    List find(@PathVariable("nome") String nome) {
        findClienteByNomeUseCase.execute(nome)
    }
}
