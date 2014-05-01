package view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import model.Customer;
import model.Game;
import controller.CustomerController;
import controller.GameController;
import java.awt.BorderLayout;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class VideoGameView extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JButton jButton1;
	public JTextArea jTextArea1;
	private JTextField jTextField2;
	private JLabel jLabel2;
	private JTextField jTextField1;
	private JLabel jLabel1;
	private JPanel jPanel2;
	private JPanel jPanel3;
	
	public VideoGameView() { 
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);

				jPanel1 = new JPanel();
				jPanel1.setBackground(Color.LIGHT_GRAY);
				getContentPane().add(jPanel1, BorderLayout.NORTH);
					
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("Customer ID:");
					
					jTextField1 = new JTextField();
					jPanel1.add(jTextField1);
					jTextField1.setPreferredSize(new java.awt.Dimension(140, 20));

					jLabel2 = new JLabel();
					jPanel1.add(jLabel2);
					jLabel2.setText("Game ID:");

					jTextField2 = new JTextField();
					jPanel1.add(jTextField2);
					jTextField2.setPreferredSize(new java.awt.Dimension(140, 20));

					jButton1 = new JButton();
					jPanel1.add(jButton1);
					jButton1.setText("Search");
					jButton1.setPreferredSize(new java.awt.Dimension(90, 20));
					jButton1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButton1ActionPerformed(evt);
						}
					});

				jPanel2 = new JPanel();
				BorderLayout jPanel2Layout = new BorderLayout();
				jPanel2.setLayout(jPanel2Layout);
				getContentPane().add(jPanel2, BorderLayout.CENTER);

					jTextArea1 = new JTextArea();
					jTextArea1.setBackground(Color.LIGHT_GRAY);
					jPanel2.add(jTextArea1, BorderLayout.CENTER);

				jPanel3 = new JPanel();
				jPanel3.setBackground(Color.LIGHT_GRAY);
				getContentPane().add(jPanel3, BorderLayout.WEST);
				jPanel3.setPreferredSize(new java.awt.Dimension(180, 330));

				pack();
				this.setSize(800, 400);
				setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				setVisible(true);

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void jButton1ActionPerformed(ActionEvent evt) {
		String input = jTextField1.getText();
		if (!input.equals("")) {
			//Send input to Customer Controller
				CustomerController controller;
				try {
					controller = new CustomerController(new Customer(), this);
					controller.read(input);
				} catch (SQLException e) {}
				
		}
		else {
			input = jTextField2.getText();
			//Send input to Game Controller
			try {
				GameController controller = new GameController(new Game(), this);
				controller.read(input);
			} catch (SQLException e) {}
		}
	}
}
