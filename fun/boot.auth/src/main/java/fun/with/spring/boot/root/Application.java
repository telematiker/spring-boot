package fun.with.spring.boot.root;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
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
public class Application implements CommandLineRunner {

	private static final String PRINT_DELIMETER = PrintConstants.PRINT_DELIMETER;
	
	/** The Constant COMMAND_LINE_ARGS. */
	private static final String COMMAND_LINE_ARGS = "commandLineArgs";

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
		commandLineArgs(env);
	}

	

	/**
	 * Command line args.
	 *
	 * @param env
	 *            the env
	 */
	private static void commandLineArgs(Environment env) {
		String property = env.getProperty(COMMAND_LINE_ARGS);
		logger.info("Look at command line args:");
		printDelimeter();
		logger.info(property);
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
