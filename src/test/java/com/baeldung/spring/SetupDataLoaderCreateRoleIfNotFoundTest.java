

@RunWith(MockitoJUnitRunner.class)
public class SetupDataLoaderCreateRoleIfNotFoundTest {

	@InjectMocks
	SetupDataLoader setupDataLoader;

	@Mock
	RoleRepository roleRepository;

	// The following test should pass if Role Repository returns null when finding by name and
	// correctly saves a role when created with a new role name
	@Test
	public void createRoleWhenRoleDoesNotExist() {
		final String roleName = "ROLE_NEW";
		Privilege privilege = new Privilege();
		privilege.setName("PRIVILEGE_NEW");
		List<Privilege> privileges = Arrays.asList(privilege);

		when(roleRepository.findByName(roleName)).thenReturn(null);
		when(roleRepository.save(any(Role.class))).thenAnswer(i -> i.getArguments()[0]);

		Role role = setupDataLoader.createRoleIfNotFound(roleName, privileges);
		assertNotNull(role);
		assertEquals(privileges, role.getPrivileges());
	}

	// The following test should pass if Role Repository returns the existing role when finding by name and
	// correctly updates the privileges of the existing role
	@Test
	public void updateRolePrivilegesWhenRoleExists() {
		final String roleName = "ROLE_EXISTING";
		Privilege privilege = new Privilege();
		privilege.setName("PRIVILEGE_NEW");
		List<Privilege> privileges = Arrays.asList(privilege);

		Role existingRole = new Role();
		existingRole.setName(roleName);

		when(roleRepository.findByName(roleName)).thenReturn(existingRole);
		when(roleRepository.save(any(Role.class))).thenAnswer(i -> i.getArguments()[0]);

		Role role = setupDataLoader.createRoleIfNotFound(roleName, privileges);

		assertEquals(privileges, role.getPrivileges());
	}

	// The following test should pass if setupDataLoader.createRoleIfNotFound is designed to throw
	// an IllegalArgumentException when passed null parameters.
	@Test(expected = IllegalArgumentException.class)
	public void handleInvalidInputs() {
		setupDataLoader.createRoleIfNotFound(null, null);
	}

}
