package fun.with.spring.boot.boundaries;

import org.springframework.hateoas.Link;

// TODO: Auto-generated Javadoc
/**
 * The Interface ExternalService.
 */
public interface ExternalService {

	
	/**
	 * Gets the link.
	 *
	 * @return the link
	 */
	public Link getLink();
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName();
}
