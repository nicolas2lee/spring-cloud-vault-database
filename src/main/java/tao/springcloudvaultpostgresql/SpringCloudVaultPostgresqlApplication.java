package tao.springcloudvaultpostgresql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"tao.springcloudvaultpostgresql"}, lazyInit = true)
public class SpringCloudVaultPostgresqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudVaultPostgresqlApplication.class, args);
	}

}
