package fiap.com.fforder.infrastructure.status.controller

import fiap.com.fforder.entity.status.model.Status
import fiap.com.fforder.usecase.status.CreateStatusUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class CreateStatusController {

    private final CreateStatusUseCase createStatusUseCase

    CreateStatusController(CreateStatusUseCase createStatusUseCase) {
        this.createStatusUseCase = createStatusUseCase
    }

    @PostMapping("/status")
    @ResponseStatus(HttpStatus.CREATED)
    Status create(@RequestBody Status status) {
        createStatusUseCase.execute(status.nome)
    }
}
