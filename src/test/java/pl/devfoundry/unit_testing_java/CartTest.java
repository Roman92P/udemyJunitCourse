package pl.devfoundry.unit_testing_java;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.emptyCollectionOf;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.List;

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
		
		assertThat(cart.getOrders(), allOf(
				notNullValue(),
				hasSize(1),
				is(not(empty())),
				is(not(emptyCollectionOf(Order.class)))
				));
		//w JUnit 5 mamy do dyspozycji assertAll
		assertAll("this is a group of assertions for cart",
				()->assertThat(cart.getOrders(), notNullValue()),
				()->assertThat(cart.getOrders(), hasSize(1)),
				()->assertThat(cart.getOrders(), is(not(empty()))),
				()->assertThat(cart.getOrders(), is(not(emptyCollectionOf(Order.class)))),
				()->assertThat(cart.getOrders().get(0).getMeals(), empty()),
				()->{
					List<Meal>mealList=cart.getOrders().get(0).getMeals();
					assertThat(mealList,empty());
				}
				);
	}
}
