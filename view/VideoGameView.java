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
import java.util.HashMap;

@SuppressWarnings("serial")
public class VideoGameView extends javax.swing.JFrame {
	private JPanel pBar;
	private JButton bQuick;
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
	private JPanel pTool;
	private JButton bUpdate;
	private JButton bUpdateAll;
	private JButton bDelete;
	private JButton bPurchases;
	private JButton bNewPurchase;
	private JButton bRecent;
	private int cardSelected = 1;
	
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
								String[] genders = {"", "Male", "Female"};
								cbGender = new JComboBox<String>(genders);
								pCustomer.add(cbGender, gbc);
								
								gbc.gridy=3;
								tfAge = new JTextField();
								pCustomer.add(tfAge, gbc);
								
								gbc.gridy=4;
								tfBirthDate = new JTextField();
								pCustomer.add(tfBirthDate, gbc);
								
								gbc.gridy=5;
								String[] playLevels = {"", "Beginner", "Casual", "Medium", "Expert", "Hardcore" };
								cbPlayLevel = new JComboBox<String>(playLevels);
								pCustomer.add(cbPlayLevel, gbc);
							
					
							pGame = new JPanel();
							pGame.setLayout(new GridBagLayout());
							pSearch.add(pGame, BorderLayout.CENTER);
								
								String [] gameLabels = {"Title:", "ID #:", "Company:", "Console:", "Price:"};
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
								tfCompany = new JTextField();
								pGame.add(tfCompany, gbc);

								gbc.gridy = 3;
								String[] consoles = {"", "PC", "Xbox One", "PS4", "Wii U"};
								cbConsole = new JComboBox<String>(consoles);
								pGame.add(cbConsole, gbc);
								
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
							bSearch.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									bSearchActionPerformed(evt);
								}
							});
							
							bAddNew = new JButton("Add New");
							pButtons.add(bAddNew);
							bAddNew.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									bAddNewActionPerformed(evt);
								}
							});

					pBar = new JPanel();
					pBar.setBackground(Color.LIGHT_GRAY);
					pMain.add(pBar, BorderLayout.NORTH);

						jLabel1 = new JLabel();
						pBar.add(jLabel1);
						jLabel1.setText("(Quick Search) ID #:");
						
						jTextField1 = new JTextField();
						pBar.add(jTextField1);
						jTextField1.setPreferredSize(new java.awt.Dimension(140, 20));

						bQuick = new JButton();
						pBar.add(bQuick);
						bQuick.setText("Search");
						bQuick.setPreferredSize(new java.awt.Dimension(90, 20));
						bQuick.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								bQuickActionPerformed(evt);
							}
						});
						
					pTool = new JPanel();
					pTool.setBackground(Color.LIGHT_GRAY);
					pMain.add(pTool, BorderLayout.SOUTH);
						
						bUpdate = new JButton("Update");
						pTool.add(bUpdate);
						bUpdate.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								bUpdateActionPerformed(evt);
							}
						});
						
						bUpdateAll = new JButton("Update All");
						pTool.add(bUpdateAll);
						
						bDelete = new JButton("Delete");
						pTool.add(bDelete);
						bDelete.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								bDeleteActionPerformed(evt);
							}
						});
						
						bPurchases = new JButton("Purchases");
						pTool.add(bPurchases);
						
						bNewPurchase = new JButton("New Purchase");
						pTool.add(bNewPurchase);
						
						bRecent = new JButton("Recent...");
						pTool.add(bRecent);
						
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
	
	private void bQuickActionPerformed(ActionEvent evt) {
		String input = jTextField1.getText();
		if (!input.contains("-")) {
			//Send input to Customer Controller
				CustomerController controller = new CustomerController(new Customer(), this);
				controller.read(input);
		}
		else {
			//Send input to Game Controller
			GameController controller = new GameController(new Game(), this);
			controller.read(input);
		}
	}
	
	private void bSearchActionPerformed(ActionEvent evt) {
		if (cardSelected == 1) {
			CustomerController controller = new CustomerController(new Customer(), this);
			controller.read(getCustomerInfo());
		}
		else if (cardSelected == 2) {
			GameController controller = new GameController(new Game(), this);
			controller.read(getGameInfo());
		}	
	}
	
	private void bAddNewActionPerformed(ActionEvent evt) {
		if (cardSelected == 1) {
			CustomerController controller = new CustomerController(new Customer(), this);
			controller.create(getCustomerInfo());
		}
		else if (cardSelected == 2) {
			GameController controller = new GameController(new Game(), this);
			controller.create(getGameInfo());
		}	
	}
	
	private void bUpdateActionPerformed(ActionEvent evt) {
		if (cardSelected == 1) {
			CustomerController controller = new CustomerController(new Customer(), this);
			controller.update(getCustomerInfo());
		}
		else if (cardSelected == 2) {
			GameController controller = new GameController(new Game(), this);
			controller.update(getGameInfo());
		}	
	}
	
	private void bDeleteActionPerformed(ActionEvent evt) {
		if (cardSelected == 1) {
			CustomerController controller = new CustomerController(new Customer(), this);
			controller.destroy(getCustomerInfo());
		}
		else if (cardSelected == 2) {
			GameController controller = new GameController(new Game(), this);
			controller.destroy(getGameInfo());
		}	
	}
	
	private void changeForm(int index) {
		CardLayout cl = (CardLayout)(pCards.getLayout());
	   	if (index == 1) {
	   		cl.show(pCards, "Customer");
	   		cardSelected = 1;
		}
		else if (index == 2) {
			cl.show(pCards, "Game");
			cardSelected = 2;
		}
	}
	
	private HashMap<String, String> getCustomerInfo() {
		HashMap<String, String> args = new HashMap<String, String>();
		args.put("customerName", tfName.getText());
		args.put("id", tfCId.getText());
		args.put("gender", cbGender.getSelectedItem().toString());
		args.put("age", tfAge.getText());
		args.put("birthDate", tfBirthDate.getText());
		args.put("playLevel", cbPlayLevel.getSelectedItem().toString());
		return args;
	}
	
	private HashMap<String, String> getGameInfo() {
		HashMap<String, String> args = new HashMap<String, String>();
		args.put("title", tfTitle.getText());
		args.put("id", tfGId.getText());
		args.put("company", tfCompany.getText());
		args.put("console", cbConsole.getSelectedItem().toString());
		args.put("price", tfPrice.getText());
		return args;
	}
}