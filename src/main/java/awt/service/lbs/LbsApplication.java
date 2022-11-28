package awt.service.lbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LbsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LbsApplication.class, args);
	}

}
