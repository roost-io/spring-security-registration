

package com.baeldung.spring;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestOperations;
import static org.junit.Assert.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

public class CaptchaConfigRestTemplateTest {

	private CaptchaConfig captchaConfig;

	@Before
	public void setup() {
		captchaConfig = new CaptchaConfig();
	}

	@Test
	public void checkRestTemplateCreation() {
		RestOperations restTemplate = captchaConfig.restTemplate();

		assertNotNull(restTemplate);
		assertTrue(restTemplate instanceof RestTemplate);
	}

	@Test
	public void checkHttpRequestFactoryInRestTemplate() {
		RestTemplate restTemplate = (RestTemplate) captchaConfig.restTemplate();
		ClientHttpRequestFactory requestFactory = restTemplate.getRequestFactory();
		assertNotNull(requestFactory);
		assertTrue(requestFactory instanceof SimpleClientHttpRequestFactory);
	}

  // This test case might be failing if the mock function throws an exception 
  // different than RuntimeException or if the restTemplate() method in 
  // CaptchaConfig class does not call the clientHttpRequestFactory() method.
	@Test(expected = RuntimeException.class) 
	public void handleRestTemplateExceptions() throws Exception {
		CaptchaConfig mockCaptchaConfig = Mockito.mock(CaptchaConfig.class);
		Mockito.when(mockCaptchaConfig.clientHttpRequestFactory()).thenThrow(new RuntimeException());
		mockCaptchaConfig.restTemplate();
	}

}
