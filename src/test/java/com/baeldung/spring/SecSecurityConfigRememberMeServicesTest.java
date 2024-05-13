

// Scenario 1: Valid Creation of CustomRememberMeServices
@Test
public void testValidCreationOfCustomRememberMeServices(){
    // Arrange already done in setup method

    // Act
    RememberMeServices result = serviceInstance.rememberMeServices();

    // Assert
    assertThat(result).isNotNull();
    assertThat(result).isInstanceOf(CustomRememberMeServices.class);
}

// Scenario 2: Validate the RememberMe Key
@Test
public void testValidRememberMeKey() {
    // Arrange already done in setup method

    // Act
    CustomRememberMeServices result = (CustomRememberMeServices) serviceInstance.rememberMeServices();

    // Assert
    assertThat(result.getCookieName()).isEqualTo("theKey");
}

// Scenario 3: Validate UserDetailsService in RememberMeServices
@Test
public void testUserDetailsServiceInRememberMeServices() {
    // Arrange already done in setup method

    // Act
    CustomRememberMeServices result = (CustomRememberMeServices) serviceInstance.rememberMeServices();

    // Assert
    assertThat(result.getUserDetailsService()).isEqualTo(mockedDetailsService);
}

// Scenario 4: Validate TokenRepository in RememberMeServices
@Test
public void testTokenRepositoryInRememberMeServices() {
    // Arrange already done in setup method

    // Act
    CustomRememberMeServices result = (CustomRememberMeServices) serviceInstance.rememberMeServices();

    // Assert
    assertThat(result.getTokenRepository()).isInstanceOf(InMemoryTokenRepositoryImpl.class);
}
