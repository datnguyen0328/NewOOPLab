package hust.soict.globalict.swing;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicButtonListener;

public class NumberGrid extends JFrame{
	private JButton[] buttonNums = new JButton[10];
	private JButton btnDelete, btnReset;
	private JTextField textfieldDisplay;
	
	public NumberGrid() {
		textfieldDisplay = new JTextField();
		textfieldDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		JPanel panelButtons = new JPanel(new GridLayout(4, 3));
		addButtons(panelButtons);
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(textfieldDisplay, BorderLayout.NORTH);
		cp.add(panelButtons, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Number grid");
		setSize(200, 200);
		setVisible(true);
		
	}
	
	void addButtons(JPanel panelButtons) {
		ButtonListener btnListener = new ButtonListener();
		for (int i=0; i<=9; i++) {
			buttonNums[i] = new JButton("" + i);
			panelButtons.add(buttonNums[i]);
			buttonNums[i].addActionListener(btnListener);
		}
		
		btnDelete = new JButton("del");
		panelButtons.add(btnDelete);
		btnDelete.addActionListener(btnListener);
		
		btnReset = new JButton("c");
		panelButtons.add(btnReset);
		btnReset.addActionListener(btnListener);
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand();
			if (button.charAt(0) >= '0' && button.charAt(0) <= '9') {
				textfieldDisplay.setText(textfieldDisplay.getText() + button);
			}
			else if (button.equals("del")) {
				if (!textfieldDisplay.getText().isEmpty()) {
					textfieldDisplay.setText(textfieldDisplay.getText().substring(0, textfieldDisplay.getText().length() - 1));
				}			
			}
			else {
				textfieldDisplay.setText("");
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		new NumberGrid();
	}
}
