package fun.with.spring.boot.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

import org.springframework.stereotype.Service;


/**
 * Bean that stores the given command line parameters
 *
 */
@Service(value = "Arguments")
public class ArgumentService {

	private static final String ARGUMENT_IDENTIFIER = "-";

	private static final String ARGUMENT_DELIMETER = "=";

	Properties properties = new Properties();
	
	public void addArguments(String[] args) {
		for (int i = 0; i < args.length; i++) {
			String lineArgument = args[i];
			lineArgument = removeMinus(lineArgument);
			String[] split = lineArgument.split(ARGUMENT_DELIMETER);
			properties.put(split[0], split[1]);
		}
	}

	private String removeMinus(String lineArgument) {
		lineArgument = lineArgument.replaceFirst(ARGUMENT_IDENTIFIER, "");
		return lineArgument;
	}

	public Collection<Object> getKeys() {
		ArrayList<Object> keys = Collections.list(properties.keys());
		return keys;

	}

	public boolean hasValueForKey(Object key) {
		boolean containsKey = properties.containsKey(key);
		if (containsKey) {
			containsKey = properties.get(key) != null;
		}
		return containsKey;
	}

	public Object getValue(Object key, Object defaultValue) {
		return properties.getOrDefault(key, defaultValue);

	}

	public Object getValue(Object key) {
		return properties.get(key);
	}

	

	

}
