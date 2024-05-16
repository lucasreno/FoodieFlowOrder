package fiap.com.fforder.infrastructure.config.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
class ErrorsHandler {
    Map<String, String> response = new HashMap<>()

    @ExceptionHandler(EntityNotFoundException.class)
     ResponseEntity handleError404(Exception ex) {
        response.clear()
        response.put("error", "Not Found")
        response.put("message", ex.getLocalizedMessage())
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response)
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity handleError500(Exception ex) {
        response.clear()
        response.put("error", "Internal Server Error")
        response.put("message", ex.getLocalizedMessage())
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + ex.getLocalizedMessage())
    }
}
