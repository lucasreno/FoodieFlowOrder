package fiap.com.fforder.infrastructure.status.controller

import fiap.com.fforder.entity.status.model.Status
import fiap.com.fforder.usecase.status.FindStatusUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FindStatusController {

    private final FindStatusUseCase getStatusUseCase

    FindStatusController(FindStatusUseCase getStatusUseCase) {
        this.getStatusUseCase = getStatusUseCase
    }

    @GetMapping("/status/{id}")
    Status get(@PathVariable Long id) {
        getStatusUseCase.execute(id)
    }
}
