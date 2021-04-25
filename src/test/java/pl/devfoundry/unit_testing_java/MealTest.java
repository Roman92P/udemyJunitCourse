package pl.devfoundry.unit_testing_java;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class MealTest {

	@Test
	void shouldReturnDiscountedPrice() {
		// Given
		Meal meal = new Meal(35);
		// When
		int discountedPrice = meal.getDiscountedPrice(7);
		// Then
		assertEquals(28, discountedPrice);
		// use hamcrest
		assertThat(discountedPrice, equalTo(28));
	}

	@Test
	void referencesToTheSameObjectsShouldBeEqual() {
		// Given
		Meal meal = new Meal(10);
		Meal meal1 = meal;
		// Then
		assertSame(meal, meal1);
		// assertSame
		assertThat(meal, sameInstance(meal1));
	}

	@Test
	void referencesToTheDiferentObjectsShouldNotBeEqual() {
		// Given
		Meal meal = new Meal(10);
		Meal meal1 = new Meal(20);
		// Then
		assertNotSame(meal, meal1);
		// assertSame
		assertThat(meal, not(sameInstance(meal1)));
	}

	@Test
	void twoMealsShouldBeEqualWhenThePriceAndNameAreTheSame() {
		// Given
		Meal meal1 = new Meal(10, "Pizza");
		Meal meal2 = new Meal(10, "Pizza");
		// When
		assertEquals(meal1, meal2);
	}

	@Test
	void exceptionShouldBeThrownIfDiscountIsHigherThanMealPrice() {
		// given
		Meal meal = new Meal(10, "Corn-Dog");
		int discount = 11;
		// when
		// then
		assertThrows(IllegalArgumentException.class, () -> meal.getDiscountedPrice(discount));
	}

	@ParameterizedTest
	@ValueSource(ints = { 5, 10, 15, 18 })
	void mealPricesShouldBeLowerThan20(int prices) {
		assertThat(prices, lessThan(20));
	}

	@ParameterizedTest
	@MethodSource("createMealsWithNameAndPrice")
	void burgerShouldHaveCorrectNameAndPrice(String name, int price) {
		assertThat(name, containsString("burger"));
		assertThat(price, greaterThanOrEqualTo(10));
	}

	@ParameterizedTest
	@MethodSource("createCakeNames")
	void cakeNamesShouldEndWithCake(String name) {
		assertThat(name, notNullValue());
		assertThat(name, endsWith("cake"));
	}

	private static Stream<Arguments> createMealsWithNameAndPrice() {
		return Stream.of(Arguments.of("Hamburger", 10), Arguments.of("Cheeseburger", 12));
	}

	private static Stream<String> createCakeNames() {
		List<String> cakeNames = Arrays.asList("Cheesecake", "Fruitcake", "Cupcake");
		return cakeNames.stream();
	}

	
	  @Disabled
	  @ExtendWith(IAExceptionIgnoreExtension.class)
	  @ParameterizedTest
	  @ValueSource(ints = { 1, 3, 5, 8 }) void mealPricesShouldBeLowerThan10(int
	  prices) { if (prices > 5) { throw new IllegalArgumentException(); }
	  assertThat(prices, lessThan(20)); }
	 

	@TestFactory
	Collection<DynamicTest> dynamicTestCollection() {
		return Arrays.asList(
				dynamicTest("Dynamic test: ",()-> assertThat(5, lessThan(6)))
				);
		
	}
}
