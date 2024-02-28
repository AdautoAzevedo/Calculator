package business_layer;


//This class receives the string of the operation and calculates 
public class Operations {
	
	public static double calculate(double num1, String op, double num2) {
		
		double result = 0;
		switch (op) {
		case "+":
			result=(num1+num2);
			break;
		case "-":
			result= (num1-num2);
			break;
		case "*":
			result=(num1*num2);
			break;
		case "/":
			if (num2 != 0) {
				result = num1/num2;
			} else {
				throw new ArithmeticException("Division by zero");
			}
			break;
		default:
			throw new IllegalArgumentException("Invalid operation");
		}
		return result;
	}
	
}
