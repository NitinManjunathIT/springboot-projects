package in.pwskills.nitin.calculator;

public class CalculatorApp {
	
	static {
		System.out.println("CalculatorApp.class file is loading...()");
	}
	
	public CalculatorApp() {
		System.out.println("CalculatorApp object is created....");
	}
	
	public int add(int a, int b) {
		return a + b;
	}

	public boolean isEven(int a) {
		return a % 2 == 0;
	}
 
}
