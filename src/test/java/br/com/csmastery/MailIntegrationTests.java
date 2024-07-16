package br.com.csmastery;

import br.com.csmastery.integration.MainIntegration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MailIntegrationTests {

	@Autowired
	private MainIntegration mainIntegration;

	@Test
	void contextLoads() {
		mainIntegration.send("Assunto tal", "h2milhome@gmail.com", "texto do corpo ");
	}

}
