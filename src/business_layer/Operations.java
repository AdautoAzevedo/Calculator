package business_layer;


//This class receives the string of the operation and calculates 
public class Operations {
	private double result;
	public Operations(double num1, String op, double num2) {
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
			result=(num1/num2);
			break;
		default:
			System.out.println("Send a allowed op");
			break;
		}
	}
	public double getResult() {
		return result;
	}
	
}
