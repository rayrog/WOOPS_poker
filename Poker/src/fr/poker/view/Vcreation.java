package fr.poker.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import fr.poker.controller.Ccreation;
import fr.poker.controller.listener.JButtonListenerConnexion;
import fr.poker.controller.listener.JButtonListenerCreation;

import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class Vcreation {

	private JFrame frame;
	private JPasswordField pwdSalle;
	private JPasswordField pwdSalleConfirm;
	private JTextField txtNameSalle;
	private JButton btnBack;
	private JButton btnCreationSalle;
	private JLabel lblMotDePasse;
	private JLabel lblConfirmationMotDe;

	
	
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
		txtNameSalle.setText("Nom de salle");
		txtNameSalle.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtNameSalle.setColumns(10);
		txtNameSalle.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(txtNameSalle);
		
		pwdSalle = new JPasswordField();
		pwdSalle.setBounds(466, 298, 367, 51);
		pwdSalle.setText("Mot de passe");
		pwdSalle.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pwdSalle.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(pwdSalle);
		pwdSalle.setEnabled(false);
		
		pwdSalleConfirm = new JPasswordField();
		pwdSalleConfirm.setBounds(466, 367, 367, 51);
		pwdSalleConfirm.setText("Confirmer   ");
		pwdSalleConfirm.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pwdSalleConfirm.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(pwdSalleConfirm);
		pwdSalleConfirm.setEnabled(false);
		
		this.btnCreationSalle = new JButton("Créer la salle");

		btnCreationSalle.setBounds(466, 419, 367, 51);
		btnCreationSalle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(btnCreationSalle);
		btnCreationSalle.addActionListener(new JButtonListenerCreation(ccreation));	
		
		
		this.btnBack = new JButton("Retour");
		btnBack.setBounds(467, 470, 366, 51);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(btnBack);
		btnBack.addActionListener(new JButtonListenerCreation(ccreation));	
		
		
		JRadioButton rdbtnPrivate = new JRadioButton("Privée");
		rdbtnPrivate.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnPrivate.setBounds(586, 211, 141, 23);
		frame.getContentPane().add(rdbtnPrivate);
		
		JRadioButton rdbtnPublique = new JRadioButton("Publique");
		rdbtnPublique.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnPublique.setBounds(586, 247, 141, 23);
		frame.getContentPane().add(rdbtnPublique);
		
		lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMotDePasse.setHorizontalAlignment(SwingConstants.CENTER);
		lblMotDePasse.setBounds(466, 282, 367, 16);
		frame.getContentPane().add(lblMotDePasse);
		lblMotDePasse.setEnabled(false);
		
		
		lblConfirmationMotDe = new JLabel("Confirmation mot de passe");
		lblConfirmationMotDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmationMotDe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblConfirmationMotDe.setBounds(466, 351, 367, 16);
		frame.getContentPane().add(lblConfirmationMotDe);
		lblConfirmationMotDe.setEnabled(false);
		
		JLabel labelPresentation = new JLabel("Création de partie");
		labelPresentation.setHorizontalAlignment(SwingConstants.CENTER);
		labelPresentation.setForeground(Color.LIGHT_GRAY);
		labelPresentation.setFont(new Font("Tahoma", Font.BOLD, 40));
		labelPresentation.setBounds(426, 65, 446, 83);
		frame.getContentPane().add(labelPresentation);
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

	public JLabel getLblMotDePasse() {
		return lblMotDePasse;
	}

	public void setLblMotDePasse(JLabel lblMotDePasse) {
		this.lblMotDePasse = lblMotDePasse;
	}

	public JLabel getLblConfirmationMotDe() {
		return lblConfirmationMotDe;
	}

	public void setLblConfirmationMotDe(JLabel lblConfirmationMotDe) {
		this.lblConfirmationMotDe = lblConfirmationMotDe;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
