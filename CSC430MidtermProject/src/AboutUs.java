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


public class AboutUs {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutUs window = new AboutUs();
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
	public AboutUs() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 574, 405);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("About Us");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(226, 39, 149, 43);
		frame.getContentPane().add(lblNewLabel);
		
		JTextArea txtrOurMissionIs = new JTextArea();
		txtrOurMissionIs.setForeground(new Color(0, 0, 0));
		txtrOurMissionIs.setFont(new Font("Monotype Corsiva", Font.ITALIC, 16));
		txtrOurMissionIs.setText("Our mission is to maximize the banking experience of our customers by providing customer-focused service. We accomplish this by attentively listening and offering personalized solutions for our customers' individual needs while utilizing technological innovations. While many banks have come and gone, we successfully foster Relationships for Generations with utmost importance to secure online banking.");
		txtrOurMissionIs.setBounds(17, 116, 527, 197);
		frame.getContentPane().add(txtrOurMissionIs);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/bank-icon.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(150, 51, 56, 23);
		frame.getContentPane().add(lblNewLabel_1);
		//lblNewLabel_1.setBounds(142, 39, 63, 34);
		//frame.getContentPane().add(lblNewLabel_1);
	}
}
