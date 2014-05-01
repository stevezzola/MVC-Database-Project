package view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import model.Customer;
import model.Game;
import controller.CustomerController;
import controller.GameController;

public class VideoGameView extends javax.swing.JFrame {
	private JLabel label1;
	public JTextArea textArea1;
	private JButton button1;
	private JTextField textField1;

	public VideoGameView() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			getContentPane().setBackground(Color.LIGHT_GRAY);
			
			label1 = new JLabel();
			getContentPane().add(label1);
			label1.setText("Enter ID number of customer or game:");
			label1.setBounds(31, 20, 225, 15);
			
			textField1 = new JTextField();
			getContentPane().add(textField1);
			textField1.setBounds(27, 47, 120, 25);
			
			button1 = new JButton();
			getContentPane().add(button1);
			button1.setText("Search");
			button1.setBounds(159, 47, 83, 25);
			{
				textArea1 = new JTextArea();
				textArea1.setBackground(Color.LIGHT_GRAY);
				getContentPane().add(textArea1);
				textArea1.setBounds(21, 84, 225, 148);
			}
			button1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					button1ActionPerformed(evt);
				}
			});

			pack();
			setVisible(true);
			setResizable(false);
			this.setSize(272, 316);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void button1ActionPerformed(ActionEvent evt) {
		String input = textField1.getText();
		if (!input.contains("-")) {
			//Send input to Customer Controller
				CustomerController controller;
				try {
					controller = new CustomerController(new Customer(), this);
					controller.read(input);
				} catch (SQLException e) {}
				
		}
		else {
			try {
				GameController controller = new GameController(new Game(), this);
				controller.read(input);
			} catch (SQLException e) {}
		}
	}

}
