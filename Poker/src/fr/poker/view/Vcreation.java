package fr.poker.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import fr.poker.controller.Ccreation;
import fr.poker.controller.Cparametre;
import fr.poker.controller.listener.JButtonListenerAccueil;
import fr.poker.controller.listener.JButtonListenerCreation;
import fr.poker.controller.listener.JButtonListenerParametres;
import fr.poker.controller.listener.JTextFieldListenerCreation;
import fr.poker.controller.listener.JTextFieldListenerInscription;
import fr.poker.controller.listener.JTextFieldListenerParametre;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class Vcreation {

	private JFrame frame;
	private JPasswordField pwdSalle;
	private JPasswordField pwdSalleConfirm;
	private JTextField txtNameSalle;
	private JTextField txtMise;
	private JButton btnBack;
	private JButton btnCreationSalle;
	private JRadioButton rdbtnPrivate;
	private JRadioButton rdbtnPublique ;
	private JLabel lblMdpPwd;
	private JLabel lblConfirPwd;
	private String [] textInitiaux = {"Nom de salle","Password ", "Confirmer", "50"};
	private ButtonGroup btnGroup;
	private JTextField textField;

	
	
	public Vcreation(Ccreation ccreation) {
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
		
		txtNameSalle = new JTextField();
		txtNameSalle.setBounds(466, 148, 367, 51);
		txtNameSalle.setText(textInitiaux[0]);
		txtNameSalle.setName("txtNameSalle");
		txtNameSalle.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtNameSalle.setColumns(10);
		txtNameSalle.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(txtNameSalle);
		txtNameSalle.addMouseListener(new JTextFieldListenerCreation(ccreation, txtNameSalle));
		txtNameSalle.addFocusListener(new JTextFieldListenerCreation(ccreation, txtNameSalle));
		

		
		pwdSalle = new JPasswordField();
		pwdSalle.setBounds(466, 298, 367, 51);
		pwdSalle.setText(textInitiaux[1]);
		pwdSalle.setName("pwdSalle");
		pwdSalle.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pwdSalle.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(pwdSalle);
		pwdSalle.setEnabled(false);
		pwdSalle.addMouseListener(new JTextFieldListenerCreation(ccreation, pwdSalle));
		pwdSalle.addFocusListener(new JTextFieldListenerCreation(ccreation, pwdSalle));
		
		pwdSalleConfirm = new JPasswordField();
		pwdSalleConfirm.setBounds(466, 367, 367, 51);
		pwdSalleConfirm.setText(textInitiaux[2]);
		pwdSalleConfirm.setName("pwdSalleConfirm");
		pwdSalleConfirm.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pwdSalleConfirm.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(pwdSalleConfirm);
		pwdSalleConfirm.setEnabled(false);
		pwdSalleConfirm.addMouseListener(new JTextFieldListenerCreation(ccreation, pwdSalleConfirm));
		pwdSalleConfirm.addFocusListener(new JTextFieldListenerCreation(ccreation, pwdSalleConfirm));
		
		this.btnCreationSalle = new JButton("Créer la salle");

		btnCreationSalle.setBounds(466, 503, 367, 51);
		btnCreationSalle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(btnCreationSalle);
		btnCreationSalle.addActionListener(new JButtonListenerCreation(ccreation));	
		
		
		this.btnBack = new JButton("Retour");
		btnBack.setBounds(466, 554, 367, 51);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(btnBack);
		btnBack.addActionListener(new JButtonListenerCreation(ccreation));	
		
		
		
		this.rdbtnPrivate = new JRadioButton("Privée");
		//jrbNumbers.setMnemonic(KeyEvent.VK_N);
		rdbtnPrivate.setActionCommand("Privée");
		rdbtnPrivate.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnPrivate.setBounds(586, 211, 141, 23);
		rdbtnPrivate.addActionListener(new JButtonListenerCreation(ccreation));	
		
		this.rdbtnPublique = new JRadioButton("Publique");
		//jrbAlphabets.setMnemonic(KeyEvent.VK_A);
		rdbtnPublique.setActionCommand("Publique");
		rdbtnPublique.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnPublique.setBounds(586, 247, 141, 23);
		rdbtnPublique.setSelected(true);
		rdbtnPublique.addActionListener(new JButtonListenerCreation(ccreation));	

		// Group the radio buttons.
		this.btnGroup = new ButtonGroup();
		btnGroup.add(rdbtnPrivate);
		btnGroup.add(rdbtnPublique);	
		frame.getContentPane().add(rdbtnPrivate);
		frame.getContentPane().add(rdbtnPublique);
		
		
		
		lblMdpPwd = new JLabel("Mot de passe");
		lblMdpPwd.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMdpPwd.setHorizontalAlignment(SwingConstants.CENTER);
		lblMdpPwd.setBounds(466, 282, 367, 16);
		frame.getContentPane().add(lblMdpPwd);
		lblMdpPwd.setEnabled(false);
		
		
		lblConfirPwd = new JLabel("Confirmation mot de passe");
		lblConfirPwd.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirPwd.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblConfirPwd.setBounds(466, 351, 367, 16);
		frame.getContentPane().add(lblConfirPwd);
		lblConfirPwd.setEnabled(false);
		
		JLabel labelPresentation = new JLabel("Création de partie");
		labelPresentation.setHorizontalAlignment(SwingConstants.CENTER);
		labelPresentation.setForeground(Color.LIGHT_GRAY);
		labelPresentation.setFont(new Font("Tahoma", Font.BOLD, 40));
		labelPresentation.setBounds(426, 65, 446, 83);
		frame.getContentPane().add(labelPresentation);
		
		txtMise = new JTextField();
		txtMise.setHorizontalAlignment(SwingConstants.CENTER);
		txtMise.setText(textInitiaux[3]);
		txtMise.setName("txtMise");
		txtMise.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtMise.setColumns(10);
		txtMise.setBackground(Color.LIGHT_GRAY);
		txtMise.setBounds(466, 439, 367, 51);
		frame.getContentPane().add(txtMise);
		txtMise.addMouseListener(new JTextFieldListenerCreation(ccreation, txtMise));
		txtMise.addFocusListener(new JTextFieldListenerCreation(ccreation, txtMise));
		
		JLabel lblMiseMinimum = new JLabel("Mise minimum (en €)");
		lblMiseMinimum.setHorizontalAlignment(SwingConstants.CENTER);
		lblMiseMinimum.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMiseMinimum.setEnabled(false);
		lblMiseMinimum.setBounds(466, 424, 367, 16);
		frame.getContentPane().add(lblMiseMinimum);
		frame.setBounds(100, 100, 1300, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JPasswordField getPwdSalle() {
		return pwdSalle;
	}

	public void setPwdSalle(JPasswordField pwdSalle) {
		this.pwdSalle = pwdSalle;
	}

	public JPasswordField getPwdSalleConfirm() {
		return pwdSalleConfirm;
	}

	public void setPwdSalleConfirm(JPasswordField pwdSalleConfirm) {
		this.pwdSalleConfirm = pwdSalleConfirm;
	}
	
	
	public String getStringTxtNameSalle() {
		return txtNameSalle.getText();
	}

	public void setTxtNameSalle(JTextField txtNameSalle) {
		this.txtNameSalle = txtNameSalle;
	}

	public JLabel getLblMdpPwd() {
		return lblMdpPwd;
	}
	

	public String getStringPwdSalleConfirm() {
		return pwdSalleConfirm.getText();
	}
	
	public String getStringPwdSalle() {
		return pwdSalle.getText();
	}

	// Change le statut des champs de mot de passe : true : actif
	public void activePassword(boolean actif) {
			pwdSalle.setEnabled(actif);
			pwdSalleConfirm.setEnabled(actif);
	}

	public JLabel getLblConfirPwd() {
		return lblConfirPwd;
	}

	public void setLblConfirPwd(JLabel lblConfirPwd) {
		this.lblConfirPwd = lblConfirPwd;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public void joindreSalle(int iDplayer) {
		// TODO Auto-generated method stub
		
	}

	public JTextField getTxtMise() {
		return txtMise;
	}

	public void setTxtMise(JTextField txtMise) {
		this.txtMise = txtMise;
	}

	public String[] getTextInitiaux() {
		return textInitiaux;
	}
}
