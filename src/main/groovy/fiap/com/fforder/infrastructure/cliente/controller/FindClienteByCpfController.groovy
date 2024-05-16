package fiap.com.fforder.infrastructure.cliente.controller

import fiap.com.fforder.usecase.cliente.FindClienteByCpfUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FindClienteByCpfController {
    private final FindClienteByCpfUseCase findClienteByCpfUseCase

    FindClienteByCpfController(FindClienteByCpfUseCase findClienteByCpfUseCase) {
        this.findClienteByCpfUseCase = findClienteByCpfUseCase
    }

    @GetMapping("/cliente/cpf/{cpf}")
    List find(@PathVariable("cpf") String cpf) {
        findClienteByCpfUseCase.execute(cpf)
    }
}
