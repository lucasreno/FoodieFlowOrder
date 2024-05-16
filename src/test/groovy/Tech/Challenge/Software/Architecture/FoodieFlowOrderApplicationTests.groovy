package Tech.Challenge.Software.Architecture

import fiap.com.fforder.infrastructure.config.exception.ErrorsHandler
import jakarta.persistence.EntityNotFoundException
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.lang.Specification

@SpringBootTest
class FoodieFlowOrderApplicationTests extends Specification {
    ErrorsHandler errorsHandler = new ErrorsHandler()

    def "Test handleError404"() {
        when:
        ResponseEntity response = errorsHandler.handleError404(new EntityNotFoundException())

        then:
        response.getStatusCode() == HttpStatus.NOT_FOUND
    }

    def "Test handleError500"() {
        when:
        ResponseEntity response = errorsHandler.handleError500(new Exception())

        then:
        response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR
    }

}
