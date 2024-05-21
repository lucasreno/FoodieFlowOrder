package fiap.com.fforder

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class FoodieFlowOrderApplication {

	static void main(String[] args) {
		System.out.print("Variables: ")
		System.out.println(System.getenv())
		SpringApplication.run(FoodieFlowOrderApplication, args)
	}

}
