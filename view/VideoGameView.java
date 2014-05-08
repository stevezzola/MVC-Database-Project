package view;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
@SuppressWarnings("serial")
public class VideoGameView extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JButton jButton1;
	private JRadioButton jRadioButton2;
	private JRadioButton jRadioButton1;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JTextField jTextField7;
	private JLabel jLabel8;
	private JTextField jTextField6;
	private JPanel jPanel6;
	private JComboBox<String> jComboBox1;
	private JComboBox<String> jComboBox2;
	private JComboBox<String> jComboBox3;
	private JLabel jLabel9;
	private JLabel jLabel7;
	private JTextField jTextField5;
	private JLabel jLabel6;
	private JTextField jTextField4;
	private JTextField jTextField3;
	private JPanel jPanel5;
	private ButtonGroup buttonGroup1;
	public JTextArea jTextArea1;
	private JTextField jTextField2;
	private JLabel jLabel2;
	private JTextField jTextField1;
	private JLabel jLabel1;
	private JPanel jPanel2;
	private JPanel jPanel3;
	private JPanel jPanel4;
	private ActionListener radioListener1;
	private ActionListener radioListener2;
	private JLabel jLabela;
	private JLabel jLabelb;
	private JLabel jLabelc;
	private JLabel jLabeld;
	private JLabel jLabele;
	private JTextField jTextFielda;
	private JTextField jTextFieldb;
	private JTextField jTextFielde;
	private JTextField jTextFieldd;
	private JPanel cards;
	
	public VideoGameView() { 
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);

				jPanel2 = new JPanel();
				BorderLayout jPanel2Layout = new BorderLayout();
				jPanel2.setLayout(jPanel2Layout);
				getContentPane().add(jPanel2, BorderLayout.CENTER);
				
					jPanel3 = new JPanel();
					getContentPane().add(jPanel3, BorderLayout.WEST);
					jPanel3.setLayout(new BorderLayout());
					jPanel3.setBackground(Color.LIGHT_GRAY);
					jPanel3.setPreferredSize(new java.awt.Dimension(180, 330));
					
						jPanel4 = new JPanel();
						jPanel3.add(jPanel4, BorderLayout.NORTH);
						jPanel4.setPreferredSize(new java.awt.Dimension(180, 56));
						
							jPanel5 = new JPanel();
							//jPanel3.add(jPanel5, BorderLayout.CENTER);
							{
								jLabel4 = new JLabel();
								jPanel5.add(jLabel4);
								jLabel4.setText("Name:");
							}
							{
								jTextField3 = new JTextField();
								jPanel5.add(jTextField3);
								jTextField3.setPreferredSize(new java.awt.Dimension(119, 23));
							}
							{
								jLabel5 = new JLabel();
								jPanel5.add(jLabel5);
								jLabel5.setText("ID #");
							}
							{
								jTextField4 = new JTextField();
								jPanel5.add(jTextField4);
								jTextField4.setPreferredSize(new java.awt.Dimension(117, 23));
							}
							{
								jLabel6 = new JLabel();
								jPanel5.add(jLabel6);
								jLabel6.setText("Gender: ");
							}
							{
								String[] genders = { "Male", "Female"};
								jComboBox1 = new JComboBox<String>(genders);
								jPanel5.add(jComboBox1);
								jComboBox1.setPreferredSize(new java.awt.Dimension(77, 23));
							}
							{
								jLabel7 = new JLabel();
								jPanel5.add(jLabel7);
								jLabel7.setText("Age:");
								jLabel7.setPreferredSize(new java.awt.Dimension(48, 16));
							}
							{
								jTextField6 = new JTextField();
								jPanel5.add(jTextField6);
								jTextField6.setPreferredSize(new java.awt.Dimension(117, 23));
							}
							{
								jLabel8 = new JLabel();
								jPanel5.add(jLabel8);
								jLabel8.setText("Birth Date:");
							}
							{
								jTextField7 = new JTextField();
								jPanel5.add(jTextField7);
								jTextField7.setPreferredSize(new java.awt.Dimension(89, 23));
							}
							{
								jLabel9 = new JLabel();
								jPanel5.add(jLabel9);
								jLabel9.setText("Play Level:");
							}
							{
								String[] playLevels = { "Beginner", "Casual", "Intermediate", "Advanced", "Hardcore" };
								jComboBox2 = new JComboBox<String>(playLevels);
								jPanel5.add(jComboBox2);
							}
					
							jPanel6 = new JPanel();
							//jPanel3.add(jPanel6, BorderLayout.CENTER);
							{
								jLabela = new JLabel();
								jPanel6.add(jLabela);
								jLabela.setText("Title:");
							}
							{
								jTextFielda = new JTextField();
								jPanel6.add(jTextFielda);
								jTextFielda.setPreferredSize(new java.awt.Dimension(119, 23));
							}
							{
								jLabelb = new JLabel();
								jPanel6.add(jLabelb);
								jLabelb.setText("ID #");
							}
							{
								jTextFieldb = new JTextField();
								jPanel6.add(jTextFieldb);
								jTextFieldb.setPreferredSize(new java.awt.Dimension(117, 23));
							}
							{
								jLabelc = new JLabel();
								jPanel6.add(jLabelc);
								jLabelc.setText("Console: ");
							}
							{
								String[] consoles = {"PC", "Xbox One", "PS4", "Wii U"};
								jComboBox3 = new JComboBox<String>(consoles);
								jPanel6.add(jComboBox3);
							}
							{
								jLabeld = new JLabel();
								jPanel6.add(jLabeld);
								jLabeld.setText("Company:");
							}
							{
								jTextFieldd = new JTextField();
								jPanel6.add(jTextFieldd);
								jTextFieldd.setPreferredSize(new java.awt.Dimension(87, 23));
							}
							{
								jLabele = new JLabel();
								jPanel6.add(jLabele);
								jLabele.setText("Price:");
							}
							{
								jTextFielde = new JTextField();
								jPanel6.add(jTextFielde);
								jTextFielde.setPreferredSize(new java.awt.Dimension(117, 23));
							}
							
							cards = new JPanel(new CardLayout());
							cards.add(jPanel5, "Customer");
							cards.add(jPanel6, "Game");
							jPanel3.add(cards, BorderLayout.CENTER);

							jLabel3 = new JLabel();
							jPanel4.add(jLabel3);
							jLabel3.setText("===== Add new: =====");
							
							jRadioButton1 = new JRadioButton();
							jPanel4.add(jRadioButton1);
							jRadioButton1.setText("Customer");
							jRadioButton1.setSelected(true);
							
							jRadioButton2 = new JRadioButton();
							jPanel4.add(jRadioButton2);
							jRadioButton2.setText("Game");
							

							buttonGroup1 = new ButtonGroup();
							buttonGroup1.add(jRadioButton1);
							buttonGroup1.add(jRadioButton2);
							
							radioListener1 = new ActionListener() {
								public void actionPerformed(ActionEvent evt1) {
									changeForm(1);
								}
							};
							
							radioListener2 = new ActionListener() {
								public void actionPerformed(ActionEvent evt1) {
									changeForm(2);
								}
							};
							
							jRadioButton1.addActionListener(radioListener1);
							jRadioButton2.addActionListener(radioListener2);
				
					jTextArea1 = new JTextArea();
					jTextArea1.setBackground(Color.WHITE);
					jPanel2.add(jTextArea1, BorderLayout.CENTER);

					jPanel1 = new JPanel();
					jPanel1.setBackground(Color.GRAY);
					jPanel2.add(jPanel1, BorderLayout.NORTH);
						
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
				controller = new CustomerController(new Customer(), this);
				controller.read(input);
		}
		else {
			input = jTextField2.getText();
			GameController controller = new GameController(new Game(), this);
			controller.read(input);
		}
	}
	
	private void changeForm(int index) {
		CardLayout cl = (CardLayout)(cards.getLayout());
	   	if (index == 1) {
	   		cl.show(cards, "Customer");
		}
		else if (index == 2) {
			cl.show(cards, "Game");
		}
	}
}
