package fiap.com.fforder.infrastructure.status.gateway

import fiap.com.fforder.entity.status.gateway.StatusGateway
import fiap.com.fforder.entity.status.model.Status
import fiap.com.fforder.infrastructure.config.db.repository.StatusRepository
import fiap.com.fforder.infrastructure.config.db.schema.StatusSchema

class StatusDatabaseGateway implements StatusGateway {
    private final StatusRepository statusRepository

    StatusDatabaseGateway(StatusRepository statusRepository) {
        this.statusRepository = statusRepository
    }

    @Override
    Status create(Status status) {
        statusRepository.save(new StatusSchema(nome: status.nome)).toStatus()
    }

    @Override
    Status update(Status status) {
        statusRepository.save(new StatusSchema(id: status.id, nome: status.nome)).toStatus()
    }

    @Override
    void delete(Long id) {
        statusRepository.deleteById(id)
    }

    @Override
    Optional<Status> findById(Long id) {
        statusRepository.findById(id).map { it.toStatus() }
    }

    @Override
    List<Status> findAll() {
        statusRepository.findAll().collect { it.toStatus() }
    }

    @Override
    List<Status> findAllByNome(String nome) {
        List<Status> status = statusRepository.findAllByNome(nome).collect { it.toStatus() }
        return status ?: []
    }
}
