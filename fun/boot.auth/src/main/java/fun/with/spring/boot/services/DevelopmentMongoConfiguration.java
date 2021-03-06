package fun.with.spring.boot.services;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.github.fakemongo.Fongo;
import com.mongodb.Mongo;

import fun.with.spring.boot.root.DataConstants;
import fun.with.spring.boot.root.ProfileConstants;

/**
 * The Class ServicesConfiguration.
 * http://www.intertech.com/Blog/spring-4-conditional-bean-configuration/
 * http://www.opencredo.com/2014/02/24/experiences-with-spring-boot/
 * 
 */
@Configuration(DataConstants.MONGO_CONFIGURATION)
@Profile(ProfileConstants.DEVELOPMENT)
public class DevelopmentMongoConfiguration extends AbstractMongoConfiguration {
	
	@Override
	protected String getDatabaseName() {
		return DataConstants.DEFAULT_MONGO_DATABASE_NAME;
	}

	@Override
	public Mongo mongo() throws Exception {
		return new Fongo(getDatabaseName()).getMongo();
	}

	

}
