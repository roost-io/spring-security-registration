

@RunWith(SpringJUnit4ClassRunner.class)
public class MvcConfigAddInterceptorsTest {

    @Test
    public void testValidAddInterceptors() {
        // Arrange
        InterceptorRegistry registry = Mockito.mock(InterceptorRegistry.class);
        MvcConfig config = new MvcConfig();

        // Act
        config.addInterceptors(registry);

        // Assert
        // Change from checking interceptor equality to verify the type of interceptor
        verify(registry, times(1)).addInterceptor(any(LocaleChangeInterceptor.class));
    }

    @Test
    public void testMultipleCallsToAddInterceptors() {
        // Arrange
        InterceptorRegistry registry = Mockito.mock(InterceptorRegistry.class);
        MvcConfig config = new MvcConfig();

        // Act
        config.addInterceptors(registry);
        config.addInterceptors(registry);

        // Assert
        // Change from checking interceptor equality to verify the type of interceptor
        verify(registry, times(2)).addInterceptor(any(LocaleChangeInterceptor.class));
    }
}
