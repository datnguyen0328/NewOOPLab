package hust.soict.globalict.swing;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWTAccumulator extends Frame{
	private TextField textFieldInput;
	private TextField textFieldOutput;
	private int sum = 0;
	
	public AWTAccumulator() {
		setLayout(new GridLayout(2, 2));
		
		add(new Label("Enter an int: "));
		
		textFieldInput = new TextField(10);
		add(textFieldInput);
		textFieldInput.addActionListener(new textFieldInputListener());
		
		add(new Label("Accumulated sum"));
		
		textFieldOutput = new TextField(10);
		textFieldOutput.setEditable(false);
		add(textFieldOutput);
		
		setTitle("AWT Accumulator");
		setSize(350, 120);
		setVisible(true);
	}
	
	private class textFieldInputListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			sum += Integer.parseInt(textFieldInput.getText());
			
			textFieldInput.setText("");
			textFieldOutput.setText(sum + "");
		}
		
	}

	public static void main(String[] args) {
		new AWTAccumulator();
	}

}
