package swing;

public class Number {
	private double number;
	private boolean dec ;
	private int dec_pos;
	
	public Number() {
		number = 0;
		dec = false;
		dec_pos = 1;
	}
	public void add(String num) {
		if(dec) {
			number += (Double.parseDouble(num)/(Math.pow(10,dec_pos)));
			dec_pos++;
		}
		else {
			number *= 10;
			number += Integer.parseInt(num);
		}
	}
	
	@Override
	public String toString() {
		return formation(number);
		
	}
	public void clear() {
		number = 0;
		dec = false;
		dec_pos = 1;
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
		System.out.println(number);
		String formatted = "";
		long last_digits;
		double decimal_part = 0;
		double result = 0;
		
		boolean negative = false;
		if (remaining<0) {
			remaining *= -1;
			negative = true;
		}
		formatted = Double.toString(remaining);
		
		String[] parts = formatted.split("\\.");
		String decimal = parts[0];
		String fractional = parts[1];
		
		remaining = Long.parseLong(decimal);
		decimal_part = Double.parseDouble(fractional);
		decimal_part = decimal_part / (Math.pow(10,fractional.length()));
		System.out.println(decimal_part);
		formatted = "";
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
		last_digits =  (long)remaining;
		
		if(decimal_part == 0.0) {
			formatted = Long.toString(last_digits) + formatted;
		}
		else {
			formatted = Long.toString(last_digits) + formatted + "," + Double.toString(decimal_part).substring(2, Double.toString(decimal_part).length());
		}
		if (negative) {
			formatted = "-" + formatted;
		}
		return formatted;
	}
	public void dec(boolean b) {
		dec = b;
	}
	
}	