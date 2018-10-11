package swing;

import java.awt.*;
import java.awt.event.*;
import java.text.spi.NumberFormatProvider;
import javax.swing.*;

public class MyFrame extends JFrame implements KeyListener{
	private static JPanel  results;
	private static JPanel buttons;
	private static JButton[] num = new JButton[10];
	private static JButton num_minus = new JButton("-");
	private static JButton num_plus = new JButton("+");
	private static JButton num_mul = new JButton("*");
	private static JButton num_div = new JButton("/");
	private static JButton num_equals = new JButton("=");
	private static JButton C = new JButton("C");
	private static boolean num1_now = true;
	private static String operation;
	private static Font myFont = new Font(Font.DIALOG, Font.PLAIN,40);


	private static Number num1 = new Number();
	private static Number num2 = new Number();
	private static Number result = new Number();

	//Constructor
	public MyFrame() {
		setResizable(false);
		setSize(400,600);
		results = new JPanel();
		buttons = new JPanel();
		setVisible(true);
		setupUI();
	}
	// Main Function
	public static void main (String[] args) {
		MyFrame calc = new MyFrame();
		calc.runApp();
		
	}
	
	protected void runApp() {
		((JLabel)(results.getComponent(0))).setText("0");
	}
	
	protected void setupUI() {
		//results window
		addKeyListener(this);
		setFocusable(true);
        setFocusTraversalKeysEnabled(false);
		results.setLayout(new BorderLayout());
		results.add(new JLabel("Test"),BorderLayout.EAST);
		
		((JLabel)(results.getComponent(0))).setFont(new Font(Font.DIALOG, Font.PLAIN,40));
		
		add(results, BorderLayout.NORTH);
		
		//buttons window
		buttons.setLayout(new GridLayout(4,4));
		for (int i=0; i<10; i++){
			num[i] = new JButton(Integer.toString(i));
			num[i].setFont(new Font(Font.DIALOG, Font.PLAIN,40));
		}
		num_minus.setFont(myFont);
		num_plus.setFont(myFont);
		num_equals.setFont(myFont);
		num_mul.setFont(myFont);
		num_div.setFont(myFont);
		C.setFont(myFont);
		//add button to grid
		buttons.add(num[7]);
		buttons.add(num[8]);
		buttons.add(num[9]);
		buttons.add(num_plus);
		buttons.add(num[4]);
		buttons.add(num[5]);
		buttons.add(num[6]);
		buttons.add(num_minus);
		buttons.add(num[1]);
		buttons.add(num[2]);
		buttons.add(num[3]);
		buttons.add(num_mul);
		buttons.add(C);
		buttons.add(num[0]);
		buttons.add(num_div);
		buttons.add(num_equals);


		//add grid to frame
		add(buttons,BorderLayout.CENTER);

		for(int i=0; i<10; i++) {
			num[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ev) {
					String keyPressed = ev.getActionCommand().toString();
					if(num1_now) {
						num1.add(keyPressed);
						((JLabel)results.getComponent(0)).setText(num1.toString());;
					}
					else {
						num2.add(keyPressed);
						((JLabel)results.getComponent(0)).setText(num2.toString());;
					}
				}
			});
		}
		num_plus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				if(!num1_now) {
					num_equals.doClick();
				}
				num1_now = false;
				num2.clear();
				operation = "+";
			}
		});
		num_minus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				if(!num1_now) {
					num_equals.doClick();
				}
				num1_now = false;
				num2.clear();
				operation = "-";			}
		});
		num_mul.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				if(!num1_now) {
					num_equals.doClick();
				}
				num1_now = false;
				num2.clear();
				operation = "*";			}
		});
		num_div.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				if(!num1_now) {
					num_equals.doClick();
				}
				num1_now = false;
				num2.clear();
				operation = "/";
			}
		});
		num_equals.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
					result.set(operate(num1, num2, operation));
					num1.set(result.getNumber());					
					((JLabel)results.getComponent(0)).setText(result.toString());;
					num1_now = true;
			}
			
			private long operate(Number num1, Number num2, String operation) {
				switch(operation) {
				case"+":
					num1.sum(num2);
					return num1.getNumber();
				case"-":
					num1.sub(num2);
					return num1.getNumber();
				case"*":
					num1.mul(num2);
					return num1.getNumber();
				case"/":
					num1.div(num2);
					return num1.getNumber();
				default:
					return (0);
				}
			}
		});
		
		C.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				num1.clear();
				num2.clear();
				num1_now = true;
				((JLabel)results.getComponent(0)).setText("0");;
				
			}
		});
		

	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		for (int i=0; i<10; i++) {
			//check if numpad or num key was pressed
			if((arg0.getKeyText(arg0.getKeyCode())).indexOf('0'+ (char) i)!=-1) {
				num[i].doClick();
			}
		}
		switch(arg0.getKeyText(arg0.getKeyCode())) {
		case"NumPad +":
			num_plus.doClick();
			break;
		case"NumPad -":
			num_minus.doClick();
			break;
		case"NumPad *":
			num_mul.doClick();
			break;
		case"NumPad /":
			num_div.doClick();
			break;
		case"Enter":
			num_equals.doClick();
			break;
		case"Escape":
			C.doClick();
			break;
		}

	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
	
}

