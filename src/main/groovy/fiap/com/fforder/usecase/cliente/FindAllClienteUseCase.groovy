package fiap.com.fforder.usecase.cliente

import fiap.com.fforder.entity.cliente.gateway.ClienteGateway
import fiap.com.fforder.entity.cliente.model.Cliente

class FindAllClienteUseCase {
    private final ClienteGateway clienteGateway

    FindAllClienteUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway
    }

    List<Cliente> execute() {
        return clienteGateway.findAll()
    }
}
