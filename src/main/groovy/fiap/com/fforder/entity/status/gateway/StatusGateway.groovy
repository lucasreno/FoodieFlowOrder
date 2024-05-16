package fiap.com.fforder.entity.status.gateway

import fiap.com.fforder.entity.status.model.Status

interface StatusGateway {
    Status create(Status status)

    Status update(Status status)

    void delete(Long id)

    Optional<Status> findById(Long id)

    List<Status> findAll()

    List<Status> findAllByNome(String nome)
}
