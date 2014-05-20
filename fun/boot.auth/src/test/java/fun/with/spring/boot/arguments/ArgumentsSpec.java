package fun.with.spring.boot.arguments;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import fun.with.spring.boot.services.ArgumentService;

public class ArgumentsSpec {

	private static final String KEY1 = "file1";
	private static final String KEY2 = "hello";
	private static final String KEY3 = "file2";

	private static final String ARG1 = "-" + KEY1 + "=abc.txt";
	private static final String ARG2 = "-" + KEY2 + "=world";
	private static final String ARG3 = "-" + KEY3 + "=how-are-you.txt";

	private static String[] DEFAULT_ARGS;
	private static String[] EMPTY_ARGS;

	@BeforeClass
	public static void setUp() {
		DEFAULT_ARGS = new String[] { ARG1, ARG2, ARG3 };
		EMPTY_ARGS = new String[] {};
	}

	@Test
	public void testArguments1() {
		ArgumentService arguments = initDefaultArgs();
		Assert.assertNotNull(arguments);
	}

	private ArgumentService initDefaultArgs() {
		ArgumentService arguments = new ArgumentService();
		arguments.addArguments(DEFAULT_ARGS);
		return arguments;
	}

	@Test
	public void testArguments2() {
		ArgumentService arguments = new ArgumentService();
		arguments.addArguments(EMPTY_ARGS);
		Assert.assertNotNull(arguments);
	}

	@Test
	public void testGetKeys1() {
		ArgumentService arguments = initDefaultArgs();
		Collection<Object> keys = arguments.getKeys();

		Assert.assertTrue(keys.contains(KEY1));
		Assert.assertTrue(keys.contains(KEY2));
		Assert.assertTrue(keys.contains(KEY3));

	}
	
	@Test
	public void testGetKeys2() {
		ArgumentService arguments =  new ArgumentService();
		Collection<Object> keys = arguments.getKeys();
		Assert.assertTrue(keys.isEmpty());
		

	}

	@Test
	public void testHasValueForKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetValueObjectObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetValueObject() {
		fail("Not yet implemented");
	}

}
