package spring.boot.essencial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;

@SpringBootApplication
@ConfigurationProperties(prefix = "applicaton")
public class SpringBootEssencialApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEssencialApplication.class, args);
	}

}
