package pl.devfoundry.unit_testing_java;

//import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AccountTest {

	@Test
	void newAccountShouldNotBeActiveAfterCreation() {
		//Given
		Account newAccount = new Account();
		//Then
		assertFalse(newAccount.isActive(),"Check if new Account is activated");
		//assertJ
//		assertThat(newAccount.isActive()).isFalse();
	}
	
	@Test
	void newAccountShouldBeActiveAfterAcivation() {
		//Given
		Account newAccount = new Account();
		//When
		newAccount.activate();
		//Then
		assertTrue(newAccount.isActive());
		//hamcres
		assertThat(newAccount.isActive(), equalTo(true));
//		assertThat(newAccount.isActive(), is(true));
	}
	
	@Test
	void newCreatedAccountShouldNotHaveDefaultDeliveryAddressSet() {
		//Given
		Account account = new Account();
		//When
		Address defaultDeliveryAddress = account.getDefaultDeliveryAddress();
		//Then
		assertNull(defaultDeliveryAddress);
		//hamcrest
		assertThat(defaultDeliveryAddress, nullValue());
		//or we can add is before nullValue
//		assertThat(defaultDeliveryAddress, is(nullValue()));

		
	}
	
	@Test
	void defaultDeliveryAddressShouldNotBeNullAfterSet() {
		//Given
		Account account = new Account();
		account.setDefaultDeliveryAddress(new Address ("Ulica", "1"));
		//When
		Address defaultDeliveryAddress = account.getDefaultDeliveryAddress();
		//Then
		assertNotNull(defaultDeliveryAddress,"Address can't be null");
	}

}
 