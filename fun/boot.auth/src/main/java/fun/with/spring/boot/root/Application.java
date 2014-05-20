package fun.with.spring.boot.root;

import java.text.MessageFormat;
import java.util.Arrays;

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

import fun.with.spring.boot.services.ArgumentService;

@Controller
@EnableAutoConfiguration
@ComponentScan(basePackages ={"fun.with.spring.boot"} )
public class Application implements CommandLineRunner {

	private static final String COMMAND_LINE_ARGS = "commandLineArgs";

	@Resource
	Environment env;

	@RequestMapping("/")
	@ResponseBody
	String root() {
		return Application.class.getName() + " is running!";
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(
				Application.class, args);

		//registers the args given by the main method to ArgumentService
		registerCommandLineConfiguration(ctx, args);

		inspectBeans(ctx);
		
		inspectEnvironment(ctx);

	}

	private static void inspectEnvironment(ConfigurableApplicationContext ctx) {
		Environment env = ctx.getBean(Environment.class);
		activeProfiles(env);
		commandLineArgs(env);
	}

	private static void registerCommandLineConfiguration(
			ConfigurableApplicationContext ctx, String[] args) {
		ArgumentService bean = ctx.getBean(ArgumentService.class);
		bean.addArguments(args);
		
	}

	private static void commandLineArgs(Environment env) {
		String property = env.getProperty(COMMAND_LINE_ARGS);
		System.out.println("Look at command line args:");
		printDelimeter();
		System.out.println(property);
		printDelimeter();

	}

	private static void activeProfiles(Environment env) {
		System.out.println("Look at the active profiles:");
		printDelimeter();

		String[] activeProfiles = env.getActiveProfiles();

		for (int i = 0; i < activeProfiles.length; i++) {
			System.out.println(activeProfiles[i]);
		}
		String[] defaultProfiles = env.getDefaultProfiles();

		for (int i = 0; i < defaultProfiles.length; i++) {
			System.out.println(defaultProfiles[i]);
		}

		printDelimeter();
	}

	private static void inspectBeans(ConfigurableApplicationContext ctx) {
		System.out.println("Let's inspect the beans provided by Spring Boot:");
		printDelimeter();
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
		printDelimeter();
	}

	@Override
	public void run(String... arg0) throws Exception {
		printArgs(arg0);

	}

	private void printArgs(String... arg0) {
		System.out.println(MessageFormat.format(
				"run {1} with the following environment variables",
				Application.class.getName()));
		printDelimeter();
		for (int i = 0; i < arg0.length; i++) {
			System.out.println(arg0[i]);
		}
		printDelimeter();
	}

	private static void printDelimeter() {
		System.out.println("-------------------------------------------------");
	}

}
