package fun.with.spring.boot.impl;

import org.springframework.hateoas.Link;

import fun.with.spring.boot.boundaries.ExternalService;

// TODO: Auto-generated Javadoc
/**
 * The Class ExternalServiceImpl.
 */
public class ExternalServiceImpl implements ExternalService {

	/** The name. */
	private String name;
	
	/** The link. */
	private Link link;

	/**
	 * Instantiates a new external service impl.
	 *
	 * @param name
	 *            the name
	 * @param link
	 *            the link
	 */
	public ExternalServiceImpl(String name, Link link) {
		this.name = name;
		this.link = link;
	}

	/* (non-Javadoc)
	 * @see fun.with.spring.boot.boundaries.ExternalService#getLink()
	 */
	@Override
	public Link getLink() {
		return link;
	}

	/* (non-Javadoc)
	 * @see fun.with.spring.boot.boundaries.ExternalService#getName()
	 */
	@Override
	public String getName() {
		return name;
	}
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExternalServiceImpl other = (ExternalServiceImpl) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ExternalServiceImpl [name=" + name + ", link=" + link + "]";
	}
	
	

}
