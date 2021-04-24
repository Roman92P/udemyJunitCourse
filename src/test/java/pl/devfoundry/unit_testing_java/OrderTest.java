package pl.devfoundry.unit_testing_java;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderTest {
	
	private Order order;
	
	@BeforeEach
	void InitializeOrder() {
		order = new Order();
	}
	
	@AfterEach
	void cleanUp() {
		System.out.println("Order was cleaned up!");
		order.cancel();
	}
	

	@Test
	void testAssertArrayEquals() {
		// given
		int[] ints1 = { 1, 2, 3 };
		int[] ints2 = { 1, 2, 3 };
		// then
		assertArrayEquals(ints1, ints2);
	}

	@Test
	void mealListShouldBeEmptyAfterCreationOdOrder() {
		// given
		// when
		List<Meal> meals = order.getMeals();
		// then
//		assertThat(meals.size()).isEqualTo(0);
//		assertThat(meals.size(), hasSize(0));
		assertThat(meals.size(), equalTo(0));
//		assertThat(meals.size(),empty());
//		assertThat(meals.size(), emptyCollectionOf(Meal.class));
	}

	@Test
	void addingMealToOrderShouldIncreaseOrderSize() {
		// given
		int size = order.getMeals().size();

		// when
		order.addMealToOrder(new Meal(1, "test"));
		List<Meal> meals1 = order.getMeals();
		// then
//		assertThat(meals1.size()).isGreaterThan(size);
	}

	@Test
	void removingMealFromOrderShouldDecreaseOrderMealsSize() {
		// given
		Meal meal = new Meal(1, "Burger");
		// when
		order.addMealToOrder(meal);
		order.removeMealFromOrder(meal);
		// then
		assertThat(order.getMeals(), hasSize(0));

	}

	@Test
	void mealsShouldBeInCorrectOrderAfterAddinfThemToOrder() {
		// given
		Meal meal1 = new Meal(1, "Burger");
		Meal meal2 = new Meal(2, "Frytki");
		// when
		order.addMealToOrder(meal1);
		order.addMealToOrder(meal2);
		//then
//		assertThat(order.getMeals(), contains(meal1, meal2));
		assertThat(order.getMeals(), containsInAnyOrder(meal2, meal1));
	}
	
	@Test
	void ifTwoMealListsAreTheSame() {
		//given
		Meal meal1 = new Meal(1, "Burger");
		Meal meal2 = new Meal(2, "Frytki");
		Meal meal3 = new Meal(3, "Sandwich");
		
		List<Meal> mealList1 = Arrays.asList(meal1, meal2);
		List<Meal> mealList2= Arrays.asList(meal1, meal2);
		
		//then
		assertThat(mealList1, is(mealList2));
	}

}