package fiap.com.fforder.infrastructure.status.controller

import fiap.com.fforder.entity.status.model.Status
import fiap.com.fforder.usecase.status.FindAllStatusUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FindAllStatusController {

    private final FindAllStatusUseCase getAllStatusUseCase

    FindAllStatusController(FindAllStatusUseCase getAllStatusUseCase) {
        this.getAllStatusUseCase = getAllStatusUseCase
    }

    @GetMapping("/status")
    List<Status> getAll() {
        getAllStatusUseCase.execute()
    }
}
