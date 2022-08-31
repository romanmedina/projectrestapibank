package pe.com.restapibank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PrjCustomerManagementBank2Application {

	public static void main(String[] args) {
		SpringApplication.run(PrjCustomerManagementBank2Application.class, args);
	}

}
