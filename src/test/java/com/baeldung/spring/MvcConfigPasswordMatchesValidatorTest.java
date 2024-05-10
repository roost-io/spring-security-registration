

//[INFO]: Compilation error might be due to the environment or setup, not the test case. Ensure that project dependencies are properly set up and the referenced classes exist.

package com.baeldung.spring;

import com.baeldung.validation.PasswordMatchesValidator;
import org.junit.Test;
import org.junit.Assert;

public class MvcConfigPasswordMatchesValidatorTest {

    //[INFO]: Compilation error might be due to the environment or setup, not the test case. Ensure PasswordMatchesValidator is correctly implemented and accessible.
	@Test
	public void testPasswordMatchesValidatorInstantiation() {
		MvcConfig config = new MvcConfig();
		PasswordMatchesValidator validator = config.passwordMatchesValidator();

		Assert.assertNotNull("PasswordMatchesValidator object should not be null", validator);
		Assert.assertTrue("Object should be instance of PasswordMatchesValidator",
				validator instanceof PasswordMatchesValidator);
	}

    //[INFO]: Compilation error might be due to the environment or setup, not the test case. Ensure PasswordMatchesValidator and MvcConfig are correctly implemented and accessible.
	@Test
	public void testPasswordMatchesValidatorSeparation() {
		MvcConfig config = new MvcConfig();
		PasswordMatchesValidator validator1 = config.passwordMatchesValidator();
		PasswordMatchesValidator validator2 = config.passwordMatchesValidator();

		Assert.assertNotSame("Each invocation should return a separate PasswordMatchesValidator object", validator1,
				validator2);
	}

    //[INFO]: Compilation error might be due to the environment or setup, not the test case. Ensure PasswordMatchesValidator and MvcConfig are correctly implemented and accessible.
	@Test
	public void testPasswordMatchesValidatorTypeCheck() {
		MvcConfig config = new MvcConfig();
		Object returnVal = config.passwordMatchesValidator();

		Assert.assertTrue("Return value should be an instance of PasswordMatchesValidator",
				returnVal instanceof PasswordMatchesValidator);
	}

}
