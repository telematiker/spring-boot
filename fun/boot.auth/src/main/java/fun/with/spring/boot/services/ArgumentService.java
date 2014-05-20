package fun.with.spring.boot.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

import org.springframework.stereotype.Service;


// TODO: Auto-generated Javadoc
/**
 * Bean that stores the given command line parameters.
 */
@Service(value = "Arguments")
public class ArgumentService {

	/** The Constant ARGUMENT_IDENTIFIER. */
	private static final String ARGUMENT_IDENTIFIER = "-";

	/** The Constant ARGUMENT_DELIMETER. */
	private static final String ARGUMENT_DELIMETER = "=";

	/** The properties. */
	Properties properties = new Properties();
	
	/**
	 * Adds the arguments.
	 *
	 * @param args
	 *            the args
	 */
	public void addArguments(String[] args) {
		for (int i = 0; i < args.length; i++) {
			String lineArgument = args[i];
			lineArgument = removeMinus(lineArgument);
			String[] split = lineArgument.split(ARGUMENT_DELIMETER);
			properties.put(split[0], split[1]);
		}
	}

	/**
	 * Removes the minus.
	 *
	 * @param lineArgument
	 *            the line argument
	 * @return the string
	 */
	private String removeMinus(String lineArgument) {
		lineArgument = lineArgument.replaceFirst(ARGUMENT_IDENTIFIER, "");
		return lineArgument;
	}

	/**
	 * Gets the keys.
	 *
	 * @return the keys
	 */
	public Collection<Object> getKeys() {
		ArrayList<Object> keys = Collections.list(properties.keys());
		return keys;

	}

	/**
	 * Checks for value for key.
	 *
	 * @param key
	 *            the key
	 * @return true, if successful
	 */
	public boolean hasValueForKey(Object key) {
		boolean containsKey = properties.containsKey(key);
		if (containsKey) {
			containsKey = properties.get(key) != null;
		}
		return containsKey;
	}

	/**
	 * Gets the value.
	 *
	 * @param key
	 *            the key
	 * @param defaultValue
	 *            the default value
	 * @return the value
	 */
	public Object getValue(Object key, Object defaultValue) {
		return properties.getOrDefault(key, defaultValue);

	}

	/**
	 * Gets the value.
	 *
	 * @param key
	 *            the key
	 * @return the value
	 */
	public Object getValue(Object key) {
		return properties.get(key);
	}

	

	

}
