package swing;

public class Number {
	private long number;
	
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
	
	public long getNumber() {
		return number;
	}
	public void set(long n) {
		number = n;
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
	
	private String formation(long remaining) {
		String formatted = "";
		long last_digits;
		
		boolean negative = false;
		if (remaining<0) {
			remaining *= -1;
			negative = true;
		}
		
		while (remaining>=1000) {
			last_digits = remaining % 1000;
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
		last_digits = remaining;
		formatted = Long.toString(last_digits) + formatted;
		if (negative) {
			formatted = "-" + formatted;
		}
		return formatted;
	}
	
}	