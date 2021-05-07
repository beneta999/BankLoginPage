import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class ForgotPasswordFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textEmail;
	private JTextField textSQ;
	private JTextField textSA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPasswordFrame frame = new ForgotPasswordFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection con;
	PreparedStatement insert;
	private JPasswordField newPass;

	public void Connect() {
		try {
			// insert your own for this line and con; it's just an example
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
	public ForgotPasswordFrame() {
		setBackground(new Color(255, 51, 102));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 464);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 51, 102));
		contentPane.setForeground(new Color(255, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Forgot Password");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(29, 23, 337, 54);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Enter your email address");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(39, 88, 164, 26);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Security Question");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(29, 170, 164, 26);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Answer");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(29, 220, 157, 26);
		contentPane.add(lblNewLabel_3);

		textEmail = new JTextField();
		textEmail.setBounds(221, 93, 247, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);

		textSQ = new JTextField();
		textSQ.setBounds(221, 175, 247, 20);
		contentPane.add(textSQ);
		textSQ.setColumns(10);

		textSA = new JTextField();
		textSA.setBounds(221, 225, 247, 20);
		contentPane.add(textSA);
		textSA.setColumns(10);

		JButton btnNewButton = new JButton("Update Password");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String email = textEmail.getText();

				String securityAnswer = textSA.getText();
				String sequrityQ = textSQ.getText();

				String newPassword = newPass.getText();

				/*
				 * try {
				 * 
				 * 
				 * 
				 * 
				 * // Connect java code with the SQL server
				 * Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); Connection con
				 * = DriverManager.getConnection(
				 * "jdbc:sqlserver://localhost:1433;database=BANK_DATABASE;integratedSecurity=true;"
				 * ); Statement st=con.createStatement();
				 * 
				 * 
				 * //ResultSet rs =st.executeQuery("SELECT * FROM USERS WHERE BANKER_EMAIL ='"+
				 * email+"' and  SECURITY_QUESTION_ANSWER = '"+ securityAnswer +"'" );
				 * //insert.setString(1, securityAnswer ); //ResultSet rs =
				 * insert.executeQuery();
				 * 
				 * insert.setString(1, securityAnswer ); insert.setString(2, newPassword);
				 * 
				 * 
				 * insert.executeUpdate();
				 * 
				 * // update the current balance when customer deposited
				 * 
				 * //update = con.prepareStatement(
				 * //"UPDATE USERS  SET EMPLOYEE_PASSWORD = ?  WHERE SECURITY_QUESTION_ANSWER =? "
				 * );
				 * 
				 * 
				 * 
				 * //update.setString(2, newPassword);
				 * 
				 * //update.setString(2, acNo); //update.executeUpdate();
				 * 
				 * JOptionPane.showMessageDialog(null, "  Successfully updated! .");
				 * con.commit();
				 * 
				 * con.close(); } catch (Exception e1) { System.out.print(e);
				 * 
				 * 
				 * }
				 * 
				 * 
				 * 
				 * 
				 * 
				 */

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(304, 340, 164, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MidtermProject md = new MidtermProject();
				md.toBack();
				setVisible(false);
				md.toFront();
				new MidtermProject().setState(java.awt.Frame.NORMAL);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(39, 340, 124, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					String email = textEmail.getText();

					// Connect java code with the SQL server
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:sqlserver://localhost:1433;database=BANK_DATABASE;integratedSecurity=true;");

					insert = con.prepareStatement("SELECT   SECURITY_QUESTION FROM USERS WHERE BANKER_EMAIL = ?");
					insert.setString(1, email);
					ResultSet rs = insert.executeQuery();

					if (rs.next()) {

						String sequrityQ = rs.getString(1);

						textSQ.setText(sequrityQ.trim());

					} else
						JOptionPane.showMessageDialog(null, " Incorrect email address. Please try again! .");
					con.close();
				} catch (Exception e1) {
					System.out.print(e);
				}

			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(221, 124, 89, 23);
		contentPane.add(btnNewButton_2);

		JLabel lblNewLabel_4 = new JLabel("New password");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(29, 275, 161, 26);
		contentPane.add(lblNewLabel_4);

		newPass = new JPasswordField();
		newPass.setBounds(221, 280, 247, 20);
		contentPane.add(newPass);
	}
}