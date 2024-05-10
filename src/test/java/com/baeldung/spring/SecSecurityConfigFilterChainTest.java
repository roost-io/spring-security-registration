

/* 
Scenario 1: Validate valid staff accessing roleHierarchy
 * Might fail in case the MockUser service is not creating the valid staff user correctly
 * or if the HTTP MockRequest is not properly set. The business logic might also fail if 
 * the filterChain method does not process requests correctly or if the role-hierarchy 
 * management is incorrect.
 */ 

/*
Scenario 2: Invalid staff accessing roleHierarchy
 * Might fail if the MockUser service fails to create a user without having the STAFF 
 * role correctly or if the HTTP MockRequest is not properly set. This scenario can also 
 * fail if the filterChain method allows all types of users to access the /roleHierarchy 
 * endpoint without checking for the required staff role.
 */
 
/*
Scenario 3: User without required authority for updatePassword
 * Might fail if the MockUser service fails to create a user without 
 * CHANGE_PASSWORD_PRIVILEGE correctly or if the MockRequest to /user/updatePassword* is 
 * not properly set. This scenario can also fail in case the filterChain method allows 
 * users without CHANGE_PASSWORD_PRIVILEGE to access the /user/updatePassword* endpoint.
*/
 
/*
Scenario 4: Success login redirection
 * The success of this test might be affected if the MockAuthentication service is not 
 * working properly, the MockRequest for the login is not correctly set, or if the 
 * application's redirection logic (part of the filterChain method) returns incorrect 
 * redirection URLs. 
*/
 
/*
Scenario 5: Remember me functionality test
 * This scenario might fail if the MockAuthentication service can not mock a user 
 * correctly or if the 'remember me' cookie logic is not accurately implemented within the 
 * filterChain method, where the system is supposed to remember the user's details and set
 * the cookie for subsequent requests.
*/
