/**
 * HumblDump Express
 *
 * @package   HumblDump - Express
 * @author    Mahir Tekin Erdensan - humbldump@protonmail.com
 * @copyright Copyright (c) 2020
 * @link      http://github.com/humbldump
 * @version   1.0.1
 */
package main;
import javax.swing.JFrame;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MainScreen {

	private JFrame frmHumbldumpExpress;
	private JTextField txtShipmentId;
	public static DefaultListModel<Object> LastTable = new DefaultListModel<Object>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MainScreen window = new MainScreen();
		window.frmHumbldumpExpress.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public MainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHumbldumpExpress = new JFrame();
		frmHumbldumpExpress.getContentPane().setBackground(Color.WHITE);
		frmHumbldumpExpress.setResizable(false);
		frmHumbldumpExpress.setTitle("HumblDump Express | Main Screen");
		frmHumbldumpExpress.setBounds(100, 100, 920, 518);
		frmHumbldumpExpress.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHumbldumpExpress.getContentPane().setLayout(null);
		mainClass.GetLatestCargo();

		JList<Object> list = new JList<Object>(LastTable);
		// Son 20 listesini çaðýr
		UpdateList();

		JPanel LeftPanel = new JPanel();
		LeftPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		LeftPanel.setBackground(Color.WHITE);
		LeftPanel.setBounds(10, 11, 367, 467);
		frmHumbldumpExpress.getContentPane().add(LeftPanel);
		LeftPanel.setLayout(null);

		JButton Get_Shipmentbtn = new JButton("Get Shipment Info");
		Get_Shipmentbtn.setForeground(Color.DARK_GRAY);
		Get_Shipmentbtn.setFont(new Font("Arial", Font.BOLD, 16));
		Get_Shipmentbtn.setBounds(10, 107, 343, 60);
		LeftPanel.add(Get_Shipmentbtn);

		txtShipmentId = new JTextField();
		txtShipmentId.setBounds(10, 45, 347, 40);
		LeftPanel.add(txtShipmentId);
		txtShipmentId.setColumns(10);

		JLabel lblNewLabel = new JLabel("Enter Shipment ID:");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 19, 135, 14);
		LeftPanel.add(lblNewLabel);

		JButton Remove_Shipmentbtn = new JButton("Remove Selected Shipment");

		Remove_Shipmentbtn.setForeground(Color.DARK_GRAY);
		Remove_Shipmentbtn.setFont(new Font("Arial", Font.BOLD, 16));
		Remove_Shipmentbtn.setBounds(10, 251, 343, 60);
		LeftPanel.add(Remove_Shipmentbtn);

		JButton Reload_LastShipmentbtn = new JButton("Reload Last 20 Shipment");
		Reload_LastShipmentbtn.setForeground(Color.DARK_GRAY);
		Reload_LastShipmentbtn.setFont(new Font("Arial", Font.BOLD, 16));
		Reload_LastShipmentbtn.setBounds(10, 395, 347, 60);
		LeftPanel.add(Reload_LastShipmentbtn);

		JButton Create_Shipmentbtn = new JButton("Create New Shipment");
		Create_Shipmentbtn.setForeground(Color.DARK_GRAY);
		Create_Shipmentbtn.setFont(new Font("Arial", Font.BOLD, 16));
		Create_Shipmentbtn.setBounds(10, 323, 347, 60);
		LeftPanel.add(Create_Shipmentbtn);
		
		JButton Change_Shipmentbtn = new JButton("Change Shipment Info");
		Change_Shipmentbtn.setForeground(Color.DARK_GRAY);
		Change_Shipmentbtn.setFont(new Font("Arial", Font.BOLD, 16));
		Change_Shipmentbtn.setBounds(10, 179, 343, 60);
		LeftPanel.add(Change_Shipmentbtn);

		JPanel RightPanel = new JPanel();
		RightPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		RightPanel.setBackground(Color.WHITE);
		RightPanel.setBounds(387, 11, 449, 467);
		frmHumbldumpExpress.getContentPane().add(RightPanel);
		RightPanel.setLayout(null);

		JLabel lblLastShipment = new JLabel("Last 20 Shipment");
		lblLastShipment.setForeground(Color.DARK_GRAY);
		lblLastShipment.setFont(new Font("Arial", Font.BOLD, 18));
		lblLastShipment.setBounds(10, 11, 237, 14);
		RightPanel.add(lblLastShipment);

		list.setVisibleRowCount(50);
		list.setFont(new Font("Arial", Font.PLAIN, 16));
		list.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		list.setForeground(Color.BLACK);

		list.setBackground(Color.WHITE);
		list.setBounds(10, 35, 429, 421);
		RightPanel.add(list);

		/* Event Listener */
		// Kaldýr butonu dinleyicisi
		Remove_Shipmentbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String cargoId = txtShipmentId.getText();
				if (cargoId.length() == 0) {
					showMessageDialog(null, "You need to select or enter a Shipment id!");
					return;
				}
				int cid = Integer.parseInt(cargoId) - 20200190;

				int s = JOptionPane.showConfirmDialog(null,
						"Are you sure about deleting this Shipment? Cargo id: " + cargoId + " will be deleted",
						"Warning", JOptionPane.YES_NO_OPTION);
				if (s == JOptionPane.NO_OPTION)
					return;
				
				txtShipmentId.setText("");
				RemoveShipment(cid);
				
			}
		});
		
		//Deðiþtir butonu týklamasý
		Change_Shipmentbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String cargoId = txtShipmentId.getText();
				if (cargoId.length() == 0) {
					showMessageDialog(null, "You need to select or enter a Shipment id!");
					return;
				}
				int cid = Integer.parseInt(cargoId) - 20200190;
				int z = 0;
				for (int i = 0; i < mainClass.CargoList.length; i++) {
					if (mainClass.CargoList[i] == null)
						continue;

					if (mainClass.CargoList[i].id == cid) {
						changeShipment.main(null, mainClass.CargoList[i]);
						z++;
						break;
					}
				}
				
				if(z == 0) {
					CargoDATA s = mainClass.GeciciObj(cid);
					
					if(s != null) {
						changeShipment.main(null, s);
					}
					else {
						showMessageDialog(null, "Couldn't find this shipment on database!");
						return;
					}
				}
			}
		});

		// Yeni Kargo oluþtur butonu
		Create_Shipmentbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				createShipment s = new createShipment();
				if (createShipment.acikmi == false) {
					createShipment.main(null, frmHumbldumpExpress);
				} else {
					s.Create_Cargo.requestFocus();
				}
			}
		});

		// Liste seçimi deðiþimi dinleyicisi
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (list.getSelectedValue() != null)
					txtShipmentId.setText(list.getSelectedValue().toString());
			}
		});

		// Listeyi yenile butonu
		Reload_LastShipmentbtn.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				LastTable.removeAllElements();
				mainClass.GetLatestCargo();

				UpdateList();
			}
		});
		
		//Kargo bilgilerini getir
		Get_Shipmentbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String cargoId = txtShipmentId.getText();
				if (cargoId.length() == 0) {
					showMessageDialog(null, "You need to select or enter a Shipment id!");
					return;
				}
				int cid = Integer.parseInt(cargoId) - 20200190;
				int z = 0;
				for (int i = 0; i < mainClass.CargoList.length; i++) {
					if (mainClass.CargoList[i] == null)
						continue;

					if (mainClass.CargoList[i].id == cid) {
						getShipment.main(null, mainClass.CargoList[i]);
						z++;
						break;
					}
				}
				
				if(z == 0) {
					//Call yeni bilgileri,
					CargoDATA s = mainClass.GeciciObj(cid);
					
					if(s != null) {
						getShipment.main(null, s);
					}
					else {
						showMessageDialog(null, "Couldn't find this shipment on database!");
						return;
					}
					
				}
			}
		});
	}
	
	//Listeyi güncelle
	public static void UpdateList() {
		LastTable.clear();
		LastTable.removeAllElements();
		for (int i = mainClass.CargoList.length - 1; i >= 0; i--) {
			if (mainClass.CargoList[i] == null)
				continue;
			LastTable.addElement(20200190 + mainClass.CargoList[i].id);
		}

	}
	
	public static void RemoveShipment(int cid) {
		int z = -1;
		String bs = new ApiRequest("RemoveCargo", String.valueOf(cid)).GET();
		JsonObject obj = JsonParser.parseString(bs).getAsJsonObject();

		if (obj.get("durum").getAsString() == "false") {
			showMessageDialog(null, obj.get("body").getAsString());
			throw new RuntimeException(obj.get("body").getAsString());
		}
		;

		showMessageDialog(null, obj.get("body").getAsString());

		// Kayýtlý carho listesinde id yi ara
		for (int i = 0; i < mainClass.CargoList.length; i++) {
			if (mainClass.CargoList[i] == null)
				continue;

			if (mainClass.CargoList[i].id == cid) {
				z = i;
				break;
			}
		}

		if (z != -1) {
			mainClass.CargoList[z] = null;
			UpdateList();
		}
	}
}
