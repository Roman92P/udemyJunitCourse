package pl.devfoundry.unit_testing_java;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	private List<Order> orders = new ArrayList<>();
	
	void addOrderToCard(Order order) {
		this.orders.add(order);
	}
	
	void clearCard() {
		this.orders.clear();
	}
	
	void simulateLargeOrder() {
		for(int i = 0; i <1000; i++) {
			Meal meal = new Meal(i%10, "hamburger no " + i);
			Order order = new Order();
			addOrderToCard(order);
		}
		System.out.println("Cart size: " + orders.size());
		clearCard();
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}
