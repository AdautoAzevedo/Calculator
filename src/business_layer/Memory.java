package business_layer;
import java.util.ArrayList;


public class Memory {
	private ArrayList<String> numbers;
	
	public Memory() {
		numbers = new ArrayList<String>();
	}
	//This is design for concatenate each number clicked and returning the full number
	public String getNumbers() {
		String fullNumber = "";
		
		for (String num : numbers) {
			fullNumber+= num;
		}
		
		return fullNumber;
		
	}
	
	public void setNumber(String number) {
		numbers.add(number);
	}
	
	public void resetArray() {
		numbers.clear();
	}
}
