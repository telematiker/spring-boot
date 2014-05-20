package fun.with.spring.boot.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfiguiredWebServices.
 */
@Service
public class ConfiguiredWebServices {

	/** The arguments. */
	@Autowired
	private ArgumentService arguments;
	
	/**
	 * Instantiates a new configuired web services.
	 */
	public ConfiguiredWebServices(){
		
	}
	
	/** The services. */
	private List<Link> services = new LinkedList<Link>();
	
	/**
	 * Gets the services.
	 *
	 * @return the services
	 */
	public List<Link> getServices(){
		return services;
		
	}
	
	/**
	 * Adds the link.
	 *
	 * @param link
	 *            the link
	 */
	public void addLink(Link link){
		this.services.add(link);
	}
	
	
}
