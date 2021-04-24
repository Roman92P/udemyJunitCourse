package pl.devfoundry.testNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test1 {

	@Test(groups = {"example"})
	void test1() {
		System.out.println("Test1");
	}
	@Parameters({"db"})
	@Test(groups = {"example", "regres"})
	void test1_2(String db) {
		System.out.println("Test1_2"+" "+db);
	}
	@Test(groups= {"example"})
	void test1_3() {
		System.out.println("Test1_3");
	}
}
