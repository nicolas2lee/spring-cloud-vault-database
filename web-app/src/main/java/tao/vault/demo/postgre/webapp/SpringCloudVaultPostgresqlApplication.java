package tao.vault.demo.postgre.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"tao.vault.demo.postgre.webapp"}, lazyInit = true)
public class SpringCloudVaultPostgresqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudVaultPostgresqlApplication.class, args);
	}

}
