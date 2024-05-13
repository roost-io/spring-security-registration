// ********RoostGPT********
/*
Test generated by RoostGPT for test spring-security using AI Type Claude AI and AI Model claude-3-opus-20240229

ROOST_METHOD_HASH=createRoleIfNotFound_7b323bbc12
ROOST_METHOD_SIG_HASH=createRoleIfNotFound_d2ef1ab665

Here are the JUnit test scenarios for the provided createRoleIfNotFound method:

Scenario 1: Role Exists with Same Privileges

Details:
  TestName: roleExistsWithSamePrivileges
  Description: This test verifies that when a role with the given name already exists and has the same privileges, the existing role is returned without creating a new one.
Execution:
  Arrange: Create a role with the target name and privileges, and save it using the roleRepository mock.
  Act: Invoke the createRoleIfNotFound method with the same name and privileges.
  Assert: Assert that the returned role is the same as the pre-existing one, and verify that roleRepository.save() was not called.
Validation:
  The assertion ensures that the method correctly identifies an existing role and avoids creating a duplicate. This test is important to maintain data integrity and prevent redundant roles in the system.

Scenario 2: Role Exists with Different Privileges

Details:
  TestName: roleExistsWithDifferentPrivileges
  Description: This test checks that when a role with the given name exists but has different privileges, the existing role is updated with the new privileges and saved.
Execution:
  Arrange: Create a role with the target name and different privileges, and save it using the roleRepository mock.
  Act: Invoke the createRoleIfNotFound method with the same name but different privileges.
  Assert: Assert that the returned role has the updated privileges, and verify that roleRepository.save() was called once.
Validation:
  The assertion confirms that the method correctly updates the privileges of an existing role when necessary. This test ensures that role privileges can be modified dynamically.

Scenario 3: Role Does Not Exist

Details:
  TestName: roleDoesNotExist
  Description: This test verifies that when a role with the given name does not exist, a new role is created with the provided name and privileges.
Execution:
  Arrange: Configure the roleRepository mock to return null when findByName() is called with the target name.
  Act: Invoke the createRoleIfNotFound method with the desired name and privileges.
  Assert: Assert that the returned role has the expected name and privileges, and verify that roleRepository.save() was called once.
Validation:
  The assertion ensures that the method correctly creates a new role when one does not already exist. This test covers the scenario of adding new roles to the system.

Scenario 4: Null Privileges

Details:
  TestName: nullPrivileges
  Description: This test checks the behavior of the method when the provided privileges collection is null.
Execution:
  Arrange: Create a role with the target name and save it using the roleRepository mock.
  Act: Invoke the createRoleIfNotFound method with the same name and a null privileges collection.
  Assert: Assert that the returned role has no privileges (an empty collection), and verify that roleRepository.save() was called once.
Validation:
  The assertion verifies that the method handles a null privileges collection gracefully by setting an empty collection instead. This test ensures the robustness of the method against null input.

Scenario 5: Empty Privileges

Details:
  TestName: emptyPrivileges
  Description: This test verifies the behavior of the method when the provided privileges collection is empty.
Execution:
  Arrange: Create a role with the target name and save it using the roleRepository mock.
  Act: Invoke the createRoleIfNotFound method with the same name and an empty privileges collection.
  Assert: Assert that the returned role has no privileges (an empty collection), and verify that roleRepository.save() was called once.
Validation:
  The assertion confirms that the method correctly handles an empty privileges collection by setting an empty collection on the role. This test ensures that roles can be created without any privileges if needed.

These test scenarios cover various aspects of the createRoleIfNotFound method, including handling existing roles, updating privileges, creating new roles, and dealing with edge cases like null or empty privileges. They ensure the method behaves as expected in different situations and maintains data integrity in the system.
*/

// ********RoostGPT********
package com.baeldung.spring;

import com.baeldung.persistence.dao.RoleRepository;
import com.baeldung.persistence.model.Privilege;
import com.baeldung.persistence.model.Role;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SetupDataLoaderCreateRoleIfNotFoundTest {

	@Mock
	private RoleRepository roleRepository;

	@InjectMocks
	private SetupDataLoader setupDataLoader;

	private Collection<Privilege> privileges;

	@Before
	public void setUp() {
		privileges = new ArrayList<>(Arrays.asList(new Privilege("READ_PRIVILEGE"), new Privilege("WRITE_PRIVILEGE")));
	}

	@Test
	public void roleExistsWithSamePrivileges() {
		// Arrange
		String roleName = "ROLE_ADMIN";
		Role existingRole = new Role(roleName);
		existingRole.setPrivileges(privileges);
		when(roleRepository.findByName(roleName)).thenReturn(existingRole);

		// Act
		Role result = setupDataLoader.createRoleIfNotFound(roleName, privileges);

		// Assert
		assertEquals(existingRole, result);
		verify(roleRepository, never()).save(any(Role.class));
	}

	@Test
	public void roleExistsWithDifferentPrivileges() {
		// Arrange
		String roleName = "ROLE_ADMIN";
		Role existingRole = new Role(roleName);
		existingRole.setPrivileges(Collections.emptyList());
		when(roleRepository.findByName(roleName)).thenReturn(existingRole);
		when(roleRepository.save(existingRole)).thenReturn(existingRole);

		// Act
		Role result = setupDataLoader.createRoleIfNotFound(roleName, privileges);

		// Assert
		assertEquals(existingRole, result);
		assertEquals(privileges, result.getPrivileges());
		verify(roleRepository, times(1)).save(existingRole);
	}

	@Test
	public void roleDoesNotExist() {
		// Arrange
		String roleName = "ROLE_ADMIN";
		Role newRole = new Role(roleName);
		newRole.setPrivileges(privileges);
		when(roleRepository.findByName(roleName)).thenReturn(null);
		when(roleRepository.save(any(Role.class))).thenReturn(newRole);

		// Act
		Role result = setupDataLoader.createRoleIfNotFound(roleName, privileges);

		// Assert
		assertNotNull(result);
		assertEquals(roleName, result.getName());
		assertEquals(privileges, result.getPrivileges());
		verify(roleRepository, times(1)).save(any(Role.class));
	}

	@Test
	public void nullPrivileges() {
		// Arrange
		String roleName = "ROLE_ADMIN";
		Role existingRole = new Role(roleName);
		when(roleRepository.findByName(roleName)).thenReturn(existingRole);
		when(roleRepository.save(existingRole)).thenReturn(existingRole);

		// Act
		Role result = setupDataLoader.createRoleIfNotFound(roleName, null);

		// Assert
		assertEquals(existingRole, result);
		assertEquals(Collections.emptyList(), result.getPrivileges());
		verify(roleRepository, times(1)).save(existingRole);
	}

	@Test
	public void emptyPrivileges() {
		// Arrange
		String roleName = "ROLE_ADMIN";
		Role existingRole = new Role(roleName);
		when(roleRepository.findByName(roleName)).thenReturn(existingRole);
		when(roleRepository.save(existingRole)).thenReturn(existingRole);

		// Act
		Role result = setupDataLoader.createRoleIfNotFound(roleName, Collections.emptyList());

		// Assert
		assertEquals(existingRole, result);
		assertEquals(Collections.emptyList(), result.getPrivileges());
		verify(roleRepository, times(1)).save(existingRole);
	}

}
