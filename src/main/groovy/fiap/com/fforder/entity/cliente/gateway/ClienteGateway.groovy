package fiap.com.fforder.entity.cliente.gateway

import fiap.com.fforder.entity.cliente.model.Cliente

interface ClienteGateway {
    Cliente create(Cliente cliente)

    Cliente update(Cliente cliente)

    void delete(Long id)

    Optional<Cliente> findById(Long id)

    List<Cliente> findAll()

    List<Cliente> findAllByNome(String nome)

    List<Cliente> findAllByCpf(String cpf)
}