package fun.with.spring.boot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;

import fun.with.spring.boot.root.DataConstants;
import fun.with.spring.boot.root.ProfileConstants;

@Configuration(DataConstants.MONGO_CONFIGURATION)
@Profile(ProfileConstants.PRODUCTION)
public class DeploymentMongoConfiguration extends AbstractMongoConfiguration {

	@Autowired
	private Mongo client;
	
	@Override
	protected String getDatabaseName() {
		return DataConstants.DEFAULT_MONGO_DATABASE_NAME;
	}

	@Override
	public Mongo mongo() throws Exception {
		return client;
	}

}
