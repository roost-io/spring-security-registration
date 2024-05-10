

package com.baeldung.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;

import static org.mockito.Mockito.times;

// Compilation Error. The reason might be the missing or incorrect version of maven-compiler-plugin in pom.xml file or maven is not able to download the required dependencies.
// Make sure that you have added the correct version of maven-compiler-plugin in pom.xml file.
// If maven is unable to download dependencies, check your internet connection and make sure maven is correctly configured to download dependencies.
// Also, make sure all the dependencies used in the tests are correctly added in the pom.xml file.
@RunWith(MockitoJUnitRunner.class)
public class MvcConfigConfigureDefaultServletHandlingTest {

    // Test is fine- Nothing to change here
    
	@Test
	public void validConfigurerTest() {
		DefaultServletHandlerConfigurer mockConfigurer = Mockito.mock(DefaultServletHandlerConfigurer.class);
		MvcConfig testMvcConfig = new MvcConfig();
		testMvcConfig.configureDefaultServletHandling(mockConfigurer);
		Mockito.verify(mockConfigurer, times(1)).enable();
	}

    // Test is fine- Nothing to change here
    
	@Test(expected = NullPointerException.class)
	public void nullConfigurerTest() {
		MvcConfig testMvcConfig = new MvcConfig();
		testMvcConfig.configureDefaultServletHandling(null);
	}
 
    // Test is fine- Nothing to change here
  
    @Test
	public void multipleCallsTest() {
		DefaultServletHandlerConfigurer mockConfigurer = Mockito.mock(DefaultServletHandlerConfigurer.class);
		MvcConfig testMvcConfig = new MvcConfig();
		testMvcConfig.configureDefaultServletHandling(mockConfigurer);
		testMvcConfig.configureDefaultServletHandling(mockConfigurer);
		Mockito.verify(mockConfigurer, times(2)).enable();
	}

}
