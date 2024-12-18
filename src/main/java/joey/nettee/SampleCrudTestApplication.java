package joey.nettee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static joey.nettee.common.constant.Constants.ROOT_PACKAGE;

@SpringBootApplication(scanBasePackages = ROOT_PACKAGE)
public class SampleCrudTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleCrudTestApplication.class, args);
	}

}
