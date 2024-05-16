package fiap.com.fforder

import fiap.com.fforder.entity.cliente.exception.ClienteAlreadyExistsException
import fiap.com.fforder.entity.cliente.exception.ClienteNotFoundException
import fiap.com.fforder.entity.cliente.model.Cliente
import fiap.com.fforder.usecase.cliente.CreateClienteUseCase
import fiap.com.fforder.usecase.cliente.DeleteClienteUseCase
import fiap.com.fforder.usecase.cliente.FindAllClienteUseCase
import fiap.com.fforder.usecase.cliente.FindClienteByCpfUseCase
import fiap.com.fforder.usecase.cliente.FindClienteByNomeUseCase
import fiap.com.fforder.usecase.cliente.FindClienteUseCase
import fiap.com.fforder.usecase.cliente.UpdateClienteUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles("test")
class ClienteTest extends Specification {

    @Autowired
    CreateClienteUseCase createClienteUseCase

    @Autowired
    DeleteClienteUseCase deleteClienteUseCase

    @Autowired
    FindAllClienteUseCase findAllClienteUseCase

    @Autowired
    FindClienteByCpfUseCase findClienteByCpfUseCase

    @Autowired
    FindClienteByNomeUseCase findClienteByNomeUseCase

    @Autowired
    FindClienteUseCase findClienteUseCase

    @Autowired
    UpdateClienteUseCase updateClienteUseCase

    def "Create Cliente"() {
        given:
        Cliente cliente = new Cliente(nome: "Cliente 1", cpf: "11111111111")

        when:
        Cliente clienteCriado = createClienteUseCase.execute(cliente)

        then:
        clienteCriado.nome == cliente.nome
        clienteCriado.cpf == cliente.cpf
        clienteCriado.id != null
    }

    def "Create Cliente with same cpf"() {
        given:
        Cliente cliente = new Cliente(nome: "Cliente 2", cpf: "11111111112")

        when:
        createClienteUseCase.execute(cliente)
        createClienteUseCase.execute(cliente)

        then:
        thrown ClienteAlreadyExistsException
    }

    def "Not found Cliente to update"() {
        given:
        Cliente cliente = new Cliente(id: 9999, nome: "Cliente 3", cpf: "11111111113")

        when:
        updateClienteUseCase.execute(cliente)

        then:
        thrown ClienteNotFoundException
    }

    def "Update Cliente"() {
        given:
        Cliente cliente = new Cliente(nome: "Cliente 4", cpf: "11111111114")
        Cliente clienteCriado = createClienteUseCase.execute(cliente)

        when:
        clienteCriado.nome = "Cliente 4 Updated"
        clienteCriado.cpf = "11111111114"
        Cliente clienteAtualizado = updateClienteUseCase.execute(clienteCriado)

        then:
        clienteAtualizado.nome == "Cliente 4 Updated"
        clienteAtualizado.cpf == "11111111114"
    }

    def "Delete Cliente"() {
        given:
        Cliente cliente = new Cliente(nome: "Cliente 5", cpf: "11111111115")
        Cliente clienteCriado = createClienteUseCase.execute(cliente)

        when:
        Cliente clienteDeletado = deleteClienteUseCase.execute(clienteCriado.id)

        then:
        clienteDeletado.id == clienteCriado.id
        clienteDeletado.nome == clienteCriado.nome
    }

    def "Delete Cliente not found"() {
        when:
        deleteClienteUseCase.execute(9999)

        then:
        thrown ClienteNotFoundException
    }

    def "Find Cliente by id"() {
        given:
        Cliente cliente = new Cliente(nome: "Cliente 6", cpf: "11111111116")
        Cliente clienteCriado = createClienteUseCase.execute(cliente)

        when:
        Cliente clienteEncontrado = findClienteUseCase.execute(clienteCriado.id)

        then:
        clienteEncontrado.id == clienteCriado.id
        clienteEncontrado.nome == clienteCriado.nome
    }

    def "Find Cliente not found"() {
        when:
        findClienteUseCase.execute(9999)

        then:
        thrown ClienteNotFoundException
    }

    def "Find Cliente by cpf"() {
        given:
        Cliente cliente = new Cliente(nome: "Cliente 7", cpf: "11111111117")
        Cliente clienteCriado = createClienteUseCase.execute(cliente)

        when:
        Cliente clienteEncontrado = findClienteByCpfUseCase.execute(clienteCriado.cpf)

        then:
        clienteEncontrado.id == clienteCriado.id
        clienteEncontrado.nome == clienteCriado.nome
    }

    def "Find Cliente by cpf not found"() {
        when:
        findClienteByCpfUseCase.execute("99999999999")

        then:
        thrown ClienteNotFoundException
    }

    def "Find Cliente by nome"() {
        given:
        Cliente cliente = new Cliente(nome: "Cliente 8", cpf: "11111111118")
        Cliente clienteCriado = createClienteUseCase.execute(cliente)

        when:
        List<Cliente> clientesEncontrado = findClienteByNomeUseCase.execute(clienteCriado.nome)

        then:
        clientesEncontrado.size() == 1
        clientesEncontrado.get(0).id == clienteCriado.id
        clientesEncontrado.get(0).nome == clienteCriado.nome
    }

    def "Find Cliente by nome not found"() {
        when:
        findClienteByNomeUseCase.execute("Cliente 8 Not Found")

        then:
        thrown ClienteNotFoundException
    }

    def "Find all Cliente"() {
        given:
        Cliente cliente1 = new Cliente(nome: "Cliente 9", cpf: "11111111119")
        Cliente cliente2 = new Cliente(nome: "Cliente 10", cpf: "1111111120")
        createClienteUseCase.execute(cliente1)
        createClienteUseCase.execute(cliente2)

        when:
        List<Cliente> clientes = findAllClienteUseCase.execute()

        then:
        clientes.size() >= 2
        clientes.find { it.nome == cliente1.nome } != null
        clientes.find { it.nome == cliente2.nome } != null
    }
}
