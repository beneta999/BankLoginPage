import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.sql.*;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ForgotPassword extends JFrame {

	private JFrame frame;
	private JTextField txtEmailAddr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPassword window = new ForgotPassword();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public ForgotPassword() {
		initialize();
		Connect();
	}
	Connection con;
	PreparedStatement insert, update;
	private JPasswordField passwordField;
	private JPasswordField confirmPasswordField;
	
	public void Connect() {
		try {
			//insert your own for this line and con; it's just an example
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/bankLogin", "root","");
		}
		catch (ClassNotFoundException ex)
		{
			
		}
		catch (SQLException ex)
		{
			
		}
	}
	//function to validate password
	//needs to be at least 8 characters
	//other attributes such as: at least 1 Cap, 1 lower case, 1 digit
	/**public static boolean validatePassword(String password) {
		if(password.length() > 7)
		{
			if(checkPassword(password)) {
				return true;
			}
			else
			{
				return false;
			}
			
		}
		else 
		{
			System.out.println("Need a longer password");
			return false;
		}
	}
	public static boolean checkPassword(String password) {
		boolean hasNum=false;
		boolean hasCap=false;
		boolean hasLow=false;
		char c;
		for(int i=0; i<password.length(); i++)
		{
			c = password.charAt(i);
			if(Character.isDigit(c)) {
				hasNum=true;
			}
			else if(Character.isUpperCase(c)) {
				hasCap=true;
			}
			else if(Character.isLowerCase(c)) {
				hasLow=true;
			}
			if(hasNum && hasCap && hasLow) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 51, 102));
		frame.setBounds(100, 100, 500, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Forgot Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(133, 28, 157, 34);
		frame.getContentPane().add(lblNewLabel);
		
		txtEmailAddr = new JTextField();
		txtEmailAddr.setBounds(196, 101, 122, 25);
		frame.getContentPane().add(txtEmailAddr);
		txtEmailAddr.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter your email address");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(12, 92, 172, 16);
		//panel.add(lblNewLabel_1);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter new password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(12, 138, 156, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Confirm new password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(12, 175, 145, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Update Password");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("deprecation")
				String password = passwordField.getText();
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:sqlserver://localhost:1433;database=BANK_DATABASE;integratedSecurity=true;");
					Statement stmt = con.createStatement();
					@SuppressWarnings("deprecation")
					String sql = "Update USERS set EMPLOYEE_PASSWORD where EMPLOYEE_USER_NAME='" + txtEmailAddr.getText();
					ResultSet rs = stmt.executeQuery(sql);
					con.close();
				}
				catch (Exception e1) {
					System.out.print(e);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(146, 215, 166, 25);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/bank-icon.png")).getImage();
		lblNewLabel_4.setIcon(new ImageIcon(img));
		lblNewLabel_4.setBounds(46, 39, 56, 23);
		frame.getContentPane().add(lblNewLabel_4);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(196, 134, 122, 25);
		frame.getContentPane().add(passwordField);
		
		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setBounds(196, 171, 122, 25);
		frame.getContentPane().add(confirmPasswordField);
		//initialize();
	}

}
