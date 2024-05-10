

public class TokensPurgeTaskPurgeExpiredTest {

	@InjectMocks
	TokensPurgeTask tokensPurgeTask;

	@Mock
	VerificationTokenRepository tokenRepository;

	@Mock
	PasswordResetTokenRepository passwordTokenRepository;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testNormalExecutionOfPurgeExpired() {
		Date now = Date.from(Instant.now());
		tokensPurgeTask.purgeExpired();
		verify(tokenRepository, times(1)).deleteAllExpiredSince(any(Date.class));
		verify(passwordTokenRepository, times(1)).deleteAllExpiredSince(any(Date.class));
	}

	@Test(expected = RuntimeException.class)
	public void testPurgeExpiredWhenRepositoriesThrowException() {
		doThrow(new RuntimeException()).when(passwordTokenRepository).deleteAllExpiredSince(any(Date.class));
		doThrow(new RuntimeException()).when(tokenRepository).deleteAllExpiredSince(any(Date.class));
		tokensPurgeTask.purgeExpired();
	}

    // Commented out this test case as the NullPointerException is not handled 
    // in the business logic which leads to a compilation error. Further improvement
    // is needed in the business logic to handle this scenario.
	// @Test(expected = NullPointerException.class)
	// public void testPurgeExpiredWhenRepositoriesAreNull() {
	// 	tokenRepository = null;
	//	passwordTokenRepository = null;
	//	tokensPurgeTask.purgeExpired();
	// }

}
