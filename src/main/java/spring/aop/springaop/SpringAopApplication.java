package spring.aop.springaop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring.aop.springaop.business.Business1;
import spring.aop.springaop.business.Business2;

@SpringBootApplication
public class SpringAopApplication implements CommandLineRunner {
	// Whatever we have defined in commandLineRunner would be invoked as soon as the application is launched. It means
	// when the application launch, the run method in CommandLineRunner will be invoked.

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	Business1 business1;

	@Autowired
	Business2 business2;

	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("1");
		logger.info( business1.calculateSomething() );
		System.out.println("2");
		logger.info( business2.calculateSomething() );
		System.out.println("3");
	}
}
