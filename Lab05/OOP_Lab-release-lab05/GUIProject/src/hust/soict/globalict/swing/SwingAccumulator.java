package hust.soict.globalict.swing;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SwingAccumulator  extends JFrame{
	private JTextField textFieldInput;
	private JTextField textFieldOutput;
	private int sum = 0;
	
	public SwingAccumulator() {
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(2, 2));
		
		cp.add(new JLabel("Enter an integer: "));
		
		textFieldInput = new JTextField(10);
		cp.add(textFieldInput);
		textFieldInput.addActionListener(new textFieldInputListener());
		
		cp.add(new JLabel("Accumulated sum: "));
		
		textFieldOutput = new JTextField(10);
		textFieldOutput.setEditable(false);
		cp.add(textFieldOutput);
		
		setTitle("Swing Accumulator");
		setSize(350, 120);
		setVisible(true);
	}
	
	private class textFieldInputListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int numberInt = Integer.parseInt(textFieldInput.getText());
			sum += numberInt;
			textFieldInput.setText("");
			textFieldOutput.setText(sum + "");
		}
		
	}
	public static void main(String[] args) {
		new SwingAccumulator();
	}

}
