package swing;

public class Number {
	private double number;
	
	public Number() {
		number = 0;
	}
	public void add(String num) {
		number*=10;
		number += Integer.parseInt(num);
	}
	
	@Override
	public String toString() {
		return formation(number);
		
	}
	public void clear() {
		number = 0;
	}
	
	public void sum(Number num2) {
		number += num2.getNumber();
	}
	
	public double getNumber() {
		return number;
	}
	public void set(double d) {
		number = d;
	}
	public void sub(Number num2) {
		number -= num2.getNumber();
	}
	public void mul(Number num2) {
		number *= num2.getNumber();
	}
	public void div(Number num2) {
		number /= num2.getNumber();
	}
	
	private String formation(double remaining) {
		String formatted = "";
		long last_digits;
		double decimal_part = 0;
		double result = 0;
		
		boolean negative = false;
		if (remaining<0) {
			remaining *= -1;
			negative = true;
		}
		last_digits = (long) remaining;
		decimal_part = remaining - last_digits;
		while (remaining>=1000) {
			last_digits = (long) remaining % 1000;
			if (last_digits >= 100) {
				formatted = "." + Long.toString(last_digits) + formatted;
			}
			else if (last_digits >= 10) {
				formatted = ".0" + Long.toString(last_digits) + formatted;
			}
			else if (last_digits >0) {
				formatted = ".00" + Long.toString(last_digits) + formatted;
			}
			else {
				formatted = ".000" + formatted;
			}
			remaining -= last_digits;
			remaining /= 1000;
		}
		last_digits = (long) remaining;
		if(decimal_part == 0.0) {
			formatted = Long.toString(last_digits) + formatted;
		}
		else {
			formatted = Long.toString(last_digits) + formatted + Double.toString(decimal_part).substring(1, Double.toString(decimal_part).length());
		}
		if (negative) {
			formatted = "-" + formatted;
		}
		return formatted;
	}
	
}	