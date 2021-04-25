package pl.devfoundry.unit_testing_java;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

class AddressTest {

	@ParameterizedTest
	@CsvSource({"Faryczna, 10","Armii Krajowej, 57/11","'Romka, Tomka, Atomka', 40"})
	void givenAddressesShouldNotBeEmptyAndHaveProperNames(String street, String number) {
		assertThat(street, notNullValue());
		assertThat(street, containsString("a"));
		assertThat(number, notNullValue());
		assertThat(number.length(), lessThan(8));
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/addresses.csv")
	void givenAddressesFromFileShouldNotBeEmptyAndHaveProperNames(String street, String number) {
		assertThat(street, notNullValue());
		assertThat(street, containsString("a"));
		assertThat(number, notNullValue());
		assertThat(number.length(), lessThan(8));
	}

}
