package fiap.com.fforder.usecase.status

import fiap.com.fforder.entity.status.exception.StatusAlreadyExistsException
import fiap.com.fforder.entity.status.gateway.StatusGateway
import fiap.com.fforder.entity.status.model.Status

class CreateStatusUseCase {
    private final StatusGateway statusGateway

    CreateStatusUseCase(StatusGateway statusGateway) {
        this.statusGateway = statusGateway
    }

    Status execute(String nome) {
        Status status = new Status(nome: nome)
        if(statusGateway.findAllByNome(nome).isEmpty()) {
            return statusGateway.create(status)
        } else {
            throw new StatusAlreadyExistsException()
        }
    }
}
