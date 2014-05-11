package view;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

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
	private JPanel pBar;
	private JButton jButton1;
	private JRadioButton rbGame;
	private JRadioButton rbCustomer;
	private JTextField tfBirthDate;
	private JTextField tfAge;
	private JPanel pGame;
	private JComboBox<String> cbGender;
	private JComboBox<String> cbPlayLevel;
	private JComboBox<String> cbConsole;
	private JTextField tfCId;
	private JTextField tfName;
	private JPanel pCustomer;
	private ButtonGroup buttonGroup1;
	public JTextArea jTextArea1;
	private JTextField jTextField2;
	private JLabel jLabel2;
	private JTextField jTextField1;
	private JLabel jLabel1;
	private JPanel pMain;
	private JPanel pSearch;
	private JPanel pRadio;
	private ActionListener radioListener1;
	private ActionListener radioListener2;
	private JTextField tfTitle;
	private JTextField tfGId;
	private JTextField tfPrice;
	private JTextField tfCompany;
	private JPanel pCards;
	private JPanel pButtons;
	private JButton bSearch;
	private JButton bAddNew;
	private JTable table;
	
	public VideoGameView() { 
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);

				pMain = new JPanel();
				BorderLayout pMainLayout = new BorderLayout();
				pMain.setLayout(pMainLayout);
				getContentPane().add(pMain, BorderLayout.CENTER);
				
					pSearch = new JPanel();
					getContentPane().add(pSearch, BorderLayout.WEST);
					pSearch.setLayout(new BorderLayout());
					pSearch.setPreferredSize(new java.awt.Dimension(180, 330));
					
						pRadio = new JPanel();
						pSearch.add(pRadio, BorderLayout.NORTH);

							pCustomer = new JPanel();
							pCustomer.setLayout(new GridBagLayout());
							pSearch.add(pCustomer, BorderLayout.CENTER);
							
								String [] customerLabels = {"Name:", "ID #:", "Gender:", "Age:", "Birth Date:", "Play Level:"};
								GridBagConstraints gbc = new GridBagConstraints();
								gbc.fill = (GridBagConstraints.HORIZONTAL);
								gbc.insets = new Insets(5, 5, 10, 5);
								gbc.gridx = 0;
								for (int i = 0; i < 6; i++) {
									JLabel label = new JLabel(customerLabels[i]);
									gbc.gridy = i;
									pCustomer.add(label, gbc);
								}
							
								gbc.gridx=1;
								gbc.gridy=0;
								tfName = new JTextField();
								pCustomer.add(tfName, gbc);						
		
								gbc.gridy=1;
								tfCId = new JTextField();
								pCustomer.add(tfCId, gbc);
								
								gbc.gridy=2;
								String[] genders = {"Select...", "Male", "Female"};
								cbGender = new JComboBox<String>(genders);
								pCustomer.add(cbGender, gbc);
								
								gbc.gridy=3;
								tfAge = new JTextField();
								pCustomer.add(tfAge, gbc);
								
								gbc.gridy=4;
								tfBirthDate = new JTextField();
								pCustomer.add(tfBirthDate, gbc);
								
								gbc.gridy=5;
								String[] playLevels = {"Select...", "Beginner", "Casual", "Medium", "Expert", "Hardcore" };
								cbPlayLevel = new JComboBox<String>(playLevels);
								pCustomer.add(cbPlayLevel, gbc);
							
					
							pGame = new JPanel();
							pGame.setLayout(new GridBagLayout());
							pSearch.add(pGame, BorderLayout.CENTER);
								
								String [] gameLabels = {"Title:", "ID #:", "Console:", "Company:", "Price:"};
								gbc.gridx = 0;
								for (int i = 0; i < 5; i++) {
									JLabel label = new JLabel(gameLabels[i]);
									gbc.gridy = i;
									pGame.add(label, gbc);
								}
								gbc.gridx = 1;
								gbc.gridy = 0;
								tfTitle = new JTextField();
								pGame.add(tfTitle, gbc);
							
								gbc.gridy = 1;
								tfGId = new JTextField();
								pGame.add(tfGId, gbc);
								
								gbc.gridy = 2;
								String[] consoles = {"Select...", "PC", "Xbox One", "PS4", "Wii U"};
								cbConsole = new JComboBox<String>(consoles);
								pGame.add(cbConsole, gbc);
							
								gbc.gridy = 3;
								tfCompany = new JTextField();
								pGame.add(tfCompany, gbc);

								gbc.gridy = 4;
								tfPrice = new JTextField();
								pGame.add(tfPrice, gbc);
							
							pCards = new JPanel(new CardLayout());
							pCards.add(pCustomer, "Customer");
							pCards.add(pGame, "Game");
							pSearch.add(pCards, BorderLayout.CENTER);
							
							rbCustomer = new JRadioButton();
							pRadio.add(rbCustomer);
							rbCustomer.setText("Customer");
							rbCustomer.setSelected(true);
							
							rbGame = new JRadioButton();
							pRadio.add(rbGame);
							rbGame.setText("Game");
							
							buttonGroup1 = new ButtonGroup();
							buttonGroup1.add(rbCustomer);
							buttonGroup1.add(rbGame);
							
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
							
							rbCustomer.addActionListener(radioListener1);
							rbGame.addActionListener(radioListener2);
							
						pButtons = new JPanel();
						pSearch.add(pButtons, BorderLayout.SOUTH);
							
							bSearch = new JButton("Search");
							pButtons.add(bSearch);
							
							bAddNew = new JButton("Add New");
							pButtons.add(bAddNew);

					pBar = new JPanel();
					pBar.setBackground(Color.LIGHT_GRAY);
					pMain.add(pBar, BorderLayout.NORTH);

						jLabel1 = new JLabel();
						pBar.add(jLabel1);
						jLabel1.setText("Customer ID:");
						
						jTextField1 = new JTextField();
						pBar.add(jTextField1);
						jTextField1.setPreferredSize(new java.awt.Dimension(140, 20));

						jLabel2 = new JLabel();
						pBar.add(jLabel2);
						jLabel2.setText("Game ID:");

						jTextField2 = new JTextField();
						pBar.add(jTextField2);
						jTextField2.setPreferredSize(new java.awt.Dimension(140, 20));

						jButton1 = new JButton();
						pBar.add(jButton1);
						jButton1.setText("Search");
						jButton1.setPreferredSize(new java.awt.Dimension(90, 20));
						jButton1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jButton1ActionPerformed(evt);
							}
						});
						
					int numRows = 30;
					String[] colHeadings1 = {"COLUMN1","COLUMN2", "COLUMN3","COLUMN4", "COLUMN5","COLUMN6"};
					DefaultTableModel model = new DefaultTableModel(numRows, colHeadings1.length) ;
					model.setColumnIdentifiers(colHeadings1);
					table = new JTable(model);
						
					JScrollPane scroll1 = new JScrollPane(table);
					pMain.add(scroll1, BorderLayout.CENTER);

				pack();
				this.setSize(800, 380);
				this.setResizable(false);
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
			//Send input to Game Controller
			input = jTextField2.getText();
			GameController controller = new GameController(new Game(), this);
			controller.read(input);
		}
	}
	
	private void changeForm(int index) {
		CardLayout cl = (CardLayout)(pCards.getLayout());
	   	if (index == 1) {
	   		cl.show(pCards, "Customer");
		}
		else if (index == 2) {
			cl.show(pCards, "Game");
		}
	}
}
