package fiap.com.fforder

import fiap.com.fforder.entity.status.exception.StatusAlreadyExistsException
import fiap.com.fforder.entity.status.exception.StatusNotFoundException
import fiap.com.fforder.entity.status.model.Status
import fiap.com.fforder.usecase.status.CreateStatusUseCase
import fiap.com.fforder.usecase.status.FindAllStatusUseCase
import fiap.com.fforder.usecase.status.FindStatusByNomeUseCase
import fiap.com.fforder.usecase.status.FindStatusUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles("test")
class StatusTest extends Specification {
    @Autowired
    CreateStatusUseCase createStatusUseCase

    @Autowired
    FindAllStatusUseCase findAllStatusUseCase

    @Autowired
    FindStatusByNomeUseCase findStatusByNomeUseCase

    @Autowired
    FindStatusUseCase findStatusUseCase

    def "Create Status with same nome"() {
        given:
        createStatusUseCase.execute("Status 1")
        when:
        createStatusUseCase.execute("Status 1")
        then:
        thrown StatusAlreadyExistsException
    }

    def "Find All Status"() {
        given:
        Status statusCreated = createStatusUseCase.execute("Status 2")
        when:
        List<Status> status = findAllStatusUseCase.execute()
        then:
        status.size() >= 1
        status.find { it.nome == "Status 2" }.hashCode() == statusCreated.hashCode()
    }

    def "Find Status by nome"() {
        given:
        createStatusUseCase.execute("Status 3")
        when:
        List<Status> status = findStatusByNomeUseCase.execute("Status 3")
        then:
        status.size() == 1
        status.find { it.nome == "Status 3" }
    }

    def "Find Status by nome not found"() {
        when:
        List<Status> status = findStatusByNomeUseCase.execute("Status 4")
        then:
        thrown StatusNotFoundException
    }

    def "Find Status by id"() {
        given:
        Status status = createStatusUseCase.execute("Status 5")
        when:
        Status statusFound = findStatusUseCase.execute(status.id)
        then:
        statusFound.id == status.id
    }

    def "Find Status by id not found"() {
        when:
        findStatusUseCase.execute(9999L)
        then:
        thrown StatusNotFoundException
    }
}
