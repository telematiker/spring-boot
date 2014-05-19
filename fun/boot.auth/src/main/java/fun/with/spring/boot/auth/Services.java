package fun.with.spring.boot.auth;

import java.util.LinkedList;
import java.util.List;

import org.springframework.hateoas.Link;

public class Services {

	public Services(){
		
	}
	
	private List<Link> services = new LinkedList<Link>();
	
	public List<Link> getServices(){
		return services;
		
	}
	
	public void addLink(Link link){
		this.services.add(link);
	}
	
	
}
