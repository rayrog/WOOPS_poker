package fr.poker.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Vinscription {

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField txtNom;
	private JTextField txtPseudo;
	private JTextField txtPrnom;
	private JPasswordField pwdConfirmer;
	private JTextField txtEmail;
	private JTextField txtN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vinscription window = new Vinscription();
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
	public Vinscription() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(39, 78, 19));
		frame.setBounds(100, 100, 1300, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setText("Mot de passe");
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		passwordField.setBackground(Color.LIGHT_GRAY);
		passwordField.setBounds(427, 308, 367, 51);
		frame.getContentPane().add(passwordField);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Vinscription.class.getResource("/fr/poker/view/pictures/logo.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(385, 20, 160, 154);
		frame.getContentPane().add(label);
		
		txtNom = new JTextField();
		txtNom.setText("Nom");
		txtNom.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtNom.setColumns(10);
		txtNom.setBackground(Color.LIGHT_GRAY);
		txtNom.setBounds(427, 184, 176, 51);
		frame.getContentPane().add(txtNom);
		
		JLabel label_1 = new JLabel("WOOP");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.LIGHT_GRAY);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 45));
		label_1.setBounds(569, 30, 168, 63);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("World Of Online Poker");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.LIGHT_GRAY);
		label_2.setFont(new Font("Tahoma", Font.ITALIC, 20));
		label_2.setBounds(532, 87, 234, 63);
		frame.getContentPane().add(label_2);
		
		JButton button = new JButton("Inscription");
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button.setBounds(427, 556, 367, 51);
		frame.getContentPane().add(button);
		
		txtPseudo = new JTextField();
		txtPseudo.setText("Pseudo");
		txtPseudo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtPseudo.setColumns(10);
		txtPseudo.setBackground(Color.LIGHT_GRAY);
		txtPseudo.setBounds(427, 246, 367, 51);
		frame.getContentPane().add(txtPseudo);
		
		txtPrnom = new JTextField();
		txtPrnom.setText("Pr\u00E9nom");
		txtPrnom.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtPrnom.setColumns(10);
		txtPrnom.setBackground(Color.LIGHT_GRAY);
		txtPrnom.setBounds(618, 184, 176, 51);
		frame.getContentPane().add(txtPrnom);
		
		pwdConfirmer = new JPasswordField();
		pwdConfirmer.setText("Confirmer   ");
		pwdConfirmer.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pwdConfirmer.setBackground(Color.LIGHT_GRAY);
		pwdConfirmer.setBounds(427, 370, 367, 51);
		frame.getContentPane().add(pwdConfirmer);
		
		txtEmail = new JTextField();
		txtEmail.setText("E-mail");
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtEmail.setColumns(10);
		txtEmail.setBackground(Color.LIGHT_GRAY);
		txtEmail.setBounds(427, 432, 367, 51);
		frame.getContentPane().add(txtEmail);
		
		txtN = new JTextField();
		txtN.setText("N\u00B0 T\u00E9l\u00E9phone");
		txtN.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtN.setColumns(10);
		txtN.setBackground(Color.LIGHT_GRAY);
		txtN.setBounds(427, 494, 367, 51);
		frame.getContentPane().add(txtN);
	}
}
