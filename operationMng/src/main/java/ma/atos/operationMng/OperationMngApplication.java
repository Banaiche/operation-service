package ma.atos.operationMng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"ma.atos.operationMng.proxies"})
public class OperationMngApplication {

	public static void main(String[] args) {
		SpringApplication.run(OperationMngApplication.class, args);
	}

}
