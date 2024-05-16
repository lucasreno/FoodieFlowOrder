package fiap.com.fforder.usecase.status

import fiap.com.fforder.entity.status.exception.StatusNotFoundException
import fiap.com.fforder.entity.status.gateway.StatusGateway
import fiap.com.fforder.entity.status.model.Status

class FindStatusByNomeUseCase {
    private final StatusGateway statusGateway

    FindStatusByNomeUseCase(StatusGateway statusGateway) {
        this.statusGateway = statusGateway
    }

    List<Status> execute(String nome) {
        List<Status> status = statusGateway.findAllByNome(nome)
        if (status.isEmpty()) {
            throw new StatusNotFoundException()
        }
        return status
    }
}
