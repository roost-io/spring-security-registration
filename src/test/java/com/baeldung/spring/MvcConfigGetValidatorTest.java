

public class MvcConfigGetValidatorTest {

	@Mock
	private MessageSource messageSource;

	@InjectMocks
	private MvcConfig config;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);  // Make sure that MockitoAnnotations is imported correctly to avoid errors
	}

	@Test
	public void testNewValidatorNotNull() {
		Validator validator = config.getValidator();
		assertNotNull(validator);  // Make sure that assertNotNull is imported correctly
	}

	@Test
	public void testValidationMessageSourceSet() {
		LocalValidatorFactoryBean validator = (LocalValidatorFactoryBean) config.getValidator();
		assertEquals(validator.getValidationMessageSource(), messageSource); // Make sure that assertEquals is imported correctly
	}

	@Test(expected = NullPointerException.class)
	public void testGetValidatorWithNullMessageSource() {
		config.setMessageSource(null);
		config.getValidator();
	}

	@Test
	public void testValidatorIsInstanceOfLocalValidatorFactoryBean() {
		Validator validator = config.getValidator();
		assertTrue(validator instanceof LocalValidatorFactoryBean); // Make sure that assertTrue is imported correctly
	}
}
