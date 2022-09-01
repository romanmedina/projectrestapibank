package pe.com.restapibank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProjectApiRestBankPostgresApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApiRestBankPostgresApplication.class, args);
	}

}
