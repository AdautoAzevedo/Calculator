package business_layer;

public class Memory {
	private StringBuilder numberBuilder;
	private String operation;
	
	public Memory() {
		numberBuilder = new StringBuilder();
		operation = "";
	}
	//This is design for concatenate each number clicked and returning the full number
	public String getNumbers() {
		return numberBuilder.toString();
	}

	public String getOperation() {
		return operation;
	}
	
	public void appendNumber(String number) {
		if (!numberBuilder.toString().contains(".") || !number.equals(".")) {
			numberBuilder.append(number);
		}
	}

	public void setOperation(String op) {
		operation = op;
	}
	
	public void resetArray() {
		numberBuilder.setLength(0);
		operation = "";
	}
}
