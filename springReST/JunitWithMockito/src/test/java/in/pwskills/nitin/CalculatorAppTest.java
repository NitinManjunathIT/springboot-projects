package in.pwskills.nitin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import in.pwskills.nitin.calculator.CalculatorApp;

public class CalculatorAppTest {
	
	static {
		System.out.println("CalculatorAppTest.class file is loading()");
	}
	
	public CalculatorAppTest() {
		System.out.println("CalcualtorAppTestObject is created...");
	}
	
	static CalculatorApp app =null;
	
	@BeforeAll
	public static void setUp() {
		//creating a setup for testing environment
		System.out.println("CalculatorAppTest.setUp()");
		 app = new CalculatorApp();
	}
	

    //Test case for add(a,b)
	@Test
	public void testAdd() {
		System.out.println("CalculatorAppTest.testAdd()");
		int expected = 30;
		int actual = app.add(10,20);
		
		//use junit annotations to test the result
		assertEquals(expected, actual);
	}
	
	//Test case for isEven(a)
	@Test
	public void testIsEven() {
		System.out.println("CalculatorAppTest.testIsEven()");
		boolean yes = app.isEven(20);
		
		//use junit annotations to test the result
		assertTrue(yes);	
	}
	
	@AfterAll
	public static void cleanUp() {
		//creating an environment for closing the resource
		System.out.println("CalculatorAppTest.cleanUp()");
		app =null;
		System.out.println("*************");
	}
	
}
