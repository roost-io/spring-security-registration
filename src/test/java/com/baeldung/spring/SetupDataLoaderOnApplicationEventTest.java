

import org.mockito.Mock;
import org.springframework.context.ApplicationContext;

@RunWith(MockitoJUnitRunner.class)
public class SetupDataLoaderOnApplicationEventTest {

	//...

	@Mock
	private ApplicationContext applicationContext;

	//...

	@Before
    public void setUp() {
        when(privilegeRepository.findByName(any(String.class))).thenReturn(Optional.empty());
        when(roleRepository.findByName(any(String.class))).thenReturn(Optional.empty());
        when(userRepository.findByEmail(any(String.class))).thenReturn(Optional.empty());
        when(applicationContext.getId()).thenReturn("testContextId");
    }

    //...

    @Test
    public void testSuccessfulApplicationEventStart() {
		ContextRefreshedEvent event = new ContextRefreshedEvent(applicationContext);
		setupDataLoaderOnApplicationEvent.onApplicationEvent(event);
		verify(privilegeRepository, times(3)).save(any(Privilege.class));
		verify(roleRepository, times(2)).save(any(Role.class));
		verify(userRepository, times(1)).save(any(User.class));
	}

    /*
	... // Test case not provided
	
	@Test
	public void yourTestName(){
		// Your test case goes here.
	}
	*/

    /*
	... // Test case not provided

	@Test
	public void yourTestName(){
		// Your test case goes here.
	}
	*/

    /*
	... // Test case not provided

	@Test
	public void yourTestName(){
		// Your test case goes here.
	}
	*/

	...
}
