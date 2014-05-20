package fun.with.spring.boot.services;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import fun.with.spring.boot.root.CommandLineConstants;
import fun.with.spring.boot.root.PrintConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfiguiredWebServices.
 */
@Service(value = "ConfiguiredWebServices")
public class ConfiguiredWebServices {

	/** The application context. */
	@Autowired
	private ApplicationContext applicationContext;

	/** The logger. */
	private Logger logger = Logger.getLogger(ConfiguiredWebServices.class
			.getName());

	/** The external web services properties. Loads this from the command line arg: --{@link CommandLineConstants#EXTERNAL_WEB_SERVICE_PROPERTIES}=file:c:\some\file\props.properties*/
	@Value("${" + CommandLineConstants.EXTERNAL_WEB_SERVICE_PROPERTIES + "}")
	private String EXTERNAL_WEB_SERVICES_PROPERTIES = CommandLineConstants.DEFAULT_EXTERNAL_WEB_SERVICE_PROPERTIES;

	/**
	 * Instantiates a new configuired web services.
	 */
	public ConfiguiredWebServices() {

	}

	/** The services. */
	private List<Link> services = new LinkedList<Link>();

	/**
	 * Gets the services.
	 *
	 * @return the services
	 */
	public List<Link> getServices() {
		return services;

	}

	/**
	 * Adds the link.
	 *
	 * @param link
	 *            the link
	 */
	public void addLink(Link link) {
		this.services.add(link);
	}

	/**
	 * Inits the.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@PostConstruct
	public void init() throws IOException {

		Properties properties = loadProperties(EXTERNAL_WEB_SERVICES_PROPERTIES);
		createLinksToExternalWebservices(properties);
		printAllServices(services);

	}

	/**
	 * Prints the all services.
	 *
	 * @param services
	 *            the services
	 */
	private void printAllServices(List<Link> services) {
		logger.info(MessageFormat.format(
				"lets have a look at external web services: {0}",
				EXTERNAL_WEB_SERVICES_PROPERTIES));
		logger.info(PrintConstants.PRINT_DELIMETER);
		for (Link link : services) {
			logger.info(MessageFormat.format("external service: {0} ", link));
		}
		logger.info(PrintConstants.PRINT_DELIMETER);

	}

	/**
	 * Creates the links to external webservices.
	 *
	 * @param properties
	 *            the properties
	 */
	private void createLinksToExternalWebservices(Properties properties) {
		ArrayList<Object> list = Collections.list(properties.keys());
		for (Object object : list) {
			addLink(new Link(properties.getProperty((String) object)));
		}
	}

	/**
	 * Load properties.
	 *
	 * @param value
	 *            the value
	 * @return the properties
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private Properties loadProperties(String value) throws IOException {
		InputStream inputStream = null;
		Properties properties = null;
		try {
			Resource resource = applicationContext.getResource(value);
			properties = new Properties();
			inputStream = resource.getInputStream();
			properties.load(inputStream);

		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
		return properties;
	}

	/**
	 * Clean.
	 */
	@PreDestroy
	public void clean() {

	}

}
