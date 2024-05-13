// ********RoostGPT********
/*
Test generated by RoostGPT for test spring-security using AI Type Claude AI and AI Model claude-3-opus-20240229

ROOST_METHOD_HASH=localeResolver_26a3deacfe
ROOST_METHOD_SIG_HASH=localeResolver_48401fafe2

Here are the JUnit test scenarios for the provided `localeResolver` method:

Scenario 1: Default Locale Configuration

Details:
  TestName: defaultLocaleConfiguration
  Description: This test verifies that the `localeResolver` method correctly sets the default locale to `Locale.ENGLISH` when creating a new instance of `CookieLocaleResolver`.
Execution:
  Arrange: No specific arrangement required.
  Act: Invoke the `localeResolver` method to obtain an instance of `LocaleResolver`.
  Assert: Use `assertEquals` to check if the default locale of the returned `LocaleResolver` is set to `Locale.ENGLISH`.
Validation:
  The assertion ensures that the `localeResolver` method properly configures the default locale to `Locale.ENGLISH` as expected.
  Setting the default locale is important to provide a fallback locale when no specific locale is specified or available.

Scenario 2: Locale Resolver Type

Details:
  TestName: localeResolverType
  Description: This test verifies that the `localeResolver` method returns an instance of `CookieLocaleResolver`.
Execution:
  Arrange: No specific arrangement required.
  Act: Invoke the `localeResolver` method to obtain an instance of `LocaleResolver`.
  Assert: Use `assertTrue` to check if the returned `LocaleResolver` is an instance of `CookieLocaleResolver`.
Validation:
  The assertion confirms that the `localeResolver` method returns the expected type of locale resolver, which is `CookieLocaleResolver`.
  Using `CookieLocaleResolver` allows the application to store and retrieve the user's locale preference using cookies.

Scenario 3: Locale Resolver Singleton

Details:
  TestName: localeResolverSingleton
  Description: This test verifies that multiple invocations of the `localeResolver` method return the same instance of `LocaleResolver`.
Execution:
  Arrange: No specific arrangement required.
  Act: Invoke the `localeResolver` method twice to obtain two instances of `LocaleResolver`.
  Assert: Use `assertSame` to check if the two obtained instances are the same object.
Validation:
  The assertion ensures that the `localeResolver` method returns a singleton instance of `LocaleResolver`.
  Using a singleton instance of `LocaleResolver` is beneficial for performance and consistency throughout the application.

Scenario 4: Null Default Locale

Details:
  TestName: nullDefaultLocale
  Description: This test verifies that the `localeResolver` method throws an exception when attempting to set the default locale to `null`.
Execution:
  Arrange: Create a new instance of `CookieLocaleResolver`.
  Act: Invoke the `setDefaultLocale` method of `CookieLocaleResolver` with `null` as the argument.
  Assert: Use `assertThrows` to check if an `IllegalArgumentException` is thrown.
Validation:
  The assertion confirms that setting the default locale to `null` is not allowed and results in an exception.
  Handling the case of a null default locale ensures the robustness and reliability of the locale resolution mechanism.

These test scenarios cover different aspects of the `localeResolver` method, including the default locale configuration, the type of locale resolver returned, the singleton nature of the locale resolver, and the handling of a null default locale. They help ensure the correct behavior and configuration of the locale resolution mechanism in the application.
*/

// ********RoostGPT********
package com.baeldung.spring;

import org.junit.Test;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import java.util.Locale;
import static org.junit.Assert.*;

public class MvcConfigLocaleResolverTest {

	@Test
	public void defaultLocaleConfiguration() {
		// Arrange
		MvcConfig mvcConfig = new MvcConfig();
		// Act
		LocaleResolver localeResolver = mvcConfig.localeResolver();
		// Assert
		assertEquals(Locale.ENGLISH, ((CookieLocaleResolver) localeResolver).getDefaultLocale());
	}

	@Test
	public void localeResolverType() {
		// Arrange
		MvcConfig mvcConfig = new MvcConfig();
		// Act
		LocaleResolver localeResolver = mvcConfig.localeResolver();
		// Assert
		assertTrue(localeResolver instanceof CookieLocaleResolver);
	}

	@Test
	public void localeResolverSingleton() {
		// Arrange
		MvcConfig mvcConfig = new MvcConfig();
		// Act
		LocaleResolver localeResolver1 = mvcConfig.localeResolver();
		LocaleResolver localeResolver2 = mvcConfig.localeResolver();
		// Assert
		assertSame(localeResolver1, localeResolver2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nullDefaultLocale() {
		// Arrange
		CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
		// Act
		cookieLocaleResolver.setDefaultLocale(null);
	}

	// Add a new test case to check if the default locale can be retrieved
	@Test
	public void getDefaultLocale() {
		// Arrange
		MvcConfig mvcConfig = new MvcConfig();
		LocaleResolver localeResolver = mvcConfig.localeResolver();
		// Act
		Locale defaultLocale = ((CookieLocaleResolver) localeResolver).getDefaultLocale();
		// Assert
		assertEquals(Locale.ENGLISH, defaultLocale);
	}

}
