package fiap.com.fforder.infrastructure.main.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckController {
    @GetMapping("/healthcheck")
    String health() {
        "OK"
    }
}
