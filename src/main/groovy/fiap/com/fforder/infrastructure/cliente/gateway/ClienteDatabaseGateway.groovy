package fiap.com.fforder.infrastructure.cliente.gateway

import fiap.com.fforder.entity.cliente.gateway.ClienteGateway
import fiap.com.fforder.entity.cliente.model.Cliente
import fiap.com.fforder.infrastructure.config.db.repository.ClienteRepository
import fiap.com.fforder.infrastructure.config.db.schema.ClienteSchema

class ClienteDatabaseGateway implements ClienteGateway {
    private final ClienteRepository clienteRepository

    ClienteDatabaseGateway(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository
    }

    @Override
    Cliente create(Cliente cliente) {
        ClienteSchema clienteSchema = new ClienteSchema(nome: cliente.nome, cpf: cliente.cpf, email: cliente.email)
        clienteRepository.save(clienteSchema).toCliente()
    }

    @Override
    Cliente update(Cliente cliente) {
        ClienteSchema clienteSchema = new ClienteSchema(id: cliente.id, nome: cliente.nome, cpf: cliente.cpf, email: cliente.email)
        clienteRepository.save(clienteSchema).toCliente()
    }

    @Override
    void delete(Long id) {
        clienteRepository.deleteById(id)
    }

    @Override
    Optional<Cliente> findById(Long id) {
        clienteRepository.findById(id).map { it.toCliente() }
    }

    @Override
    List<Cliente> findAll() {
        clienteRepository.findAll().collect { it.toCliente() }
    }

    @Override
    List<Cliente> findAllByNome(String nome) {
        List<Cliente> clientes = clienteRepository.findAllByNome(nome).collect { it.toCliente() }
        return clientes ?: []
    }

    @Override
    List<Cliente> findAllByCpf(String cpf) {
        List<Cliente> clientes = clienteRepository.findAllByCpf(cpf).collect { it.toCliente() }
        return clientes ?: []
    }
}
