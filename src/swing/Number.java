package swing;

public class Number {
	private int number;
	private String number_str;
	
	public Number() {
		number_str = "";
		number = 0;
	}
	public void add(String parseInt) {
		try {
			number_str+= parseInt;
			number = Integer.parseInt(number_str);
		}
		catch(Exception e) {
			number_str = number_str.substring(0, number_str.length()-1);
			number = Integer.parseInt(number_str);
		}
	}
	
	@Override
	public String toString() {
		return (number_str);
		
	}
	public void clear() {
		number_str = "";
		number = 0;
	}
	public void sum(Number num2) {
		number+=num2.getNumber();
		number_str = Integer.toString(number);
	}
	public int getNumber() {
		return Integer.parseInt(number_str);
	}
	public void set(int n) {
		number = n;
		number_str = Integer.toString(n);
	}
	public void sub(Number num2) {
		number-=num2.getNumber();
		number_str = Integer.toString(number);		
	}
	public void mul(Number num2) {
		number*=num2.getNumber();
		number_str = Integer.toString(number);		
	}
	public void div(Number num2) {
		number/=num2.getNumber();
		number_str = Integer.toString(number);		
	}
	
}	
