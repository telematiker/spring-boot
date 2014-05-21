package fun.with.spring.boot;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import fun.with.spring.boot.root.Application;
/**
 * http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#boot-features-testingy
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:8080")
public class AuthControllerTest {

	RestTemplate template = new TestRestTemplate();
	
	@Test
	public void getRootTest() {
		ResponseEntity<String> entity = template.getForEntity("http://127.0.0.1:8080", String.class);
		String body = entity.getBody();
		Assert.assertEquals(Application.APPLICATION_ROOT_MESSAGE, body);
		
		
	}

}
