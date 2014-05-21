package fun.with.spring.boot.root;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// TODO: Auto-generated Javadoc
/**
 * The Class Application.
 */
@Controller
@EnableAutoConfiguration
@ComponentScan(basePackages = { "fun.with.spring.boot" })
@EnableMongoRepositories(basePackages = "fun.with.spring.boot.boundaries")
public class Application implements CommandLineRunner {

	private static final String PRINT_DELIMETER = PrintConstants.PRINT_DELIMETER;

	/** The env. */
	@Resource
	Environment env;

	private static Logger logger = Logger
			.getLogger(Application.class.getName());

	/**
	 * Root.
	 *
	 * @return the string
	 */
	@RequestMapping("/")
	@ResponseBody
	String root() {
		return Application.class.getName() + " is running!";
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(
				Application.class, args);

		inspectBeans(ctx);

		inspectEnvironment(ctx);

	}

	/**
	 * Inspect environment.
	 *
	 * @param ctx
	 *            the ctx
	 */
	private static void inspectEnvironment(ConfigurableApplicationContext ctx) {
		Environment env = ctx.getBean(Environment.class);
		activeProfiles(env);

		if (env instanceof ConfigurableEnvironment) {
			Iterator<PropertySource<?>> iterator = ((ConfigurableEnvironment) env)
					.getPropertySources().iterator();
			while (iterator.hasNext()) {
				PropertySource<?> propertySource = (PropertySource<?>) iterator
						.next();
				if (propertySource instanceof EnumerablePropertySource) {
					printProperties(propertySource.getName(),
							(EnumerablePropertySource) propertySource);
				} else {
					printProperties(propertySource.getName(), propertySource);
				}

			}
		}

	}

	private static void printProperties(String commandLineArgs,
			EnumerablePropertySource source) {

		logger.info(MessageFormat.format("Look at properties {0}:",
				commandLineArgs));
		printDelimeter();

		String[] propertyNames = source.getPropertyNames();
		for (int i = 0; i < propertyNames.length; i++) {
			String name = propertyNames[i];
			logger.info(MessageFormat.format("{0} --> {1}", name,source.getProperty(name)));
		}

		printDelimeter();
	}

	private static void printProperties(String commandLineArgs, PropertySource source) {

		logger.info(MessageFormat.format("Look at properties {0}:",
				commandLineArgs));
		printDelimeter();

		logger.info("Not enumerable "+source.getClass());

		printDelimeter();
	}

	/**
	 * Active profiles.
	 *
	 * @param env
	 *            the env
	 */
	private static void activeProfiles(Environment env) {
		logger.info("Look at the active profiles:");
		printDelimeter();

		String[] activeProfiles = env.getActiveProfiles();

		for (int i = 0; i < activeProfiles.length; i++) {
			logger.info(activeProfiles[i]);
		}
		String[] defaultProfiles = env.getDefaultProfiles();

		for (int i = 0; i < defaultProfiles.length; i++) {
			logger.info(defaultProfiles[i]);
		}

		printDelimeter();
	}

	/**
	 * Inspect beans.
	 *
	 * @param ctx
	 *            the ctx
	 */
	private static void inspectBeans(ConfigurableApplicationContext ctx) {
		logger.info("Let's inspect the beans provided by Spring Boot:");
		printDelimeter();
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			logger.info(beanName);
		}
		printDelimeter();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... arg0) throws Exception {
		printArgs(arg0);

	}

	/**
	 * Prints the args.
	 *
	 * @param arg0
	 *            the arg0
	 */
	private void printArgs(String... arg0) {
		logger.info(MessageFormat.format(
				"run {1} with the following environment variables",
				Application.class.getName()));
		printDelimeter();
		for (int i = 0; i < arg0.length; i++) {
			logger.info(arg0[i]);
		}
		printDelimeter();
	}

	/**
	 * Prints the delimeter.
	 */
	private static void printDelimeter() {
		logger.info(PRINT_DELIMETER);
	}

}
