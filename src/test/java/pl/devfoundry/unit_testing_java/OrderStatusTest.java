package pl.devfoundry.unit_testing_java;

import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class OrderStatusTest {

	@ParameterizedTest
	@EnumSource(OrderStatus.class)
	void allOrderShouldBeShorterThan5Chars(OrderStatus orderStatus) {
		assertThat(orderStatus.toString().length(), lessThan(5));
	}
	

}
