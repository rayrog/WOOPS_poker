package fr.poker.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Vparametres {

	private JFrame frame;
	private JPasswordField pwdAccount;
	private JPasswordField pwdConfirm;
	private JTextField txtLastName;
	private JTextField txtFirstName;
	private JTextField txtPseudo;
	private JTextField txtEmail;
	private JTextField txtPhoneNumber;
	private JTextField txtMoney;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vparametres window = new Vparametres();
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
	public Vparametres() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(39, 78, 19));
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Vparametres.class.getResource("/fr/poker/view/pictures/logo.png")));
		lblLogo.setBounds(10, 11, 160, 154);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblLogo);
		
		JLabel lblTitle = new JLabel("WOOP");
		lblTitle.setBounds(214, 29, 168, 63);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.LIGHT_GRAY);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 45));
		frame.getContentPane().add(lblTitle);
		
		JLabel lblSlogan = new JLabel("World Of Online Poker");
		lblSlogan.setBounds(180, 83, 234, 63);
		lblSlogan.setHorizontalAlignment(SwingConstants.CENTER);
		lblSlogan.setForeground(Color.LIGHT_GRAY);
		lblSlogan.setFont(new Font("Tahoma", Font.ITALIC, 20));
		frame.getContentPane().add(lblSlogan);
		
		JLabel lblAvatar = new JLabel("");
		lblAvatar.setIcon(new ImageIcon(Vparametres.class.getResource("/fr/poker/view/pictures/avatar/Avatar1.png")));
		lblAvatar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvatar.setBounds(594, 17, 111, 111);
		frame.getContentPane().add(lblAvatar);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(466, 148, 176, 51);
		txtLastName.setText("Nom");
		txtLastName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtLastName.setColumns(10);
		txtLastName.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(txtLastName);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(656, 149, 176, 51);
		txtFirstName.setText("Pr\u00E9nom");
		txtFirstName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtFirstName.setColumns(10);
		txtFirstName.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(txtFirstName);
		
		txtPseudo = new JTextField();
		txtPseudo.setBounds(466, 208, 367, 51);
		txtPseudo.setText("Pseudo");
		txtPseudo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtPseudo.setColumns(10);
		txtPseudo.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(txtPseudo);
		
		pwdAccount = new JPasswordField();
		pwdAccount.setBounds(466, 267, 367, 51);
		pwdAccount.setText("Mot de passe");
		pwdAccount.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pwdAccount.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(pwdAccount);
		
		pwdConfirm = new JPasswordField();
		pwdConfirm.setBounds(466, 327, 367, 51);
		pwdConfirm.setText("Confirmer   ");
		pwdConfirm.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pwdConfirm.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(pwdConfirm);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(466, 385, 367, 51);
		txtEmail.setText("E-mail");
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtEmail.setColumns(10);
		txtEmail.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(txtEmail);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setBounds(466, 444, 367, 51);
		txtPhoneNumber.setText("N\u00B0 T\u00E9l\u00E9phone");
		txtPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(txtPhoneNumber);
		
		JButton btnRegister = new JButton("Enregistrer");
		btnRegister.setBounds(465, 506, 177, 51);
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(btnRegister);
		
		JButton btnCancel = new JButton("Annuler");
		btnCancel.setBounds(657, 507, 177, 51);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(btnCancel);
		
		txtMoney = new JTextField();
		txtMoney.setText("Argent \u00E0 d\u00E9poser");
		txtMoney.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtMoney.setColumns(10);
		txtMoney.setBackground(Color.LIGHT_GRAY);
		txtMoney.setBounds(466, 568, 367, 51);
		frame.getContentPane().add(txtMoney);
		
		JButton btnAddMoney = new JButton("Crediter");
		btnAddMoney.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddMoney.setBounds(466, 630, 177, 51);
		frame.getContentPane().add(btnAddMoney);
		
		JButton btnTakeMoney = new JButton("Retirer");
		btnTakeMoney.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTakeMoney.setBounds(656, 630, 177, 51);
		frame.getContentPane().add(btnTakeMoney);
		frame.setBounds(100, 100, 1300, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
