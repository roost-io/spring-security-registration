

package com.baeldung.spring;

import com.baeldung.persistence.dao.PrivilegeRepository;
import com.baeldung.persistence.model.Privilege;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class SetupDataLoaderCreatePrivilegeIfNotFoundTest {

	@Mock
	private PrivilegeRepository privilegeRepository;

	@InjectMocks
	private SetupDataLoader setupDataLoader;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void createValidPrivilegeIfNotFound() {
		String name = "NEW_PRIVILEGE";
		when(privilegeRepository.findByName(name)).thenReturn(null);
		Privilege newPrivilege = new Privilege();
		newPrivilege.setName(name);
		when(privilegeRepository.save(newPrivilege)).thenReturn(newPrivilege);
		Privilege privilege = setupDataLoader.createPrivilegeIfNotFound(name);
		assertNotNull(privilege);
		assertEquals(newPrivilege.getName(), privilege.getName());
	}

	@Test
	public void retrieveExistingPrivilegeIfNotFound() {
		String name = "EXISTING_PRIVILEGE";
		Privilege existingPrivilege = new Privilege();
		existingPrivilege.setName(name);
		when(privilegeRepository.findByName(name)).thenReturn(existingPrivilege);
		Privilege privilege = setupDataLoader.createPrivilegeIfNotFound(name);
		assertEquals(existingPrivilege, privilege);
		verify(privilegeRepository, times(1)).findByName(name);
		verify(privilegeRepository, times(0)).save(any(Privilege.class));
	}

	@Test(expected = NullPointerException.class)
	public void checkNullInputForPrivilege() {
		// This test expects a NullPointerException, which should be thrown when null is passed to the method createPrivilegeIfNotFound.
		// If createPrivilegeIfNotFound does not throw a NullPointerException when passed a null argument, this test will fail.
		setupDataLoader.createPrivilegeIfNotFound(null);
	}

}
