package fiap.com.fforder.usecase.cliente

import fiap.com.fforder.entity.cliente.exception.ClienteAlreadyExistsException
import fiap.com.fforder.entity.cliente.gateway.ClienteGateway
import fiap.com.fforder.entity.cliente.model.Cliente

class CreateClienteUseCase {
    private final ClienteGateway clienteGateway

    CreateClienteUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway
    }

    Cliente execute(Cliente cliente) {
        if (clienteGateway.findAllByCpf(cliente.cpf).isEmpty()) {
            return clienteGateway.create(cliente)
        } else {
            throw new ClienteAlreadyExistsException()
        }
    }
}
