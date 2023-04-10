package deronzier.remi.notesmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The main class of the application.
 * 
 * @author Remi Deronzier
 */
@SpringBootApplication
@EnableSwagger2
public class NotesMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotesMicroserviceApplication.class, args);
	}

}
