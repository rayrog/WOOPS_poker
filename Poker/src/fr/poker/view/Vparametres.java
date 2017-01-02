package fr.poker.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import fr.poker.controller.Cparametre;
import fr.poker.controller.listener.JButtonListenerAccueil;
import fr.poker.controller.listener.JButtonListenerParametres;
import fr.poker.controller.listener.JTextFieldListenerInscription;
import fr.poker.controller.listener.JTextFieldListenerParametre;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.Icon;
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
	private JButton btnRetirer;
	private JButton btnCancel;
	private JButton btnRegister;
	private JLabel lblErrorField;
	private JLabel lblSuccess;
	private JLabel lblAvatar;
	private String pathImage;
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
		
		//setInfoToDisplay(this.getTextInitiaux());
		
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
		
	
		lblAvatar = new JLabel("");
		lblAvatar.setIcon(new ImageIcon(Vparametres.class.getResource("/fr/poker/view/pictures/avatar/Avatar1.png")));
		lblAvatar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvatar.setBounds(594, 17, 111, 111);
		frame.getContentPane().add(lblAvatar);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(466, 148, 176, 51);
		//txtLastName.setText(textInitiaux[2]);
		txtLastName.setName("txtLastName");
		txtLastName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtLastName.setColumns(10);
		txtLastName.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(txtLastName);
		txtLastName.addMouseListener(new JTextFieldListenerParametre(cPara, txtLastName));
		txtLastName.addFocusListener(new JTextFieldListenerParametre(cPara, txtLastName));
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(656, 149, 176, 51);
		//txtFirstName.setText(textInitiaux[3]);
		txtFirstName.setName("txtFirstName");
		txtFirstName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtFirstName.setColumns(10);
		txtFirstName.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(txtFirstName);
		txtFirstName.addMouseListener(new JTextFieldListenerParametre(cPara, txtFirstName));
		txtFirstName.addFocusListener(new JTextFieldListenerParametre(cPara, txtFirstName));
		
		txtPseudo = new JTextField();
		txtPseudo.setBounds(466, 208, 367, 51);
		//txtPseudo.setText(textInitiaux[4]);
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
		//txtEmail.setText(textInitiaux[5]);
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
		
		this.btnCancel = new JButton("Retour");
		btnCancel.setBounds(466, 692, 366, 51);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(btnCancel);
		btnCancel.addActionListener(new JButtonListenerParametres(cPara));
		
		txtMoney = new JTextField();
		txtMoney.setEditable(false);
		//txtMoney.setText(textInitiaux[7]);
		txtMoney.setName("txtMoney");
		txtMoney.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtMoney.setColumns(10);
		txtMoney.setBackground(Color.LIGHT_GRAY);
		txtMoney.setBounds(466, 568, 367, 51);
		frame.getContentPane().add(txtMoney);
		
		this.btnAddMoney = new JButton("Crediter");
		btnAddMoney.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddMoney.setBounds(466, 630, 183, 51);
		frame.getContentPane().add(btnAddMoney);
		btnAddMoney.addActionListener(new JButtonListenerParametres(cPara));
		frame.setBounds(100, 100, 1300, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		btnRetirer = new JButton("Retirer");
		btnRetirer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRetirer.setBounds(656, 630, 176, 51);
		frame.getContentPane().add(btnRetirer);
		btnRetirer.addActionListener(new JButtonListenerParametres(cPara));
		
		// Partie Label d'erreur ou de success : 
		lblErrorField = new JLabel("");
		lblErrorField.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblErrorField.setForeground(Color.RED);
		lblErrorField.setBounds(407, 128, 486, 16);
		frame.getContentPane().add(lblErrorField);
		lblErrorField.setVisible(false);
		
        Object[] items =
        {	
        	new ImageIcon(Vinscription.class.getResource("/fr/poker/view/pictures/avatar/Avatar1.png")),
        	new ImageIcon(Vinscription.class.getResource("/fr/poker/view/pictures/avatar/Avatar2.png")),
        	new ImageIcon(Vinscription.class.getResource("/fr/poker/view/pictures/avatar/Avatar3.png")),
        	new ImageIcon(Vinscription.class.getResource("/fr/poker/view/pictures/avatar/Avatar4.png")),
        	new ImageIcon(Vinscription.class.getResource("/fr/poker/view/pictures/avatar/Avatar5.png")),
        	new ImageIcon(Vinscription.class.getResource("/fr/poker/view/pictures/avatar/Avatar6.png")),
        	new ImageIcon(Vinscription.class.getResource("/fr/poker/view/pictures/avatar/Avatar7.png")),
        	new ImageIcon(Vinscription.class.getResource("/fr/poker/view/pictures/avatar/Avatar8.png")),
        	new ImageIcon(Vinscription.class.getResource("/fr/poker/view/pictures/avatar/Avatar9.png"))
        };
		
	}
	

	public int displayCrediter() {
		JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
		String nom = jop.showInputDialog(null, "Montant à credtier", JOptionPane.QUESTION_MESSAGE);
		jop2.showMessageDialog(null, "Credité de " + nom, "Credité", JOptionPane.INFORMATION_MESSAGE);
		return (Integer.parseInt(nom));
	}

	
	
	public int displayRetirer() {
		JOptionPane jop3 = new JOptionPane(), jop4 = new JOptionPane();
		String nom = jop3.showInputDialog(null, "Montant à retirer", JOptionPane.QUESTION_MESSAGE);
		jop4.showMessageDialog(null, "Retiré de" + nom, "Retiré", JOptionPane.INFORMATION_MESSAGE);
		return Integer.parseInt(nom);
	}

	
	
	public String[] getTextInitiaux() {
		return textInitiaux;
	}
		
	
	public JLabel getLblErrorField() {
		return lblErrorField;
	}

	public void setLblErrorField(JLabel lblErrorField) {
		this.lblErrorField = lblErrorField;
	}

	public JLabel getLblSuccess() {
		return lblSuccess;
	}

	public void setLblSuccess(JLabel lblSuccess) {
		this.lblSuccess = lblSuccess;
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

	public JLabel getLblAvatar() {
		return lblAvatar;
	}

	public void setLblAvatar(JLabel lblAvatar) {
		this.lblAvatar = lblAvatar;
	}

	public String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}
	
	public void setInfoToDisplay(String[] infos) {
		//Permet d'initialiser les valeurses a pre-remplir dans les différents champs.
		//System.out.println(infos);
		// Utilisé pour le premier remplissage : 
		
		txtPseudo.setText(infos[2]);
		txtLastName.setText(infos[1]);
		txtFirstName.setText(infos[3]);
		txtEmail.setText(infos[4]);
		txtPhoneNumber.setText(infos[5]);
		txtMoney.setText("Credit : " + infos[6] + " €");
		
		// Enregistre aussi ces valeurs dans la variable servant a l'auo remplissage.
		String [] text = {"Mot de passe","Confirmer   ", infos[1], infos[3],infos[2],infos[4],infos[5],"Credit : " + infos[6] + " €"};
		textInitiaux=text;
	}
}
