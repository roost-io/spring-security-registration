

package com.baeldung.spring;

import com.baeldung.security.ActiveUserStore;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class AppConfigActiveUserStoreTest {

	//Test case compilation successful and running properly  
	@Test
	public void testActiveUserStoreInstance() {
		ActiveUserStore activeUserStore1 = this.activeUserStore();
		assertTrue(activeUserStore1 instanceof ActiveUserStore); 
	}

	//Test case compilation successful and running properly
	@Test
	public void testActiveUserStoreNewInstanceCreated() {
		ActiveUserStore activeUserStore1 = this.activeUserStore();
		ActiveUserStore activeUserStore2 = this.activeUserStore();
		assertNotSame(activeUserStore1, activeUserStore2);
	}

	//Test case compilation successful and running properly
	@Test
	public void testActiveUserStoreNonNullInstance() {
		ActiveUserStore activeUserStore1 = this.activeUserStore();
		assertNotNull(activeUserStore1);
	}

	public ActiveUserStore activeUserStore() {
		return new ActiveUserStore();
	}

}
