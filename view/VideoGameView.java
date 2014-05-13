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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import model.Customer;
import model.Game;
import model.Purchase;
import controller.CustomerController;
import controller.GameController;
import controller.PurchaseController;

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
	private JButton bClear;
	public JTable table;
	private JPanel pTool;
	private JButton bUpdate;
	private JButton bUpdateAll;
	private JButton bDelete;
	private JButton bPurchases;
	private JButton bNewPurchase;
	private JButton bAllPurchases;
	private int cardSelected = 1;
	public String[] customerColumns = {"Name","Id #", "Gender","Age", "Birth Date","Play Level"};
	public String[] gameColumns = {"Title","Id #", "Company","Console", "Price"};
	public String[] purchaseColumns = {"Customer Id","Game Id", "Purchase Date","Personal Rating"};
	
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
					pSearch.setPreferredSize(new java.awt.Dimension(210, 330));
					
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
						Insets buttonInsets = new Insets (5, 5, 5, 5);
							
							bSearch = new JButton("Search");
							bSearch.setMargin(buttonInsets);
							pButtons.add(bSearch);
							bSearch.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									bSearchActionPerformed(evt);
								}
							});
							
							bAddNew = new JButton("Add New");
							bAddNew.setMargin(buttonInsets);
							pButtons.add(bAddNew);
							bAddNew.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									bAddNewActionPerformed(evt);
								}
							});
							
							bClear = new JButton("Clear");
							bClear.setMargin(buttonInsets);
							pButtons.add(bClear);
							bClear.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									bClearActionPerformed(evt);
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
								updateFromTable(table.getSelectedRow());
							}
						});
						
						bUpdateAll = new JButton("Update All");
						pTool.add(bUpdateAll);
						bUpdateAll.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								for (int i = 0; i < table.getRowCount(); i++) {
									updateFromTable(i);
								}
							}
						});
						
						bDelete = new JButton("Delete");
						pTool.add(bDelete);
						bDelete.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								deleteFromTable(table.getSelectedRow());
							}
						});
						
						bPurchases = new JButton("Purchases");
						pTool.add(bPurchases);
						bPurchases.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								displayPurchases();
							}
						});
						
						bNewPurchase = new JButton("New Purchase");
						pTool.add(bNewPurchase);
						bNewPurchase.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								newPurchase();
							}
						});
						
						bAllPurchases = new JButton("All Purchases");
						pTool.add(bAllPurchases);
						bAllPurchases.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								allPurchases();
							}
						});
						
					int numRows = 0;
					DefaultTableModel tableModel = new DefaultTableModel(numRows, customerColumns.length) ;
					tableModel.setColumnIdentifiers(customerColumns);
					table = new JTable(tableModel);
					ListSelectionModel listModel = table.getSelectionModel();
					listModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						
					JScrollPane scroll1 = new JScrollPane(table);
					pMain.add(scroll1, BorderLayout.CENTER);

				pack();
				this.setSize(840, 380);
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
	
	private void bClearActionPerformed(ActionEvent evt) {
		if (cardSelected == 1) {
			tfName.setText("");
			tfCId.setText("");
			cbGender.setSelectedIndex(0);
			tfAge.setText("");
			tfBirthDate.setText("");
			cbPlayLevel.setSelectedIndex(0);
		}
		else if (cardSelected == 2) {
			tfTitle.setText("");
			tfGId.setText("");
			tfCompany.setText("");
			cbConsole.setSelectedIndex(0);
			tfPrice.setText("");
		}	
	}

	public String getCellValue() {;
		int selectedRow = table.getSelectedRow();
        int selectedColumn = table.getSelectedColumn();
        return (String) (table.getValueAt(selectedRow, selectedColumn));
	}
	
	public String getCellValue(int row, int column) {;
		return (String) (table.getValueAt(row, column));
	}
	public void updateFromTable(int selectedRow) {
		try {
			HashMap<String, String> args = new HashMap<String, String>();
			if (table.getColumnCount() == 6) {
				args.put("customerName", (String) table.getValueAt(selectedRow, 0));
				args.put("id", (String) table.getValueAt(selectedRow, 1));
				args.put("gender", (String) table.getValueAt(selectedRow, 2));
				args.put("age", (String) table.getValueAt(selectedRow, 3));
				args.put("birthDate", (String) table.getValueAt(selectedRow, 4));
				args.put("playLevel", (String) table.getValueAt(selectedRow, 5));
				CustomerController controller = new CustomerController(new Customer(), this);
				controller.update(args);
			}
			else if (table.getColumnCount() == 5) {
				args.put("title", (String) table.getValueAt(selectedRow, 0));
				args.put("id", (String) table.getValueAt(selectedRow, 1));
				args.put("company", (String) table.getValueAt(selectedRow, 2));
				args.put("console", (String) table.getValueAt(selectedRow, 3));
				args.put("price", (String) table.getValueAt(selectedRow, 4));
				GameController controller = new GameController(new Game(), this);
				controller.update(args);
			}	
			else if (table.getColumnCount() == 4) {
				args.put("customerId", (String) table.getValueAt(selectedRow, 0));
				args.put("gameId", (String) table.getValueAt(selectedRow, 1));
				args.put("purchaseDate", (String) table.getValueAt(selectedRow, 2));
				args.put("rating", (String) table.getValueAt(selectedRow, 3));
				PurchaseController controller = new PurchaseController(new Purchase(), this);
				controller.update(args);
			}
		} catch (Exception e) {}
	}
	
	public void deleteFromTable(int selectedRow) {
		try {
			HashMap<String, String> args = new HashMap<String, String>();
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			if (table.getColumnCount() == 6) {
				args.put("customerId", (String) table.getValueAt(selectedRow, 1));
				PurchaseController controllerp = new PurchaseController(new Purchase(), this);
				controllerp.destroy(args);
				args.clear();
				args.put("id", (String) table.getValueAt(selectedRow, 1));
				CustomerController controller = new CustomerController(new Customer(), this);
				controller.destroy(args);
			}
			else if (table.getColumnCount() == 5) {
				args.put("gameId", (String) table.getValueAt(selectedRow, 1));
				PurchaseController controllerp = new PurchaseController(new Purchase(), this);
				controllerp.destroy(args);
				args.clear();
				args.put("id", (String) table.getValueAt(selectedRow, 1));
				GameController controller = new GameController(new Game(), this);
				controller.destroy(args);
			}
			else if (table.getColumnCount() == 4) {
				args.put("customerId", (String) table.getValueAt(selectedRow, 0));
				args.put("gameId", (String) table.getValueAt(selectedRow, 1));
				PurchaseController controller = new PurchaseController(new Purchase(), this);
				controller.destroy(args);
			}
			tableModel.removeRow(table.getSelectedRow());
		} catch (Exception e) {}
	}
	
	private void displayPurchases() {
		try {
			String id = getCellValue(table.getSelectedRow(), 1);
			PurchaseController controller = new PurchaseController(new Purchase(), this);
			HashMap<String, String> args = new HashMap<String, String>();
			String key = null;
			if (table.getColumnCount() == 6) {
				key = "customerId";
				args.put("gameId", "");
			}
			else if (table.getColumnCount() == 5){
				key = "gameId";
				args.put("customerId", "");
			}
			args.put(key, id);
			controller.read(args);
		} catch (Exception e) {}
	}
	
	private void newPurchase() {
		JTextField tfCustomerId = new JTextField();
		JTextField tfGameId = new JTextField();
		JTextField tfPurchaseDate = new JTextField();
		Object[] message = {"Customer Id:", tfCustomerId, 
				"Game Id:", tfGameId, "Purchase Date:", tfPurchaseDate};
		int button = JOptionPane.showConfirmDialog(this, message, 
				"New Purchase", JOptionPane.OK_CANCEL_OPTION);
		if (button == 0) {
			HashMap<String, String> args = new HashMap<String, String>();
			args.put("customerId", tfCustomerId.getText());
			args.put("gameId", tfGameId.getText());
			args.put("purchaseDate", tfPurchaseDate.getText());
			args.put("rating", "0.0");
			PurchaseController controller = new PurchaseController(new Purchase(), this);
			controller.create(args);
		}
	}
	
	private void allPurchases() {
		PurchaseController controller = new PurchaseController(new Purchase(), this);
		HashMap<String, String> args = new HashMap<String, String>();
		args.put("customerId", "");
		args.put("gameId", "");
		controller.read(args);
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