package fiap.com.fforder.usecase.cliente

import fiap.com.fforder.entity.cliente.exception.ClienteNotFoundException
import fiap.com.fforder.entity.cliente.gateway.ClienteGateway
import fiap.com.fforder.entity.cliente.model.Cliente

class FindClienteUseCase {
    private final ClienteGateway clienteGateway

    FindClienteUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway
    }

    Cliente execute(Long id) {
        return clienteGateway.findById(id).orElseThrow { new ClienteNotFoundException() }
    }
}
