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
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Window.Type;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static javax.swing.JOptionPane.showMessageDialog;





public class LoginScreen {

	private JFrame frmHumbldumpExpress;
	private JPasswordField passwordField;
	private static String Password;
	/**
	 * Launch the application.
	 */
	public static void main(String password) {
		Password = password;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen window = new LoginScreen();
					window.frmHumbldumpExpress.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Login Screen Göster
	 */
	public LoginScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHumbldumpExpress = new JFrame();
		
		//Þifre Alaný
		passwordField = new JPasswordField();
		//Giriþ Yap Butonu
		JButton btnNewButton = new JButton("Login");
		
		//iptal butonu
		JButton btnCancel = new JButton("Cancel");
		
		
		frmHumbldumpExpress.setFont(new Font("Arial", Font.PLAIN, 16));
		frmHumbldumpExpress.setTitle("HumblDump Exspress | Login to the system");
		frmHumbldumpExpress.setType(Type.UTILITY);
		frmHumbldumpExpress.setBounds(100, 100, 450, 300);
		frmHumbldumpExpress.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHumbldumpExpress.getContentPane().setLayout(null);
		
		
		
		
		
		
		JLabel lblNewLabel = new JLabel("HumblDump - Express");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 40);
		frmHumbldumpExpress.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("V1.0.1");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(20, 62, 404, 14);
		frmHumbldumpExpress.getContentPane().add(lblNewLabel_1);
		
		
		
		passwordField.setEchoChar('*');
		passwordField.setToolTipText("Password");
		passwordField.setBounds(10, 127, 414, 40);
		frmHumbldumpExpress.getContentPane().add(passwordField);
		
		JLabel lblPassword = new JLabel("Enter the Password");
		lblPassword.setForeground(Color.GRAY);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Arial", Font.BOLD, 28));
		lblPassword.setBounds(10, 87, 414, 40);
		frmHumbldumpExpress.getContentPane().add(lblPassword);
		
		
		btnNewButton.setEnabled(false);
		btnNewButton.setForeground(Color.GRAY);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.setBounds(10, 178, 207, 72);
		frmHumbldumpExpress.getContentPane().add(btnNewButton);
		
		
		btnCancel.setForeground(Color.GRAY);
		btnCancel.setFont(new Font("Arial", Font.BOLD, 18));
		btnCancel.setBounds(217, 178, 207, 72);
		frmHumbldumpExpress.getContentPane().add(btnCancel);
		
		
		
		
		/*
		 * Event Dinleyiciler
		 * 
		 * */
		
		//Þifre Alaný KeyPress
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(passwordField.getPassword().length > 0)
					btnNewButton.setEnabled(true);
				else
					btnNewButton.setEnabled(false);
			}
		});
		
		
		//Giriþ Yap Butonu
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JButton bt = (JButton)e.getSource();
				if(!bt.isEnabled())
					return;
				String pass = new String(passwordField.getPassword());
				if(pass.equals(Password)) {
					mainClass.GirisDogru();
					mainClass.Kapat(frmHumbldumpExpress);
				}
				else {
					showMessageDialog(null,"Wrong password, try again.");

				}
				
				
			}
		});
		
		//Cancel Butonu
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
				mainClass.Kapat(frmHumbldumpExpress);
			}
		});
		
		
	}
}
