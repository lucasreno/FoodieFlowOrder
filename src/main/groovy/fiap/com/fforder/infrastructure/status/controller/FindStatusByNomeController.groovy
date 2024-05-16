package fiap.com.fforder.infrastructure.status.controller

import fiap.com.fforder.entity.status.model.Status
import fiap.com.fforder.usecase.status.FindStatusByNomeUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FindStatusByNomeController {

    private final FindStatusByNomeUseCase findStatusByNomeUseCase

    FindStatusByNomeController(FindStatusByNomeUseCase findStatusByNomeUseCase) {
        this.findStatusByNomeUseCase = findStatusByNomeUseCase
    }

    @GetMapping("/status/{nome}")
    List<Status> find(@PathVariable String nome) {
        findStatusByNomeUseCase.execute(nome)
    }
}
