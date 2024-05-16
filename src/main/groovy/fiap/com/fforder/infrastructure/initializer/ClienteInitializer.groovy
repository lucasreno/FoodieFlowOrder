package fiap.com.fforder.infrastructure.initializer

import fiap.com.fforder.entity.cliente.model.Cliente
import fiap.com.fforder.usecase.cliente.CreateClienteUseCase

class ClienteInitializer {

    private CreateClienteUseCase createClienteUseCase

    ClienteInitializer(CreateClienteUseCase createClienteUseCase) {
        this.createClienteUseCase = createClienteUseCase
        this.init()
    }

    void init() {
        println('Inicializando clientes...')
        List<Cliente> CLIENTES = [
                new Cliente(cpf: '1234567890', nome: 'John Doe', email: 'johndoe@gmail.com'),
                new Cliente(cpf: '0987654321', nome: 'Jane Smith', email: 'janesmith@gmail.com'),
                new Cliente(cpf: '1122334455', nome: 'Bob Johnson', email: 'bobjohnson@gmail.com'),
                new Cliente(cpf: '5566778899', nome: 'Alice Williams', email: 'alicewilliams@gmail.com')
        ]
        CLIENTES.each { cliente ->
            try {
                createClienteUseCase.execute(cliente)
            } catch (Exception e) {
                // do nothing
            }
        }
    }
}