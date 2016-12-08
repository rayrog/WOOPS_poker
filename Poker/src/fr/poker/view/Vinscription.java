package fr.poker.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import fr.poker.controller.listener.CinscriptionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Vinscription {

	private JFrame frame;
	private JPasswordField pwdAccount;
	private JTextField txtLastName;
	private JTextField txtPseudo;
	private JTextField txtFirstName;
	private JPasswordField pwdConfirm;
	private JTextField txtEmail;
	private JTextField txtPhoneNumber;
	JButton btnSignUp;

/*	*//**
	 * Launch the application.
	 *//*
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
*/
	/**
	 * Create the application.
	 */
	public Vinscription() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(39, 78, 19));
		frame.setBounds(100, 100, 1300, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		pwdAccount = new JPasswordField();
		pwdAccount.setText("Mot de passe");
		pwdAccount.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pwdAccount.setBackground(Color.LIGHT_GRAY);
		pwdAccount.setBounds(427, 308, 367, 51);
		frame.getContentPane().add(pwdAccount);
		
		pwdConfirm = new JPasswordField();
		pwdConfirm.setText("Confirmer   ");
		pwdConfirm.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pwdConfirm.setBackground(Color.LIGHT_GRAY);
		pwdConfirm.setBounds(427, 370, 367, 51);
		frame.getContentPane().add(pwdConfirm);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Vinscription.class.getResource("/fr/poker/view/pictures/logo.png")));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(385, 20, 160, 154);
		frame.getContentPane().add(lblLogo);
		
		JLabel lblTitle = new JLabel("WOOP");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.LIGHT_GRAY);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblTitle.setBounds(569, 30, 168, 63);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblSlogan = new JLabel("World Of Online Poker");
		lblSlogan.setHorizontalAlignment(SwingConstants.CENTER);
		lblSlogan.setForeground(Color.LIGHT_GRAY);
		lblSlogan.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblSlogan.setBounds(532, 87, 234, 63);
		frame.getContentPane().add(lblSlogan);
		
		txtLastName = new JTextField();
		txtLastName.setText("Nom");
		txtLastName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtLastName.setColumns(10);
		txtLastName.setBackground(Color.LIGHT_GRAY);
		txtLastName.setBounds(427, 184, 176, 51);
		frame.getContentPane().add(txtLastName);
		
		txtFirstName = new JTextField();
		txtFirstName.setText("Pr\u00E9nom");
		txtFirstName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtFirstName.setColumns(10);
		txtFirstName.setBackground(Color.LIGHT_GRAY);
		txtFirstName.setBounds(618, 184, 176, 51);
		frame.getContentPane().add(txtFirstName);
		
		txtPseudo = new JTextField();
		txtPseudo.setText("Pseudo");
		txtPseudo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtPseudo.setColumns(10);
		txtPseudo.setBackground(Color.LIGHT_GRAY);
		txtPseudo.setBounds(427, 246, 367, 51);
		frame.getContentPane().add(txtPseudo);
		
		txtEmail = new JTextField();
		txtEmail.setText("E-mail");
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtEmail.setColumns(10);
		txtEmail.setBackground(Color.LIGHT_GRAY);
		txtEmail.setBounds(427, 432, 367, 51);
		frame.getContentPane().add(txtEmail);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setText("N\u00B0 T\u00E9l\u00E9phone");
		txtPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBackground(Color.LIGHT_GRAY);
		txtPhoneNumber.setBounds(427, 494, 367, 51);
		frame.getContentPane().add(txtPhoneNumber);
		
		this.btnSignUp = new JButton("Inscription");
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSignUp.setBounds(427, 556, 367, 51);
		btnSignUp.addActionListener(new CinscriptionListener());
		frame.getContentPane().add(btnSignUp);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JPasswordField getPwdAccount() {
		return pwdAccount;
	}

	public void setPwdAccount(JPasswordField pwdAccount) {
		this.pwdAccount = pwdAccount;
	}

	public JTextField getTxtLastName() {
		return txtLastName;
	}

	public void setTxtLastName(JTextField txtLastName) {
		this.txtLastName = txtLastName;
	}

	public JTextField getTxtPseudo() {
		return txtPseudo;
	}

	public void setTxtPseudo(JTextField txtPseudo) {
		this.txtPseudo = txtPseudo;
	}

	public JTextField getTxtFirstName() {
		return txtFirstName;
	}

	public void setTxtFirstName(JTextField txtFirstName) {
		this.txtFirstName = txtFirstName;
	}

	public JPasswordField getPwdConfirm() {
		return pwdConfirm;
	}

	public void setPwdConfirm(JPasswordField pwdConfirm) {
		this.pwdConfirm = pwdConfirm;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public JTextField getTxtPhoneNumber() {
		return txtPhoneNumber;
	}

	public void setTxtPhoneNumber(JTextField txtPhoneNumber) {
		this.txtPhoneNumber = txtPhoneNumber;
	}
	
}
