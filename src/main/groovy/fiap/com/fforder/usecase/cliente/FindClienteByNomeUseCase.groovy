package fiap.com.fforder.usecase.cliente

import fiap.com.fforder.entity.cliente.exception.ClienteNotFoundException
import fiap.com.fforder.entity.cliente.gateway.ClienteGateway
import fiap.com.fforder.entity.cliente.model.Cliente

class FindClienteByNomeUseCase {
    private final ClienteGateway clienteGateway

    FindClienteByNomeUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway
    }

    List<Cliente> execute(String nome) {
        List<Cliente> clientes = clienteGateway.findAllByNome(nome)
        if (clientes.isEmpty()) {
            throw new ClienteNotFoundException()
        }
        return clientes
    }
}
