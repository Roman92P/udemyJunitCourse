package pl.devfoundry.testNG;

import org.testng.annotations.Test;

public class Test2 {
	
	@Test(groups= {"regres"})
	void test2() {
		System.out.println("Test 2");
	}

}