import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.test.service.HelloMessageService;

@ComponentScan(basePackages = "com")
@SpringBootApplication
@EnableJpaRepositories("com")
@EnableJpaAuditing
@EntityScan("com")
@PropertySource("classpath:application.properties")
public class Application implements CommandLineRunner {
	@Autowired
	private HelloMessageService helloService;

	public static void main(String[] args) throws Exception {

		SpringApplication app = new SpringApplication(Application.class);
		app.run(args);

		/*
		 * new SpringApplicationBuilder(Application.class) .web(WebApplicationType.NONE)
		 * // .REACTIVE, .SERVLET .run(args);
		 *
		 *	ApplicationContext ctx = SpringApplication.run(MainApp.class, args);
      		HelloWorldBean bean = ctx.getBean(HelloWorldBean.class);
      		bean.sayHello();
		 */

	}

	@Bean
	public HelloMessageService getHelloService() {
		return new HelloMessageService();
	}

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println(helloService.getMessage());
		// getHelloService().hello();
		// TODO Auto-generated method stub
		System.out.println("Spring boot standalone application is working...");
	}

}