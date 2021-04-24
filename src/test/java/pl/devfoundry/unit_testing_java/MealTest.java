package pl.devfoundry.unit_testing_java;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MealTest {

	@Test
	void shouldReturnDiscountedPrice() {
		//Given
		Meal meal = new Meal(35);
		//When
		int discountedPrice = meal.getDiscountedPrice(7);
		//Then
		assertEquals(28, discountedPrice);
		//use hamcrest
		assertThat(discountedPrice, equalTo(28));
	}
	
	@Test
	void referencesToTheSameObjectsShouldBeEqual() {
		//Given
		Meal meal = new Meal(10);
		Meal meal1 = meal;
		//Then
		assertSame(meal, meal1);
		//assertSame
		assertThat(meal, sameInstance(meal1));
	}
	
	
	@Test
	void referencesToTheDiferentObjectsShouldNotBeEqual() {
		//Given
		Meal meal = new Meal(10);
		Meal meal1 = new Meal(20);
		//Then
		assertNotSame(meal, meal1);
		//assertSame
		assertThat(meal, not(sameInstance(meal1)));
	}
	
	@Test
	void twoMealsShouldBeEqualWhenThePriceAndNameAreTheSame() {
		//Given
		Meal meal1 = new Meal(10, "Pizza");
		Meal meal2 = new Meal(10, "Pizza");
		//When
		assertEquals(meal1, meal2);
	}
	
	@Test
	void exceptionShouldBeThrownIfDiscountIsHigherThanMealPrice() {
		//given
		Meal meal = new Meal(10, "Corn-Dog");
		int discount = 11;
		//when
		//then
		assertThrows(IllegalArgumentException.class, ()-> meal.getDiscountedPrice(discount));
	}

}
