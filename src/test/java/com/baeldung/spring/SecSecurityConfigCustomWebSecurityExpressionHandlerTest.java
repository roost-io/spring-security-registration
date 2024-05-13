// ********RoostGPT********
/*
Test generated by RoostGPT for test spring-security using AI Type Claude AI and AI Model claude-3-opus-20240229

ROOST_METHOD_HASH=customWebSecurityExpressionHandler_e6f0824726
ROOST_METHOD_SIG_HASH=customWebSecurityExpressionHandler_e099e00c57

Here are the JUnit test scenarios for the customWebSecurityExpressionHandler method:

Scenario 1: Verify customWebSecurityExpressionHandler returns a DefaultWebSecurityExpressionHandler instance

Details:
  TestName: customWebSecurityExpressionHandlerReturnsDefaultWebSecurityExpressionHandler
  Description: This test verifies that the customWebSecurityExpressionHandler method returns an instance of DefaultWebSecurityExpressionHandler.
Execution:
  Arrange: No specific arrangement required.
  Act: Invoke the customWebSecurityExpressionHandler method.
  Assert: Assert that the returned object is an instance of DefaultWebSecurityExpressionHandler using assertThat and isInstanceOf.
Validation:
  The assertion ensures that the method returns the expected type of expression handler.
  Returning the correct expression handler is crucial for handling security expressions in the application.

Scenario 2: Verify customWebSecurityExpressionHandler sets the role hierarchy

Details:
  TestName: customWebSecurityExpressionHandlerSetsRoleHierarchy
  Description: This test verifies that the customWebSecurityExpressionHandler method sets the role hierarchy on the returned DefaultWebSecurityExpressionHandler instance.
Execution:
  Arrange: Create a mock or stub implementation of the roleHierarchy method.
  Act: Invoke the customWebSecurityExpressionHandler method.
  Assert: Assert that the setRoleHierarchy method of the returned DefaultWebSecurityExpressionHandler instance is called with the result of the roleHierarchy method.
Validation:
  The assertion ensures that the role hierarchy is properly set on the expression handler.
  Setting the role hierarchy is important for evaluating security expressions based on the defined role hierarchy in the application.

Scenario 3: Verify customWebSecurityExpressionHandler handles null role hierarchy

Details:
  TestName: customWebSecurityExpressionHandlerHandlesNullRoleHierarchy
  Description: This test verifies that the customWebSecurityExpressionHandler method handles the case when the roleHierarchy method returns null.
Execution:
  Arrange: Modify the roleHierarchy method to return null.
  Act: Invoke the customWebSecurityExpressionHandler method.
  Assert: Assert that no exception is thrown and the returned DefaultWebSecurityExpressionHandler instance is not null.
Validation:
  The assertion ensures that the method can handle a null role hierarchy gracefully without throwing an exception.
  Handling null values prevents unexpected behavior and maintains the stability of the application.

Scenario 4: Verify customWebSecurityExpressionHandler returns a new instance each time

Details:
  TestName: customWebSecurityExpressionHandlerReturnsNewInstanceEachTime
  Description: This test verifies that the customWebSecurityExpressionHandler method returns a new instance of DefaultWebSecurityExpressionHandler each time it is invoked.
Execution:
  Arrange: No specific arrangement required.
  Act: Invoke the customWebSecurityExpressionHandler method multiple times.
  Assert: Assert that each invocation returns a new instance of DefaultWebSecurityExpressionHandler by comparing the returned objects using assertThat and not(sameInstance()).
Validation:
  The assertion ensures that the method returns a new instance of the expression handler each time it is called.
  Returning a new instance prevents sharing state between different invocations and maintains the independence of each security expression evaluation.

These test scenarios cover different aspects of the customWebSecurityExpressionHandler method, including the return type, setting the role hierarchy, handling null values, and ensuring a new instance is returned each time. They help validate the expected behavior and handle potential edge cases.
*/

// ********RoostGPT********
package com.baeldung.spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SecSecurityConfigCustomWebSecurityExpressionHandlerTest {

	private SecSecurityConfig secSecurityConfig;

	@Mock
	private RoleHierarchy roleHierarchy;

	@BeforeEach
	void setUp() {
		secSecurityConfig = new SecSecurityConfig();
		secSecurityConfig.roleHierarchy = roleHierarchy;
	}

	@Test
	void customWebSecurityExpressionHandlerReturnsDefaultWebSecurityExpressionHandler() {
		// Arrange
		// Act
		DefaultWebSecurityExpressionHandler result = (DefaultWebSecurityExpressionHandler) secSecurityConfig
			.customWebSecurityExpressionHandler();
		// Assert
		assertThat(result).isInstanceOf(DefaultWebSecurityExpressionHandler.class);
	}

	@Test
	void customWebSecurityExpressionHandlerSetsRoleHierarchy() {
		// Arrange
		DefaultWebSecurityExpressionHandler expressionHandler = new DefaultWebSecurityExpressionHandler();
		when(roleHierarchy.toString()).thenReturn("ROLE_ADMIN > ROLE_USER");
		// Act
		secSecurityConfig.customWebSecurityExpressionHandler();
		// Assert
		assertThat(expressionHandler.getRoleHierarchy()).isEqualTo(roleHierarchy);
	}

	@Test
	void customWebSecurityExpressionHandlerHandlesNullRoleHierarchy() {
		// Arrange
		secSecurityConfig.roleHierarchy = null;
		// Act
		DefaultWebSecurityExpressionHandler result = (DefaultWebSecurityExpressionHandler) secSecurityConfig
			.customWebSecurityExpressionHandler();
		// Assert
		assertThat(result).isNotNull();
	}

	@Test
	void customWebSecurityExpressionHandlerReturnsNewInstanceEachTime() {
		// Arrange
		// Act
		DefaultWebSecurityExpressionHandler result1 = (DefaultWebSecurityExpressionHandler) secSecurityConfig
			.customWebSecurityExpressionHandler();
		DefaultWebSecurityExpressionHandler result2 = (DefaultWebSecurityExpressionHandler) secSecurityConfig
			.customWebSecurityExpressionHandler();
		// Assert
		assertThat(result1).isNotSameAs(result2);
	}

}
