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
import javax.swing.JTextArea;

import javax.swing.JFrame;

public class HelpPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpPage window = new HelpPage();
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
	public HelpPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 51, 102));
		frame.setBounds(100, 100, 590, 387);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HELP");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 22));
		lblNewLabel.setBounds(263, 34, 82, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/bank-icon.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(164, 39, 72, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextArea txtrAreYouFeeling = new JTextArea();
		txtrAreYouFeeling.setForeground(new Color(255, 51, 102));
		txtrAreYouFeeling.setText("Are you feeling lost???");
		txtrAreYouFeeling.setBounds(40, 119, 188, 22);
		frame.getContentPane().add(txtrAreYouFeeling);
		
		JTextArea txtrNoWorriesCall = new JTextArea();
		txtrNoWorriesCall.setForeground(new Color(255, 51, 102));
		txtrNoWorriesCall.setText("No worries! Call us any time...");
		txtrNoWorriesCall.setBounds(114, 174, 256, 22);
		frame.getContentPane().add(txtrNoWorriesCall);
		
		JTextArea txtrWithOur = new JTextArea();
		txtrWithOur.setForeground(new Color(255, 51, 102));
		txtrWithOur.setText("With our 24/7 customer assistance...Get the help YOU need!");
		txtrWithOur.setBounds(68, 228, 468, 22);
		frame.getContentPane().add(txtrWithOur);
		
		JTextArea txtrSupportLine = new JTextArea();
		txtrSupportLine.setBackground(new Color(255, 51, 102));
		txtrSupportLine.setText("Support line: 999-876-0000");
		txtrSupportLine.setBounds(151, 275, 219, 30);
		frame.getContentPane().add(txtrSupportLine);
	}

}
