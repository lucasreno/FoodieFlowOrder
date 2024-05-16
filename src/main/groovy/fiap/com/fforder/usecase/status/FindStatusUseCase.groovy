package fiap.com.fforder.usecase.status

import fiap.com.fforder.entity.status.exception.StatusNotFoundException
import fiap.com.fforder.entity.status.gateway.StatusGateway
import fiap.com.fforder.entity.status.model.Status

class FindStatusUseCase {
    private final StatusGateway statusGateway

    FindStatusUseCase(StatusGateway statusGateway) {
        this.statusGateway = statusGateway
    }

    Status execute(Long id) {
        statusGateway.findById(id).orElseThrow { new StatusNotFoundException() }
    }
}
