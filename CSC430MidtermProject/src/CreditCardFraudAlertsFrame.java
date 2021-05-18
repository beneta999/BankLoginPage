import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class CreditCardFraudAlertsFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textID;
	private JTextField textcreditcard_number;
	private JTextField textCreditcard_holder;
	private JTextField textCredit_amount;
	private JTextField txtDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreditCardFraudAlertsFrame frame = new CreditCardFraudAlertsFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	Connection con;
	PreparedStatement insert, update;
	
	
	
	
	
	public void Connect() {
		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;database=BANK_DATABASE;integratedSecurity=true;");
		} catch (ClassNotFoundException ex) {

		} catch (SQLException ex) {

		}
	}
	/**
	 * Create the frame.
	 */
	public CreditCardFraudAlertsFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 421);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Credit Card Fraud  Alerts");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(193, 31, 287, 49);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("User ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(29, 168, 68, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Credit Card Number");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(140, 168, 134, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Credit Card Holder SSN");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(316, 161, 172, 28);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_5 = new JLabel("Amount");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(547, 168, 78, 14);
		contentPane.add(lblNewLabel_5);

		textID = new JTextField();
		textID.setBounds(10, 203, 110, 20);
		contentPane.add(textID);
		textID.setColumns(10);

		textcreditcard_number = new JTextField();
		textcreditcard_number.setBounds(135, 203, 172, 20);
		contentPane.add(textcreditcard_number);
		textcreditcard_number.setColumns(10);

		textCreditcard_holder = new JTextField();
		textCreditcard_holder.setBounds(338, 203, 150, 20);
		contentPane.add(textCreditcard_holder);
		textCreditcard_holder.setColumns(10);

		textCredit_amount = new JTextField();
		textCredit_amount.setBounds(519, 203, 119, 20);
		contentPane.add(textCredit_amount);
		textCredit_amount.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Please Enter the Date");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(29, 101, 172, 20);
		contentPane.add(lblNewLabel_6);
		
		txtDate = new JTextField();
		txtDate.setBounds(243, 102, 222, 20);
		contentPane.add(txtDate);
		txtDate.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {

					String date = txtDate.getText();

					// Connect java code with the SQL server
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:sqlserver://localhost:1433;database=BANK_DATABASE;integratedSecurity=true;");

					insert = con.prepareStatement(
							"SELECT CREDIT_FRAUD_ID , TRANSACTION_AMOUNT , CUSTOMER_SSN , CREDIT_CARD_NUMBER FROM CREDITCARDS_FRAUD_ALERTS WHERE TRANSACTION_DATE = ?");
					insert.setString(1, date);
					ResultSet rs = insert.executeQuery();

					if (rs.next()) {

						String userID = rs.getString(1);
						String userIDcreditCNo = rs.getString(4);
						String SSN = rs.getString(3);
						String amount = rs.getString(2);
						
						
						

						textID.setText(userID.trim());
						textcreditcard_number.setText(userIDcreditCNo.trim());
						textCreditcard_holder.setText(SSN.trim());
						textCredit_amount.setText(amount.trim());

					} else
						JOptionPane.showMessageDialog(null, " Incorrect date format. Please try again! .");
					con.close();
				} catch (Exception e1) {
					System.out.print(e);
				}
				
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(517, 100, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FraudAlertFrame fd = new FraudAlertFrame ();
				fd.toBack();
				setVisible(false);
				fd.toFront();
				new AdministrationFrame().setState(java.awt.Frame.NORMAL);
				
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(88, 322, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Next");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(496, 323, 89, 23);
		contentPane.add(btnNewButton_2);
	}
}
