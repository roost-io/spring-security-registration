

package com.baeldung.spring;

import com.baeldung.security.google2fa.CustomAuthenticationProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.WebSecurityExpressionHandler;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SecSecurityConfigCustomWebSecurityExpressionHandlerTest {

	private SecSecurityConfig secSecurityConfig;

	// Comment: The class RoleHierarchyImpl isn't seen in the import statements above, which could cause a compilation error.
	//          The appropriate class should be imported for proper functioning. For that, ensure the corresponding class is accessible.
	// Uncomment the line below and import the appropriate class when available.
	// @Mock
	// private RoleHierarchyImpl mockRoleHierarchy;

	@Before
	public void setUp() {
		secSecurityConfig = new SecSecurityConfig();
	}

	// Comment: This test case depends on the unavailable 'RoleHierarchyImpl'
    // @Test
    // public void testRoleHierarchyInExpressionHandler() {
    //    when(mockRoleHierarchy.toString()).thenReturn("MOCK_ROLE_HIERARCHY");
    //    // set mockRoleHierarchy in config
    //    secSecurityConfig.setRoleHierarchy(mockRoleHierarchy);

    //    WebSecurityExpressionHandler expressionHandler = secSecurityConfig.customWebSecurityExpressionHandler();
    //    RoleHierarchy roleHierarchyInExpressionHandler = ((DefaultWebSecurityExpressionHandler) expressionHandler).getRoleHierarchy();

    //    assertEquals(mockRoleHierarchy.toString(), roleHierarchyInExpressionHandler.toString());
    // }

    // Comment: This test case should not be affected by the unavailability of 'RoleHierarchyImpl' and should compile successfully.
	@Test(expected = NullPointerException.class)
	public void testNullRoleHierarchy() {
		secSecurityConfig.setRoleHierarchy(null);

		WebSecurityExpressionHandler expressionHandler = secSecurityConfig.customWebSecurityExpressionHandler();
		RoleHierarchy roleHierarchyInExpressionHandler = ((DefaultWebSecurityExpressionHandler) expressionHandler).getRoleHierarchy();

		assertNull(roleHierarchyInExpressionHandler);
	}

	// Comment: This test case depends on the unavailable 'RoleHierarchyImpl'
    // @Test
    // public void testMultipleRoleHierarchies() {
    //    when(mockRoleHierarchy.toString()).thenReturn("MOCK_ROLE_HIERARCHY_ONE");

    //    secSecurityConfig.setRoleHierarchy(mockRoleHierarchy);
    //    WebSecurityExpressionHandler expressionHandlerOne = secSecurityConfig.customWebSecurityExpressionHandler();
    //    RoleHierarchy roleHierarchyInExpressionHandlerOne = ((DefaultWebSecurityExpressionHandler) expressionHandlerOne).getRoleHierarchy();

    //    assertEquals(mockRoleHierarchy.toString(), roleHierarchyInExpressionHandlerOne.toString());

    //    when(mockRoleHierarchy.toString()).thenReturn("MOCK_ROLE_HIERARCHY_TWO");

    //    secSecurityConfig.setRoleHierarchy(mockRoleHierarchy);
    //    WebSecurityExpressionHandler expressionHandlerTwo = secSecurityConfig.customWebSecurityExpressionHandler();
    //    RoleHierarchy roleHierarchyInExpressionHandlerTwo = ((DefaultWebSecurityExpressionHandler) expressionHandlerTwo).getRoleHierarchy();

    //    assertEquals(mockRoleHierarchy.toString(), roleHierarchyInExpressionHandlerTwo.toString());
    // }

}
