package fun.with.spring.boot.auth;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.hateoas.Link;

@Configuration
public class ServicesConfiguration {

	@Resource
	private Environment env;

	@Bean
	public Services services() {
		
		
		Services services = new Services();
		services.addLink(new Link("http://test.de/"));
		return services;
	}

}
