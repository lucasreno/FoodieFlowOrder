package fiap.com.fforder.usecase.cliente

import fiap.com.fforder.entity.cliente.exception.ClienteNotFoundException
import fiap.com.fforder.entity.cliente.gateway.ClienteGateway
import fiap.com.fforder.entity.cliente.model.Cliente

class UpdateClienteUseCase {
    private final ClienteGateway clienteGateway

    UpdateClienteUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway
    }

    Cliente execute(Cliente cliente) {
        clienteGateway.findById(cliente.id).orElseThrow { new ClienteNotFoundException() }
        clienteGateway.update(cliente)
    }
}
