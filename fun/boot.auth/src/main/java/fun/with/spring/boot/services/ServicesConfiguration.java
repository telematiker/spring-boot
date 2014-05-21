package fun.with.spring.boot.services;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.github.fakemongo.Fongo;
import com.mongodb.Mongo;

/**
 * The Class ServicesConfiguration.
 */
@Configuration
@EnableMongoRepositories(basePackages = "fun.with.spring.boot.boundaries")
public class ServicesConfiguration extends AbstractMongoConfiguration {

	
	
	

	@Override
	protected String getDatabaseName() {
		return "mongo_server_1";
	}

	@Override
	public Mongo mongo() throws Exception {
		return new Fongo(getDatabaseName()).getMongo();
	}

	

}
