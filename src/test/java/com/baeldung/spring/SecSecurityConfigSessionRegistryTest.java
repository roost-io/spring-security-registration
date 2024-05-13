

// Compilation failure: Ensure that the correct versions of maven and java are installed.
// Also, make sure that all dependencies in the pom.xml file are correct and can be resolved.

public class SecSecurityConfigSessionRegistryTest {

	private SecSecurityConfig configUnderTest;

	@Before
	public void setUp() {
		configUnderTest = new SecSecurityConfig();
	}

	// Test could not be compiled: Ensure all dependencies are correct and can be resolved.
	@Test
	public void testSessionRegistryInstantiation() {
		// Act
		SessionRegistry result = null;
		try {
			result = configUnderTest.sessionRegistry();
			// Assert
			assertThat(result).isNotNull();
			assertThat(result).isInstanceOf(SessionRegistryImpl.class);
		}
		catch (Exception e) {
			fail("Exception should not have been thrown - " + e.getMessage());
		}
	}

	// Test could not be compiled: Ensure all dependencies are correct and can be resolved.
	@Test
	public void testSessionRegistryNotNull() {
		// Act
		SessionRegistry result = null;
		try {
			result = configUnderTest.sessionRegistry();
			// Assert
			assertThat(result).isNotNull();
		}
		catch (Exception e) {
			fail("Exception should not have been thrown - " + e.getMessage());
		}
	}

	// Test could not be compiled: Ensure all dependencies are correct and can be resolved.
	@Test
	public void testRepeatSessionRegistryInstantiation() {
		// Act
		SessionRegistry result1 = null;
		SessionRegistry result2 = null;
		try {
			result1 = configUnderTest.sessionRegistry();
			result2 = configUnderTest.sessionRegistry();
			// Assert
			assertThat(result1).isNotNull();
			assertThat(result2).isNotNull();
			assertThat(result1).isNotEqualTo(result2);
		}
		catch (Exception e) {
			fail("Exception should not have been thrown - " + e.getMessage());
		}
	}

}
