package fun.with.spring.boot.arguments;

import java.util.Collection;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import fun.with.spring.boot.services.ArgumentService;

// TODO: Auto-generated Javadoc
/**
 * The Class ArgumentsSpec.
 */
public class ArgumentsSpec {


	/** The Constant DEFAULT_VALUE. */
	private static final String DEFAULT_VALUE = "DEFAULT_VALUE";
	
	/** The Constant KEY1. */
	private static final String KEY1 = "file1";
	
	/** The Constant VALUE1. */
	private static final String VALUE1 = "abc.txt";

	/** The Constant KEY2. */
	private static final String KEY2 = "hello";
	
	/** The Constant VALUE2. */
	private static final String VALUE2 = "world";

	/** The Constant KEY3. */
	private static final String KEY3 = "file2";
	
	/** The Constant VALUE3. */
	private static final String VALUE3 = "how-are-you.txt";

	/** The Constant ARG1. */
	private static final String ARG1 = "-" + KEY1 + "="+VALUE1;
	
	/** The Constant ARG2. */
	private static final String ARG2 = "-" + KEY2 + "="+VALUE2;
	
	/** The Constant ARG3. */
	private static final String ARG3 = "-" + KEY3 + "="+VALUE3;
	
	
	/** The Constant FAKE_KEY. */
	private static final Object FAKE_KEY = "NoTaKey!";

	/** The default args. */
	private static String[] DEFAULT_ARGS;
	
	/** The empty args. */
	private static String[] EMPTY_ARGS;

	/**
	 * Sets the up.
	 */
	@BeforeClass
	public static void setUp() {
		DEFAULT_ARGS = new String[] { ARG1, ARG2, ARG3 };
		EMPTY_ARGS = new String[] {};
	}

	/**
	 * Test arguments1.
	 */
	@Test
	public void testArguments1() {
		ArgumentService arguments = initDefaultArgs();
		Assert.assertNotNull(arguments);
	}

	/**
	 * Inits the default args.
	 *
	 * @return the argument service
	 */
	private ArgumentService initDefaultArgs() {
		ArgumentService arguments = new ArgumentService();
		arguments.addArguments(DEFAULT_ARGS);
		return arguments;
	}

	/**
	 * Test arguments2.
	 */
	@Test
	public void testArguments2() {
		ArgumentService arguments = new ArgumentService();
		arguments.addArguments(EMPTY_ARGS);
		Assert.assertNotNull(arguments);
	}

	/**
	 * Test get keys1.
	 */
	@Test
	public void testGetKeys1() {
		ArgumentService arguments = initDefaultArgs();
		Collection<Object> keys = arguments.getKeys();

		Assert.assertTrue(keys.contains(KEY1));
		Assert.assertTrue(keys.contains(KEY2));
		Assert.assertTrue(keys.contains(KEY3));

	}
	
	/**
	 * Test get keys2.
	 */
	@Test
	public void testGetKeys2() {
		ArgumentService arguments =  new ArgumentService();
		Collection<Object> keys = arguments.getKeys();
		Assert.assertTrue(keys.isEmpty());
		

	}
	
	/**
	 * Test has value for key true.
	 */
	@Test
	public void testHasValueForKeyTrue() {
		ArgumentService arguments = initDefaultArgs();
		Assert.assertTrue(arguments.hasValueForKey(KEY1));
	}
	
	/**
	 * Test has value for key false.
	 */
	@Test
	public void testHasValueForKeyFalse() {
		ArgumentService arguments = initDefaultArgs();
		Assert.assertFalse(arguments.hasValueForKey(FAKE_KEY));
	}
	

	/**
	 * Test get value object1.
	 */
	@Test
	public void testGetValueObject1() {
		ArgumentService arguments = initDefaultArgs();
		Assert.assertEquals(VALUE1, arguments.getValue(KEY1));
	}
	
	/**
	 * Test get value object2.
	 */
	@Test
	public void testGetValueObject2() {
		ArgumentService arguments = initDefaultArgs();
		Assert.assertEquals(VALUE2, arguments.getValue(KEY2));
	}
	
	/**
	 * Test get value object3.
	 */
	@Test
	public void testGetValueObject3() {
		ArgumentService arguments = initDefaultArgs();
		Assert.assertEquals(VALUE3, arguments.getValue(KEY3));
	}

	

	/**
	 * Test get value default object.
	 */
	@Test
	public void testGetValueDefaultObject() {
		ArgumentService arguments = initDefaultArgs();
		Assert.assertEquals(DEFAULT_VALUE, arguments.getValue(FAKE_KEY, DEFAULT_VALUE));
	}

}
