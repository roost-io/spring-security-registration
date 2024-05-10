

package com.baeldung.spring;

import org.junit.Test;
import org.junit.Assert;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * The test class is assumed to be a static nested class inside the original class from
 * which the method is defined. That's why we use the parent reference to call the method.
 * If it's not the case, please instantiate the original class directly. Please adjust
 * based on to your class design
 */
public class SecSecurityConfigPasswordEncoderTest {

	@Test
	public void testPasswordEncoderObjectCreation() {
    // This test can fail if the passwordEncoder() method is not implemented correctly in the ExampleClass, or the method does not return a PasswordEncoder instance.
		// assuming the method is defined in the parent class
		ExampleClass parent = new ExampleClass();
		PasswordEncoder passwordEncoder = parent.passwordEncoder();
		Assert.assertTrue(passwordEncoder instanceof PasswordEncoder);
	}

	@Test
	public void testPasswordEncoderInstance() {
    // This test can fail if the passwordEncoder() method does not return an instance of BCryptPasswordEncoder.
		// assuming the method is defined in the parent class
		ExampleClass parent = new ExampleClass();
		PasswordEncoder passwordEncoder = parent.passwordEncoder();
		Assert.assertTrue(passwordEncoder instanceof BCryptPasswordEncoder);
	}

	@Test
	public void testBCryptPasswordEncoderStrength() {
    // This test can fail if the passwordEncoder() method does not return a BCryptPasswordEncoder instance with a strength of 11.
		// assuming the method is defined in the parent class
		ExampleClass parent = new ExampleClass();
		PasswordEncoder passwordEncoder = parent.passwordEncoder();
		BCryptPasswordEncoder encoder = (BCryptPasswordEncoder) passwordEncoder;
		Assert.assertEquals(11, encoder.getStrength());
	}

}
