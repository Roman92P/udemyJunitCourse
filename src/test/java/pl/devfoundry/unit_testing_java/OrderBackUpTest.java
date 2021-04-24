package pl.devfoundry.unit_testing_java;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderBackUpTest {

	private static OrderBackUp orderBackUp;

	// in JU4 BeforeClass
	@BeforeAll
	static void setup() throws FileNotFoundException {
		orderBackUp = new OrderBackUp();
		orderBackUp.createFile();
	}

	@BeforeEach
	void appendAtTheStartOfTheLine() throws IOException {
		orderBackUp.getWriter().append("New order: ");
	}

	@Test
	void backUpOrderWithOneMeal() throws IOException {
		// given
		Meal meal = new Meal(1, "apple");
		Order order = new Order();
		order.addMealToOrder(meal);
		// when
		System.out.println(order.getMeals());
		orderBackUp.backUpOrder(order);
		// then
		System.out.println("Order: " + order.toString() + " backed up!");
	}

	// in JU4 AfterClass
	@AfterAll
	static void tearDown() throws IOException {
		orderBackUp.closeFile();
	}

	@AfterEach
	void appendAtTheEndOfTheLine() throws IOException {
		orderBackUp.getWriter().append("backed up.");
	}

}
