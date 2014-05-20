package fun.with.spring.boot.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

@Service
public class ConfiguiredWebServices {

	@Autowired
	private ArgumentService arguments;
	
	public ConfiguiredWebServices(){
		
	}
	
	private List<Link> services = new LinkedList<Link>();
	
	public List<Link> getServices(){
		return services;
		
	}
	
	public void addLink(Link link){
		this.services.add(link);
	}
	
	
}
