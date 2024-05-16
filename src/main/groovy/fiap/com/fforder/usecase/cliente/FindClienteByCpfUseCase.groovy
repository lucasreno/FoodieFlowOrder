package fiap.com.fforder.usecase.cliente

import fiap.com.fforder.entity.cliente.exception.ClienteNotFoundException
import fiap.com.fforder.entity.cliente.gateway.ClienteGateway
import fiap.com.fforder.entity.cliente.model.Cliente

class FindClienteByCpfUseCase {
    private final ClienteGateway clienteGateway

    FindClienteByCpfUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway
    }

    Cliente execute(String cpf) {
        List<Cliente> clientes = clienteGateway.findAllByCpf(cpf)
        if (clientes.isEmpty()) {
            throw new ClienteNotFoundException()
        }
        return clientes.get(0)
    }
}
