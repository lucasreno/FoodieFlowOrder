package fiap.com.fforder.usecase.cliente

import fiap.com.fforder.entity.cliente.exception.ClienteNotFoundException
import fiap.com.fforder.entity.cliente.gateway.ClienteGateway
import fiap.com.fforder.entity.cliente.model.Cliente

class DeleteClienteUseCase {
    private final ClienteGateway clienteGateway

    DeleteClienteUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway
    }

    Cliente execute(Long id) {
        Cliente cliente = clienteGateway.findById(id).orElseThrow { new ClienteNotFoundException() }
        clienteGateway.delete(id)
        cliente
    }
}
