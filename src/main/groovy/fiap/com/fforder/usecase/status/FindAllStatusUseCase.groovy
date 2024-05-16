package fiap.com.fforder.usecase.status

import fiap.com.fforder.entity.status.gateway.StatusGateway
import fiap.com.fforder.entity.status.model.Status

class FindAllStatusUseCase {

    private final StatusGateway statusGateway

    FindAllStatusUseCase(StatusGateway statusGateway) {
        this.statusGateway = statusGateway
    }

    List<Status> execute() {
        statusGateway.findAll()
    }
}
