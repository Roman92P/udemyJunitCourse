package pl.devfoundry.unit_testing_java;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.emptyCollectionOf;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test cases for Cart")
class CartTest {

	@Disabled
	//in JUnit4 testowaliśmy przez dodanie do adnotacji 
	//test dodatkowego parametru timeout
	@Test
	@DisplayName("Car is able to process 1000 orders in 10 ms")
	void testSimulateLargeOrder() {
		//given
		Cart cart = new Cart();
		//when
		//then
		assertTimeout(Duration.ofMillis(100),()->cart.simulateLargeOrder());
	}
	
	@Test
	@DisplayName("Cart is not epmty after adding order to it")
	void cartShouldNotBeEmptyAfterAddingOrderToCart() {
		//given
		Order order = new Order();
		Cart cart = new Cart();
		//when
		cart.addOrderToCard(order);
		//then
		//any of wystarczy aby jeden matcher był spełniony,
		//żeby asercja była spełniona
		assertThat(cart.getOrders(), anyOf(
				notNullValue(),
				hasSize(1),
				is(not(empty())),
				is(not(emptyCollectionOf(Order.class)))
				));
	}
}
