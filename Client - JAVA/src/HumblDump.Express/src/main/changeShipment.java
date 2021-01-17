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

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class changeShipment {

	private JFrame Change_Cargo;
	private JTextField Sender_Input;
	private JTextField Receiver_Input;
	private JTextField From_Input;
	private JTextField To_Input;
	private JTextField Weight_Input;
	private JTextField Date_Input;
	private JComboBox <String> Type_Combo;
	private CargoDATA s;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,CargoDATA shipm) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					changeShipment window = new changeShipment(shipm);
					window.Change_Cargo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public changeShipment(CargoDATA shipm) {
		this.s = shipm;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Font f1 = new Font("Segoe UI Semilight", Font.PLAIN, 16);
		Font f2 = new Font("Segoe UI Semibold", Font.PLAIN, 16);
		
		Change_Cargo = new JFrame();
		Change_Cargo.getContentPane().setForeground(SystemColor.menu);
		Change_Cargo.setType(Type.UTILITY);
		Change_Cargo.getContentPane().setBackground(SystemColor.menu);
		Change_Cargo.getContentPane().setLayout(null);
		Change_Cargo.setTitle("HumblDump Express | Update Shipment number"+ (s.id+20200190));
		Change_Cargo.setResizable(false);
		Change_Cargo.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		Change_Cargo.setBounds(1005, 100, 560, 400);
		Change_Cargo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel Sender_Panel = new JPanel();
		Sender_Panel.setBounds(10, 11, 252, 60);
		Change_Cargo.getContentPane().add(Sender_Panel);
		Sender_Panel.setLayout(null);
		
		JLabel Sender_Label = new JLabel("Sender Name:");
		Sender_Label.setForeground(Color.DARK_GRAY);
		Sender_Label.setFont(f1);
		Sender_Label.setBounds(0, 0, 252, 31);
		Sender_Panel.add(Sender_Label);
		
		Sender_Input = new JTextField();
		Sender_Input.setToolTipText("Sender Name");
		Sender_Input.setForeground(Color.BLACK);
		Sender_Input.setFont(f2);
		Sender_Input.setBounds(0, 29, 252, 31);
		Sender_Panel.add(Sender_Input);
		Sender_Input.setColumns(10);
		
		JPanel Receiver_Panel = new JPanel();
		Receiver_Panel.setLayout(null);
		Receiver_Panel.setBounds(284, 11, 252, 60);
		Change_Cargo.getContentPane().add(Receiver_Panel);
		
		JLabel Receiver_Label = new JLabel("Receiver Name:");
		Receiver_Label.setForeground(Color.DARK_GRAY);
		Receiver_Label.setFont(f1);
		Receiver_Label.setBounds(0, 0, 252, 31);
		Receiver_Panel.add(Receiver_Label);
		
		Receiver_Input = new JTextField();
		Receiver_Input.setToolTipText("Receiver Name");
		Receiver_Input.setForeground(Color.BLACK);
		Receiver_Input.setFont(f2);
		Receiver_Input.setColumns(10);
		Receiver_Input.setBounds(0, 29, 252, 31);
		Receiver_Panel.add(Receiver_Input);
		
		JPanel From_Panel = new JPanel();
		From_Panel.setLayout(null);
		From_Panel.setBounds(10, 82, 252, 60);
		Change_Cargo.getContentPane().add(From_Panel);
		
		JLabel From_Label = new JLabel("Sender province:");
		From_Label.setForeground(Color.DARK_GRAY);
		From_Label.setFont(f1);
		From_Label.setBounds(0, 0, 252, 31);
		From_Panel.add(From_Label);
		
		From_Input = new JTextField();
		From_Input.setToolTipText("Sender Province");
		From_Input.setForeground(Color.BLACK);
		From_Input.setFont(f2);
		From_Input.setColumns(10);
		From_Input.setBounds(0, 29, 252, 31);
		From_Panel.add(From_Input);
		
		JPanel To_Panel = new JPanel();
		To_Panel.setLayout(null);
		To_Panel.setBounds(284, 82, 252, 60);
		Change_Cargo.getContentPane().add(To_Panel);
		
		JLabel To_Label = new JLabel("Receiver province:");
		To_Label.setForeground(Color.DARK_GRAY);
		To_Label.setFont(f1);
		To_Label.setBounds(0, 0, 252, 31);
		To_Panel.add(To_Label);
		
		To_Input = new JTextField();
		To_Input.setToolTipText("Receiver Province");
		To_Input.setForeground(Color.BLACK);
		To_Input.setFont(f2);
		To_Input.setColumns(10);
		To_Input.setBounds(0, 29, 252, 31);
		To_Panel.add(To_Input);
		
		JPanel Weight_Panel = new JPanel();
		Weight_Panel.setLayout(null);
		Weight_Panel.setBounds(10, 153, 252, 60);
		Change_Cargo.getContentPane().add(Weight_Panel);
		
		JLabel Weight_Label = new JLabel("Cargo Weight:");
		Weight_Label.setForeground(Color.DARK_GRAY);
		Weight_Label.setFont(f1);
		Weight_Label.setBounds(0, 0, 252, 31);
		Weight_Panel.add(Weight_Label);
		
		Weight_Input = new JTextField();
		Weight_Input.setToolTipText("Cargo Weight");
		Weight_Input.setForeground(Color.BLACK);
		Weight_Input.setFont(f2);
		Weight_Input.setColumns(10);
		Weight_Input.setBounds(0, 29, 252, 31);
		Weight_Panel.add(Weight_Input);
		
		JPanel Date_Panel = new JPanel();
		Date_Panel.setLayout(null);
		Date_Panel.setBounds(284, 153, 252, 60);
		Change_Cargo.getContentPane().add(Date_Panel);
		
		JLabel Date_Label = new JLabel("Transaction Date:");
		Date_Label.setForeground(Color.DARK_GRAY);
		Date_Label.setFont(f1);
		Date_Label.setBounds(0, 0, 252, 31);
		Date_Panel.add(Date_Label);
		
		Date_Input = new JTextField();
		Date_Input.setToolTipText("Transaction Date");
		Date_Input.setForeground(Color.BLACK);
		Date_Input.setFont(f2);
		Date_Input.setColumns(10);
		Date_Input.setBounds(0, 29, 252, 31);
		Date_Panel.add(Date_Input);
		
		JPanel Type_Panel = new JPanel();
		Type_Panel.setLayout(null);
		Type_Panel.setBounds(10, 224, 252, 60);
		Change_Cargo.getContentPane().add(Type_Panel);
		
		JLabel Type_Label = new JLabel("Cargo Type:");
		Type_Label.setForeground(Color.DARK_GRAY);
		Type_Label.setFont(f1);
		Type_Label.setBounds(0, 0, 252, 31);
		Type_Panel.add(Type_Label);
		
		Type_Combo = new JComboBox<String>();
		Type_Combo.setFont(f1);
		Type_Combo.setModel(new DefaultComboBoxModel<String>(new String[] {"File", "Box", "Mail"}));
		Type_Combo.setBounds(0, 29, 252, 31);
		Type_Panel.add(Type_Combo);
		
		JPanel Get_Date_Panel = new JPanel();
		Get_Date_Panel.setLayout(null);
		Get_Date_Panel.setBounds(284, 224, 252, 60);
		Change_Cargo.getContentPane().add(Get_Date_Panel);
		
		JButton Get_Date_Button = new JButton("Get Current Date");
		Get_Date_Button.setFont(f2);
		Get_Date_Button.setBounds(0, 0, 252, 60);
		Get_Date_Panel.add(Get_Date_Button);
		
		JButton Save_Button = new JButton("Save");
		Save_Button.setFont(f2);
		Save_Button.setBounds(10, 295, 252, 60);
		Change_Cargo.getContentPane().add(Save_Button);
		
		JButton Cancel_Button = new JButton("Cancel");
		Cancel_Button.setFont(f2);
		Cancel_Button.setBounds(284, 295, 252, 60);
		Change_Cargo.getContentPane().add(Cancel_Button);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(272, 11, 2, 273);
		Change_Cargo.getContentPane().add(separator);
		
		JTextField[] inputArr = {Sender_Input,Receiver_Input,From_Input,To_Input,Weight_Input,Date_Input};
		
		inputArr[0].setText(s.getSender());
		inputArr[1].setText(s.getReceiver());
		inputArr[2].setText(s.getCargo_From());
		inputArr[3].setText(s.getCargo_To());
		inputArr[4].setText(s.getCargo_Weight());
		inputArr[5].setText(s.getDate());
		Type_Combo.setSelectedItem(s.getCargo_Type());
		
		
		
		/*Event listeners*/
		Get_Date_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Date_Input.setText(java.util.Calendar.getInstance().getTime().toString());
			}
		});
		
		Cancel_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mainClass.Kapat(Change_Cargo);
			}
		});
		
		Save_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				for(JTextField is : inputArr) {
					if(is.getText().length() <= 0 ) {
						showMessageDialog(null, "Please Enter "+is.getToolTipText());
						is.requestFocus();
						return;
					}	
				}
				
				int sa = JOptionPane.showConfirmDialog(null,"Are you sure for updating shipment number "+(s.id+20200190)+" ?","Warning", JOptionPane.YES_NO_OPTION);
				if (sa == JOptionPane.NO_OPTION) {
					mainClass.Kapat(Change_Cargo);
					return;
				}

				s.setSender(inputArr[0].getText());
				s.setReceiver(inputArr[1].getText());
				s.setCargo_From(inputArr[2].getText());
				s.setCargo_To(inputArr[3].getText());
				s.setCargo_Weight(inputArr[4].getText());
				s.setDate(inputArr[5].getText());
				s.setCargo_Type((String) Type_Combo.getSelectedItem());
				
				//Objeyi json'a dönüþtür
				String JSON = new Gson().toJson(s);
				
				//Apiyi çaðýr
				String bs = new ApiRequest("ChangeCargo",JSON).GET();
				JsonObject obj = JsonParser.parseString(bs).getAsJsonObject();
				
				if(obj.get("durum").getAsString() != "true") {
					showMessageDialog(null,obj.get("body").getAsString());
					throw new RuntimeException(obj.get("body").getAsString());
				}
				
				showMessageDialog(null, "Shipment number "+(s.id+20200190)+" successfully updated!");
				mainClass.Kapat(Change_Cargo);
				
			}
		});
		
	}

}
