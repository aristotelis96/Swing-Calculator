package swing;

public class Number {
	private String number_str;
	
	public Number() {
		number_str = "";
	}
	public void add(String num) {
		try {
			number_str+= num;
		}
		catch(Exception e) {
			number_str = number_str.substring(0, number_str.length()-1);
		}
	}
	
	@Override
	public String toString() {
		return (number_str);
		
	}
	public void clear() {
		number_str = "";
	}
	public void sum(Number num2) {
		number_str = Integer.toString( num2.getNumber() + Integer.parseInt(number_str) );
		
	}
	public int getNumber() {
		return Integer.parseInt(number_str);
	}
	public void set(int n) {
		number_str = Integer.toString(n);
	}
	public void sub(Number num2) {
		number_str = Integer.toString(Integer.parseInt(number_str) - num2.getNumber());
	}
	public void mul(Number num2) {
		number_str = Integer.toString( num2.getNumber() * Integer.parseInt(number_str) );
	}
	public void div(Number num2) {
		number_str = Integer.toString(Integer.parseInt(number_str)/num2.getNumber() );
	}
	
}	
