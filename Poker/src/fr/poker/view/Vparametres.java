package fr.poker.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import fr.poker.controller.Cparametre;
import fr.poker.controller.listener.JButtonListenerAccueil;
import fr.poker.controller.listener.JButtonListenerParametres;
import fr.poker.controller.listener.JTextFieldListenerInscription;
import fr.poker.controller.listener.JTextFieldListenerParametre;

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
	private String [] textInitiaux = {"Mot de passe","Confirmer   ", "Nom", "Pr\u00E9nom",  "Pseudo", "E-mail", "N\u00B0 T\u00E9l\u00E9phone","Credit"};
	private JButton btnAddMoney;
	private JButton btnCancel;
	private JButton btnRegister;
	private JLabel lblErrorField;
	private JLabel lblSuccess;
	/**
	 * Launch the application.
	 */
	/*
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
	}*/

	/**
	 * Create the application.
	 * @param cparametre 
	 */
	public Vparametres(Cparametre cPara) {
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
		
		lblSuccess = new JLabel("Enregistrement effectué avec succès !");
		lblSuccess.setBackground(new Color(0, 128, 0));
		lblSuccess.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuccess.setForeground(Color.RED);
		lblSuccess.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblSuccess.setBounds(239, 102, 835, 63);
		frame.getContentPane().add(lblSuccess);
		lblSuccess.setVisible(false);
		
		JLabel lblAvatar = new JLabel("");
		lblAvatar.setIcon(new ImageIcon(Vparametres.class.getResource("/fr/poker/view/pictures/avatar/Avatar1.png")));
		lblAvatar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvatar.setBounds(594, 17, 111, 111);
		frame.getContentPane().add(lblAvatar);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(466, 148, 176, 51);
		txtLastName.setText(textInitiaux[2]);
		txtLastName.setName("txtLastName");
		txtLastName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtLastName.setColumns(10);
		txtLastName.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(txtLastName);
		txtLastName.addMouseListener(new JTextFieldListenerParametre(cPara, txtLastName));
		txtLastName.addFocusListener(new JTextFieldListenerParametre(cPara, txtLastName));
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(656, 149, 176, 51);
		txtFirstName.setText(textInitiaux[3]);
		txtFirstName.setName("txtFirstName");
		txtFirstName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtFirstName.setColumns(10);
		txtFirstName.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(txtFirstName);
		txtFirstName.addMouseListener(new JTextFieldListenerParametre(cPara, txtFirstName));
		txtFirstName.addFocusListener(new JTextFieldListenerParametre(cPara, txtFirstName));
		
		txtPseudo = new JTextField();
		txtPseudo.setBounds(466, 208, 367, 51);
		txtPseudo.setText(textInitiaux[4]);
		txtPseudo.setName("txtPseudo");
		txtPseudo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtPseudo.setColumns(10);
		txtPseudo.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(txtPseudo);
		txtPseudo.addMouseListener(new JTextFieldListenerParametre(cPara, txtPseudo));
		txtPseudo.addFocusListener(new JTextFieldListenerParametre(cPara, txtPseudo));
		
		pwdAccount = new JPasswordField();
		pwdAccount.setBounds(466, 267, 367, 51);
		pwdAccount.setText(textInitiaux[0]);
		pwdAccount.setName("pwdAccount");
		pwdAccount.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pwdAccount.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(pwdAccount);
		pwdAccount.addMouseListener(new JTextFieldListenerParametre(cPara, pwdAccount));
		pwdAccount.addFocusListener(new JTextFieldListenerParametre(cPara, pwdAccount));
		
		
		pwdConfirm = new JPasswordField();
		pwdConfirm.setBounds(466, 327, 367, 51);
		pwdConfirm.setText(textInitiaux[1]);
		pwdConfirm.setName("pwdConfirm");
		pwdConfirm.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pwdConfirm.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(pwdConfirm);
		pwdConfirm.addMouseListener(new JTextFieldListenerParametre(cPara, pwdConfirm));
		pwdConfirm.addFocusListener(new JTextFieldListenerParametre(cPara, pwdConfirm));
		
		
		txtEmail = new JTextField();
		txtEmail.setBounds(466, 385, 367, 51);
		txtEmail.setText(textInitiaux[5]);
		txtEmail.setName("txtEmail");
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtEmail.setColumns(10);
		txtEmail.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(txtEmail);
		txtEmail.addMouseListener(new JTextFieldListenerParametre(cPara, txtEmail));
		txtEmail.addFocusListener(new JTextFieldListenerParametre(cPara, txtEmail));
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setBounds(466, 444, 367, 51);
		//txtPhoneNumber.setText(textInitiaux[6]);
		txtPhoneNumber.setName("txtPhoneNumber");
		txtPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(txtPhoneNumber);
		txtPhoneNumber.addMouseListener(new JTextFieldListenerParametre(cPara, txtPhoneNumber));
		txtPhoneNumber.addFocusListener(new JTextFieldListenerParametre(cPara, txtPhoneNumber));
		
		this.btnRegister = new JButton("Enregistrer");
		btnRegister.setBounds(465, 506, 367, 51);
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(btnRegister);
		btnRegister.addActionListener(new JButtonListenerParametres(cPara));
		
		this.btnCancel = new JButton("Annuler");
		btnCancel.setBounds(466, 692, 366, 51);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(btnCancel);
		btnCancel.addActionListener(new JButtonListenerParametres(cPara));
		
		txtMoney = new JTextField();
		txtMoney.setEditable(false);
		txtMoney.setText(textInitiaux[7]);
		txtMoney.setName("txtMoney");
		txtMoney.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtMoney.setColumns(10);
		txtMoney.setBackground(Color.LIGHT_GRAY);
		txtMoney.setBounds(466, 568, 367, 51);
		frame.getContentPane().add(txtMoney);
		txtMoney.addMouseListener(new JTextFieldListenerParametre(cPara, txtMoney));
		txtMoney.addFocusListener(new JTextFieldListenerParametre(cPara, txtMoney));
		
		this.btnAddMoney = new JButton("Crediter/Retirer");
		btnAddMoney.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddMoney.setBounds(466, 630, 366, 51);
		frame.getContentPane().add(btnAddMoney);
		btnAddMoney.addActionListener(new JButtonListenerParametres(cPara));
		frame.setBounds(100, 100, 1300, 800);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public String[] getTextInitiaux() {
		return textInitiaux;
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

	public JPasswordField getPwdConfirm() {
		return pwdConfirm;
	}

	public void setPwdConfirm(JPasswordField pwdConfirm) {
		this.pwdConfirm = pwdConfirm;
	}

	public JTextField getTxtLastName() {
		return txtLastName;
	}

	
	public void setTxtLastName(JTextField txtLastName) {
		this.txtLastName = txtLastName;
	}

	public JTextField getTxtFirstName() {
		return txtFirstName;
	}

	public void setTxtFirstName(JTextField txtFirstName) {
		this.txtFirstName = txtFirstName;
	}

	public JTextField getTxtPseudo() {
		return txtPseudo;
	}

	public void setTxtPseudo(JTextField txtPseudo) {
		this.txtPseudo = txtPseudo;
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

	public JTextField getTxtMoney() {
		return txtMoney;
	}

	public void setTxtMoney(JTextField txtMoney) {
		this.txtMoney = txtMoney;
	}

	public void setInfoToDisplay(String[] infos) {
		//String[] Name=c;  	
		/*
		txtPseudo.setText(Name[2]);
		txtLastName.setText(Name[1]);
		txtFirstName.setText(Name[3]);
		txtEmail.setText(Name[4]);
		txtPhoneNumber.setText(Name[5]);
		txtMoney.setText(Name[6]);*/
		String [] text = {"Mot de passe","Confirmer   ", infos[1], infos[3],infos[2],infos[4],infos[5],infos[6]};
		textInitiaux=text;
	}
	
}
