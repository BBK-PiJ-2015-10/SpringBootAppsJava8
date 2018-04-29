package com.in31.minutes.dogservices;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.boot.web.server.LocalServerPort;

import org.junit.runner.RunWith;

import java.util.Map;

import org.junit.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.BDDAssertions.then;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = { "management.port=0" })
public class DogServicesApplicationTests {

	@LocalServerPort
	private int port;

	@Value("${local.management.port}")
	private int mgmt;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void shouldReturn200WhenSendingRequestToController() throws Exception {

		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = this.testRestTemplate
				.getForEntity("http://localhost:" + this.mgmt + "/hello-world", Map.class);

		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	public void shouldReturn200WhenSendingRequestToManagementEndpoint() throws Exception {

		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = this.testRestTemplate
				.getForEntity("http://localhost:" + this.mgmt + "/actuator/info", Map.class);

		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
}
