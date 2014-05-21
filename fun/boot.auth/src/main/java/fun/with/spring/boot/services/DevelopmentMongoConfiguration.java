package fun.with.spring.boot.services;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import com.github.fakemongo.Fongo;
import com.mongodb.Mongo;

/**
 * The Class ServicesConfiguration.
 * http://www.intertech.com/Blog/spring-4-conditional-bean-configuration/
 * http://www.opencredo.com/2014/02/24/experiences-with-spring-boot/
 * 
 */
@Configuration("MongoConfiguration")
@Profile("Development")
public class DevelopmentMongoConfiguration extends AbstractMongoConfiguration {


	@Override
	protected String getDatabaseName() {
		return "mongo_server_1";
	}

	@Override
	public Mongo mongo() throws Exception {
		return new Fongo(getDatabaseName()).getMongo();
	}

	

}
