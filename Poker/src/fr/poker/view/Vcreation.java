package fr.poker.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import fr.poker.controller.Ccreation;

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
/*	private JTextField txtRoomName;
	private JMenu mnGameMode;
	private JButton btnTournament;
	private JButton btnClassic;
	private JMenu mnRoomType;
	private JButton btnPublic;
	private JButton btnPrivate;
	private JPasswordField passwordRoom;
	private JLabel label;
	private JPasswordField passwordField;
	private JTextField textField;*/
	private JPasswordField pwdSalle;
	private JPasswordField pwdSalleConfirm;
	private JTextField txtNameSalle;
	private JButton btnBack;
	private JButton btnCreationSalle;
	private JLabel lblMotDePasse;
	private JLabel lblConfirmationMotDe;

	/**
	 * Launch the application.
	 */
	/*
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vcreation window = new Vcreation();
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
	/*
	public Vcreation() {
		initialize();
	}*/

	/**
	 * Initialize the contents of the frame.
	 */
	
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
		pwdSalle.setBounds(466, 285, 367, 51);
		pwdSalle.setText("Mot de passe");
		pwdSalle.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pwdSalle.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(pwdSalle);
		pwdSalle.setVisible(false);
		
		pwdSalleConfirm = new JPasswordField();
		pwdSalleConfirm.setBounds(466, 367, 367, 51);
		pwdSalleConfirm.setText("Confirmer   ");
		pwdSalleConfirm.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pwdSalleConfirm.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(pwdSalleConfirm);
		pwdSalleConfirm.setVisible(false);
		
		this.btnCreationSalle = new JButton("Créer la salle");
		btnCreationSalle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCreationSalle.setBounds(466, 430, 367, 51);
		btnCreationSalle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(btnCreationSalle);

		
		this.btnBack = new JButton("Retour");
		btnBack.setBounds(467, 482, 366, 51);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(btnBack);
		
		JRadioButton rdbtnPrivate = new JRadioButton("Privée");
		rdbtnPrivate.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnPrivate.setBounds(476, 211, 141, 23);
		frame.getContentPane().add(rdbtnPrivate);
		
		JRadioButton rdbtnPublique = new JRadioButton("Publique");
		rdbtnPublique.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnPublique.setBounds(692, 211, 141, 23);
		frame.getContentPane().add(rdbtnPublique);
		
		lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMotDePasse.setHorizontalAlignment(SwingConstants.CENTER);
		lblMotDePasse.setBounds(466, 270, 367, 16);
		frame.getContentPane().add(lblMotDePasse);
		lblMotDePasse.setVisible(false);
		
		
		lblConfirmationMotDe = new JLabel("Confirmation mot de passe");
		lblConfirmationMotDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmationMotDe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblConfirmationMotDe.setBounds(466, 351, 367, 16);
		frame.getContentPane().add(lblConfirmationMotDe);
		lblConfirmationMotDe.setVisible(false);
		
		JLabel labelPresentation = new JLabel("Création de partie");
		labelPresentation.setHorizontalAlignment(SwingConstants.CENTER);
		labelPresentation.setForeground(Color.LIGHT_GRAY);
		labelPresentation.setFont(new Font("Tahoma", Font.BOLD, 40));
		labelPresentation.setBounds(426, 65, 446, 83);
		frame.getContentPane().add(labelPresentation);
		frame.setBounds(100, 100, 1300, 800);

		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
/*		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(39, 78, 19));
		frame.getContentPane().setLayout(null);
		
		JLabel lblSlogan = new JLabel("World Of Online Poker");
		lblSlogan.setHorizontalAlignment(SwingConstants.CENTER);
		lblSlogan.setForeground(Color.LIGHT_GRAY);
		lblSlogan.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblSlogan.setBounds(504, 100, 234, 63);
		frame.getContentPane().add(lblSlogan);
		
		JLabel lblCreate = new JLabel("Cr\u00E9ation de partie");
		lblCreate.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreate.setForeground(Color.LIGHT_GRAY);
		lblCreate.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblCreate.setBounds(385, 42, 466, 63);
		frame.getContentPane().add(lblCreate);
		
		txtRoomName = new JTextField();
		txtRoomName.setForeground(Color.GRAY);
		txtRoomName.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtRoomName.setText("Nom de la salle");
		txtRoomName.setBounds(424, 172, 401, 63);
		frame.getContentPane().add(txtRoomName);
		txtRoomName.setColumns(10);
		
		mnGameMode = new JMenu("Mode de jeu");
		mnGameMode.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnGameMode.setBounds(424, 269, 196, 32);
		frame.getContentPane().add(mnGameMode);
		
		btnClassic = new JButton("Classique");
		mnGameMode.add(btnClassic);
		
		btnTournament = new JButton("Tournoi");
		mnGameMode.add(btnTournament);
		
		mnRoomType = new JMenu("Type de salle");
		mnRoomType.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnRoomType.setBounds(424, 337, 196, 32);
		frame.getContentPane().add(mnRoomType);
		
		btnPublic = new JButton("Publique");
		mnRoomType.add(btnPublic);
		
		btnPrivate = new JButton("Priv\u00E9e");
		mnRoomType.add(btnPrivate);
		
		passwordRoom = new JPasswordField();
		passwordRoom.setHorizontalAlignment(SwingConstants.LEFT);
		passwordRoom.setBounds(424, 401, 401, 41);
		frame.getContentPane().add(passwordRoom);
		
		JButton btnCreate = new JButton("Cr\u00E9er la salle");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCreate.setBounds(424, 518, 401, 52);
		frame.getContentPane().add(btnCreate);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Vcreation.class.getResource("/fr/poker/view/pictures/logo.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(240, 16, 160, 154);
		frame.getContentPane().add(label);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField.setBounds(424, 454, 401, 41);
		frame.getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setText("Nom");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setColumns(10);
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(364, 581, 176, 51);
		frame.getContentPane().add(textField);
		frame.setBounds(100, 100, 1300, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
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
