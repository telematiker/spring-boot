package fun.with.spring.boot;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import fun.with.spring.boot.boundaries.Credentials;
import fun.with.spring.boot.boundaries.Token;
import fun.with.spring.boot.boundaries.Token.Type;
import fun.with.spring.boot.impl.TokenImpl;
import fun.with.spring.boot.root.Application;

// TODO: Auto-generated Javadoc

/**
 * The Class AuthControllerTest.
 * 
 * http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/
 * #boot-features-testingy
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:8080")
public class AuthControllerTest {

	/** The template. */
	RestTemplate template = new TestRestTemplate();

	/**
	 * Gets the root test.
	 *
	 * @return the root test
	 */
	@Test
	public void getRootTest() {
		ResponseEntity<String> entity = template.getForEntity(
				"http://127.0.0.1:8080", String.class);
		String body = entity.getBody();
		Assert.assertEquals(Application.APPLICATION_ROOT_MESSAGE, body);
	}

	/**
	 * Register user test.
	 */
	@Test
	public void registerUserTest() {
		// ResponseEntity<Token> entity = template.getForEntity(
		// "http://127.0.0.1:8080/register", Token.class);
		// Token body = entity.getBody();
		// Assert.assertEquals(Application.APPLICATION_ROOT_MESSAGE, body);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		Credentials credentials = new Credentials("userId", "hashedPassword");
		HttpEntity<Credentials> requestEntity = new HttpEntity<Credentials>(
				credentials, headers);

		ResponseEntity<TokenImpl> entity = template.postForEntity(
				"http://127.0.0.1:8080/register", requestEntity,
				TokenImpl.class);

		Token body = entity.getBody();
		Assert.assertEquals("hashedPassword", body.getValue());
		Assert.assertEquals(Type.SESSION, body.getType());

	}

}
