package fr.poker.view;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.io.*; 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;

import javax.swing.SwingConstants;

import fr.poker.controller.Cclient;
import fr.poker.controller.Cpartie;
import fr.poker.controller.listener.CjeuListener;
import fr.poker.controller.listener.JButtonListenerCheck;
import fr.poker.controller.listener.JButtonListenerClient;
import fr.poker.controller.listener.JButtonListenerMiser;
import fr.poker.controller.listener.JButtonListenerSeCoucher;
import fr.poker.controller.listener.JButtonListenerSuivre;
import fr.poker.model.chat.Serveur.Reception;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;

public class VjeuClient implements Observer{

	public static JFrame frame;
	public static JTextField textFieldMise;
	public static JTextField textFieldChat;
	public static JPanel panelChat;
	public static String messageRecu;
	public static String mise;
	public static JLabel label;
	public JButton btnEnvoyer;
	public JButton btnMiser;
	public JButton btnSuivre;
	public JButton btnCheck;
	public JButton btnSeCoucher;
	public static JLayeredPane LayerChat = new JLayeredPane();
	static JLayeredPane Background = new JLayeredPane();
	static JLabel lblBackground = new JLabel("");
	private JLabel [] imagesJoueurs;
	private JLabel [] pseudosJoueurs;
	private JLabel [] misesJoueurs;
	private JLabel [] potsJoueurs;
	private JLabel lblValeurPotTotal;
	private JLabel lblNotifications;

	public JLabel[] getImagesJoueurs() {
		return imagesJoueurs;
	}

	public void setImagesJoueurs(JLabel[] imagesJoueurs) {
		this.imagesJoueurs = imagesJoueurs;
	}

	public JLabel[] getPseudosJoueurs() {
		return pseudosJoueurs;
	}

	public void setPseudosJoueurs(JLabel[] pseudosJoueurs) {
		this.pseudosJoueurs = pseudosJoueurs;
	}

	public JLabel[] getMisesJoueurs() {
		return misesJoueurs;
	}

	public void setMisesJoueurs(JLabel[] misesJoueurs) {
		this.misesJoueurs = misesJoueurs;
	}

	public JLabel[] getPotsJoueurs() {
		return potsJoueurs;
	}

	public void setPotsJoueurs(JLabel[] potsJoueurs) {
		this.potsJoueurs = potsJoueurs;
	}

	public JLabel getLblNotifications() {
		return lblNotifications;
	}

	public void setLblNotifications(JLabel lblNotifications) {
		this.lblNotifications = lblNotifications;
	}

	/**
	 * Create the application.
	 */
	public VjeuClient(Cclient c) {
		//this.messageRecu=message;
		initialize(c);	
	}

/*	public Vjeu(String message) {
		this.messageRecu=message;
		initialize(c);	
	}*/
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Cclient c) {
		

		System.out.println("Début de l'affichage");
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1300, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblChat = new JLabel("Chat");
		lblChat.setHorizontalAlignment(SwingConstants.CENTER);
		lblChat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChat.setForeground(Color.LIGHT_GRAY);
		lblChat.setBounds(33, 563, 73, 19);
		frame.getContentPane().add(lblChat);
		// Modif
		//lblChat.setText("mdrrr!!!!!!test");
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Vparametres.class.getResource("/fr/poker/view/pictures/logo.png")));
		lblLogo.setBounds(10, 11, 127, 121);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblLogo);
		
		JLabel lblTitle = new JLabel("WOOP");
		lblTitle.setBounds(124, 24, 168, 63);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(0, 0, 0));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 35));
		frame.getContentPane().add(lblTitle);
		
		JLabel lblSlogan = new JLabel("World Of Online Poker");
		lblSlogan.setBounds(120, 56, 185, 63);
		lblSlogan.setBackground(new Color(0, 0, 0));
		lblSlogan.setHorizontalAlignment(SwingConstants.CENTER);
		lblSlogan.setForeground(new Color(0, 0, 0));
		lblSlogan.setFont(new Font("Tahoma", Font.ITALIC, 12));
		frame.getContentPane().add(lblSlogan);
			
		JLabel lblMyProfil = new JLabel("Mon Profil");
		lblMyProfil.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyProfil.setForeground(Color.LIGHT_GRAY);
		lblMyProfil.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMyProfil.setBounds(1124, 569, 134, 30);
		frame.getContentPane().add(lblMyProfil);
		
		JLabel lblPotTotal = new JLabel("PotTotal");
		lblPotTotal.setBounds(595, 167, 88, 14);
		lblPotTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPotTotal.setForeground(new Color(128, 0, 0));
		lblPotTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(lblPotTotal);
		
		lblValeurPotTotal = new JLabel("...");
		lblValeurPotTotal.setSize(88, 14);
		lblValeurPotTotal.setLocation(595, 185);
		lblValeurPotTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblValeurPotTotal.setForeground(new Color(128, 0, 0));
		lblValeurPotTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblValeurPotTotal.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(lblValeurPotTotal);
		
		lblNotifications = new JLabel("...");
		lblNotifications.setSize(390, 30);
		lblNotifications.setLocation(450, 25);
		lblNotifications.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotifications.setForeground(new Color(128, 0, 0));
		lblNotifications.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNotifications.setBackground(new Color(255, 255, 255));
		lblNotifications.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		frame.getContentPane().add(lblNotifications);
		
		JLabel lblJ1 = new JLabel("");
		lblJ1.setIcon(new ImageIcon(VjeuClient.class.getResource("/fr/poker/view/pictures/avatar/Avatar1.png")));
		lblJ1.setBounds(355, 48, 64, 70);
		frame.getContentPane().add(lblJ1);
		lblJ1.setVisible(false);
		
		JLabel lblJ2 = new JLabel("");
		lblJ2.setIcon(new ImageIcon(VjeuClient.class.getResource("/fr/poker/view/pictures/avatar/Avatar2.png")));
		lblJ2.setBounds(195, 220, 64, 70);
		frame.getContentPane().add(lblJ2);
		lblJ2.setVisible(false);
		
		JLabel lblJ3 = new JLabel("");
		lblJ3.setIcon(new ImageIcon(VjeuClient.class.getResource("/fr/poker/view/pictures/avatar/Avatar3.png")));
		lblJ3.setBounds(361, 438, 64, 70);
		frame.getContentPane().add(lblJ3);
		lblJ3.setVisible(false);
		
		JLabel lblJ4 = new JLabel("");
		lblJ4.setIcon(new ImageIcon(VjeuClient.class.getResource("/fr/poker/view/pictures/avatar/Avatar4.png")));
		lblJ4.setBounds(606, 442, 64, 70);
		frame.getContentPane().add(lblJ4);
		lblJ4.setVisible(false);
		
		JLabel lblJ5 = new JLabel("");
		lblJ5.setIcon(new ImageIcon(VjeuClient.class.getResource("/fr/poker/view/pictures/avatar/Avatar5.png")));
		lblJ5.setBounds(878, 440, 64, 70);
		frame.getContentPane().add(lblJ5);
		lblJ5.setVisible(false);
		
		JLabel lblJ6 = new JLabel("");
		lblJ6.setIcon(new ImageIcon(VjeuClient.class.getResource("/fr/poker/view/pictures/avatar/Avatar6.png")));
		lblJ6.setBounds(1064, 220, 64, 70);
		frame.getContentPane().add(lblJ6);
		lblJ6.setVisible(false);
		
		JLabel lblJ7 = new JLabel("");
		lblJ7.setIcon(new ImageIcon(VjeuClient.class.getResource("/fr/poker/view/pictures/avatar/Avatar7.png")));
		lblJ7.setBounds(873, 48, 64, 70);
		frame.getContentPane().add(lblJ7);
		lblJ7.setVisible(false);
		
		JLabel lblJ1C1 = new JLabel("");
		lblJ1C1.setIcon(new ImageIcon(VjeuClient.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblJ1C1.setBounds(424, 82, 64, 70);
		frame.getContentPane().add(lblJ1C1);
		lblJ1C1.setVisible(false);
		
		JLabel lblJ1C2 = new JLabel("");
		lblJ1C2.setIcon(new ImageIcon(VjeuClient.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblJ1C2.setBounds(475, 82, 64, 70);
		frame.getContentPane().add(lblJ1C2);
		lblJ1C2.setVisible(false);
		
		JLabel lblJ2C2 = new JLabel("");
		lblJ2C2.setIcon(new ImageIcon(VjeuClient.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblJ2C2.setBounds(320, 235, 64, 70);
		frame.getContentPane().add(lblJ2C2);
		lblJ2C2.setVisible(false);
		
		JLabel lblJ2C1 = new JLabel("");
		lblJ2C1.setIcon(new ImageIcon(VjeuClient.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblJ2C1.setBounds(269, 235, 64, 70);
		frame.getContentPane().add(lblJ2C1);
		lblJ2C1.setVisible(false);
		
		JLabel lblJ3C2 = new JLabel("");
		lblJ3C2.setIcon(new ImageIcon(VjeuClient.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblJ3C2.setBounds(475, 398, 64, 70);
		frame.getContentPane().add(lblJ3C2);
		lblJ3C2.setVisible(false);
		
		JLabel lblJ3C1 = new JLabel("");
		lblJ3C1.setIcon(new ImageIcon(VjeuClient.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblJ3C1.setBounds(424, 398, 64, 70);
		frame.getContentPane().add(lblJ3C1);
		lblJ3C1.setVisible(false);
		
		JLabel lblJ4C2 = new JLabel("");
		lblJ4C2.setIcon(new ImageIcon(VjeuClient.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblJ4C2.setBounds(634, 348, 64, 70);
		frame.getContentPane().add(lblJ4C2);
		lblJ4C2.setVisible(false);
		
		JLabel lblJ4C1 = new JLabel("");
		lblJ4C1.setIcon(new ImageIcon(VjeuClient.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblJ4C1.setBounds(583, 348, 64, 70);
		frame.getContentPane().add(lblJ4C1);
		lblJ4C1.setVisible(false);
		
		JLabel lblJ5C2 = new JLabel("");
		lblJ5C2.setIcon(new ImageIcon(VjeuClient.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblJ5C2.setBounds(811, 398, 64, 70);
		frame.getContentPane().add(lblJ5C2);
		lblJ5C2.setVisible(false);
		
		JLabel lblJ5C1 = new JLabel("");
		lblJ5C1.setIcon(new ImageIcon(VjeuClient.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblJ5C1.setBounds(760, 398, 64, 70);
		frame.getContentPane().add(lblJ5C1);
		lblJ5C1.setVisible(false);
		
		JLabel lblJ6C2 = new JLabel("");
		lblJ6C2.setIcon(new ImageIcon(VjeuClient.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblJ6C2.setBounds(979, 235, 64, 70);
		frame.getContentPane().add(lblJ6C2);
		lblJ6C2.setVisible(false);
		
		JLabel lblJ6C1 = new JLabel("");
		lblJ6C1.setIcon(new ImageIcon(VjeuClient.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblJ6C1.setBounds(928, 235, 64, 70);
		frame.getContentPane().add(lblJ6C1);
		lblJ6C1.setVisible(false);
		
		JLabel lblJ7C1 = new JLabel("");
		lblJ7C1.setIcon(new ImageIcon(VjeuClient.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblJ7C1.setBounds(760, 82, 64, 70);
		frame.getContentPane().add(lblJ7C1);
		lblJ7C1.setVisible(false);
		
		JLabel lblJ7C2 = new JLabel("");
		lblJ7C2.setIcon(new ImageIcon(VjeuClient.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblJ7C2.setBounds(811, 82, 64, 70);
		frame.getContentPane().add(lblJ7C2);
		lblJ7C2.setVisible(false);
		
		JLabel lblC1 = new JLabel("");
		lblC1.setIcon(new ImageIcon(VjeuClient.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblC1.setBounds(474, 235, 64, 70);
		frame.getContentPane().add(lblC1);
		
		JLabel lblC2 = new JLabel("");
		lblC2.setIcon(new ImageIcon(VjeuClient.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblC2.setBounds(540, 235, 64, 70);
		frame.getContentPane().add(lblC2);
		
		JLabel lblC3 = new JLabel("");
		lblC3.setIcon(new ImageIcon(VjeuClient.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblC3.setBounds(606, 235, 64, 70);
		frame.getContentPane().add(lblC3);
		
		JLabel lblC4 = new JLabel("");
		lblC4.setIcon(new ImageIcon(VjeuClient.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblC4.setBounds(672, 235, 64, 70);
		frame.getContentPane().add(lblC4);
		
		JLabel lblC5 = new JLabel("");
		lblC5.setIcon(new ImageIcon(VjeuClient.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblC5.setBounds(738, 235, 64, 70);
		frame.getContentPane().add(lblC5);
		
		JLabel lblMJ = new JLabel("");
		lblMJ.setIcon(new ImageIcon(VjeuClient.class.getResource("/fr/poker/view/pictures/avatar/Avatar1.png")));
		lblMJ.setBounds(1183, 610, 64, 70);
		frame.getContentPane().add(lblMJ);
		
		JLabel lblMC1 = new JLabel("");
		lblMC1.setIcon(new ImageIcon(VjeuClient.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblMC1.setBounds(1210, 680, 64, 70);
		frame.getContentPane().add(lblMC1);
		
		JLabel lblMC2 = new JLabel("");
		lblMC2.setIcon(new ImageIcon(VjeuClient.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblMC2.setBounds(1159, 680, 64, 70);
		frame.getContentPane().add(lblMC2);
		
		JLabel lblNameJ1 = new JLabel("");
		lblNameJ1.setBackground(Color.LIGHT_GRAY);
		lblNameJ1.setForeground(new Color(128, 0, 0));
		lblNameJ1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNameJ1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameJ1.setBounds(360, 11, 59, 14);
		frame.getContentPane().add(lblNameJ1);
		lblNameJ1.setVisible(false);
		
		JLabel lblNameJ2 = new JLabel("");
		lblNameJ2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameJ2.setForeground(new Color(128, 0, 0));
		lblNameJ2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNameJ2.setBackground(Color.LIGHT_GRAY);
		lblNameJ2.setBounds(126, 235, 59, 14);
		frame.getContentPane().add(lblNameJ2);
		lblNameJ2.setVisible(false);
		
		JLabel lblNameJ3 = new JLabel("");
		lblNameJ3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameJ3.setForeground(new Color(128, 0, 0));
		lblNameJ3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNameJ3.setBackground(Color.LIGHT_GRAY);
		lblNameJ3.setBounds(365, 507, 59, 14);
		frame.getContentPane().add(lblNameJ3);
		lblNameJ3.setVisible(false);
		
		JLabel lblNameJ4 = new JLabel("");
		lblNameJ4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameJ4.setForeground(new Color(128, 0, 0));
		lblNameJ4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNameJ4.setBackground(Color.LIGHT_GRAY);
		lblNameJ4.setBounds(611, 512, 59, 14);
		frame.getContentPane().add(lblNameJ4);
		lblNameJ4.setVisible(false);
		
		JLabel lblNameJ5 = new JLabel("");
		lblNameJ5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameJ5.setForeground(new Color(128, 0, 0));
		lblNameJ5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNameJ5.setBackground(Color.LIGHT_GRAY);
		lblNameJ5.setBounds(880, 510, 59, 14);
		frame.getContentPane().add(lblNameJ5);
		lblNameJ5.setVisible(false);
		
		JLabel lblNameJ6 = new JLabel("");
		lblNameJ6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameJ6.setForeground(new Color(128, 0, 0));
		lblNameJ6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNameJ6.setBackground(Color.LIGHT_GRAY);
		lblNameJ6.setBounds(1133, 235, 59, 14);
		frame.getContentPane().add(lblNameJ6);
		lblNameJ6.setVisible(false);
		
		JLabel lblNameJ7 = new JLabel("");
		lblNameJ7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameJ7.setForeground(new Color(128, 0, 0));
		lblNameJ7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNameJ7.setBackground(Color.LIGHT_GRAY);
		lblNameJ7.setBounds(878, 11, 59, 14);
		frame.getContentPane().add(lblNameJ7);
		lblNameJ7.setVisible(false);
		
		JLabel lblMiseJ1 = new JLabel("");
		lblMiseJ1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMiseJ1.setForeground(new Color(128, 0, 0));
		lblMiseJ1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMiseJ1.setBackground(Color.LIGHT_GRAY);
		lblMiseJ1.setBounds(359, 29, 59, 14);
		frame.getContentPane().add(lblMiseJ1);
		lblMiseJ1.setVisible(false);
		
		JLabel lblMiseJ2 = new JLabel("");
		lblMiseJ2.setHorizontalAlignment(SwingConstants.CENTER);
		lblMiseJ2.setForeground(new Color(128, 0, 0));
		lblMiseJ2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMiseJ2.setBackground(Color.LIGHT_GRAY);
		lblMiseJ2.setBounds(126, 253, 59, 14);
		frame.getContentPane().add(lblMiseJ2);
		lblMiseJ2.setVisible(false);
		
		
		JLabel lblMiseJ3 = new JLabel("");
		lblMiseJ3.setHorizontalAlignment(SwingConstants.CENTER);
		lblMiseJ3.setForeground(new Color(128, 0, 0));
		lblMiseJ3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMiseJ3.setBackground(Color.LIGHT_GRAY);
		lblMiseJ3.setBounds(366, 525, 59, 14);
		frame.getContentPane().add(lblMiseJ3);
		lblMiseJ3.setVisible(false);
		
		JLabel lblMiseJ4 = new JLabel("");
		lblMiseJ4.setHorizontalAlignment(SwingConstants.CENTER);
		lblMiseJ4.setForeground(new Color(128, 0, 0));
		lblMiseJ4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMiseJ4.setBackground(Color.LIGHT_GRAY);
		lblMiseJ4.setBounds(612, 530, 59, 14);
		frame.getContentPane().add(lblMiseJ4);
		lblMiseJ4.setVisible(false);
		
		JLabel lblMiseJ5 = new JLabel("");
		lblMiseJ5.setHorizontalAlignment(SwingConstants.CENTER);
		lblMiseJ5.setForeground(new Color(128, 0, 0));
		lblMiseJ5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMiseJ5.setBackground(Color.LIGHT_GRAY);
		lblMiseJ5.setBounds(882, 529, 59, 14);
		frame.getContentPane().add(lblMiseJ5);
		lblMiseJ5.setVisible(false);
		
		JLabel lblMiseJ6 = new JLabel("");
		lblMiseJ6.setHorizontalAlignment(SwingConstants.CENTER);
		lblMiseJ6.setForeground(new Color(128, 0, 0));
		lblMiseJ6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMiseJ6.setBackground(Color.LIGHT_GRAY);
		lblMiseJ6.setBounds(1135, 253, 59, 14);
		frame.getContentPane().add(lblMiseJ6);
		lblMiseJ6.setVisible(false);
		
		JLabel lblMiseJ7 = new JLabel("");
		lblMiseJ7.setHorizontalAlignment(SwingConstants.CENTER);
		lblMiseJ7.setForeground(new Color(128, 0, 0));
		lblMiseJ7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMiseJ7.setBackground(Color.LIGHT_GRAY);
		lblMiseJ7.setBounds(879, 29, 59, 14);
		frame.getContentPane().add(lblMiseJ7);
		lblMiseJ7.setVisible(false);
		
		JLabel lblPlayerName = new JLabel(c.j.getPseudo());
		lblPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerName.setForeground(Color.WHITE);
		lblPlayerName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPlayerName.setBackground(Color.LIGHT_GRAY);
		lblPlayerName.setBounds(1039, 632, 134, 14);
		frame.getContentPane().add(lblPlayerName);
		
		JLabel lblPotJoueur = new JLabel("PotJoueur");
		lblPotJoueur.setHorizontalAlignment(SwingConstants.CENTER);
		lblPotJoueur.setForeground(Color.WHITE);
		lblPotJoueur.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPotJoueur.setBackground(Color.LIGHT_GRAY);
		lblPotJoueur.setBounds(1057, 681, 89, 14);
		frame.getContentPane().add(lblPotJoueur);
		
		//INITIALISATION DES TABLEAUX
		////////////////////////////////////////////////////////////////////////////////////////
		JLabel[] tabImages = {lblJ1, lblJ2, lblJ3, lblJ4, lblJ5, lblJ6, lblJ7};
		imagesJoueurs = tabImages;
		JLabel[] tabPseudos = {lblNameJ1, lblNameJ2, lblNameJ3, lblNameJ4, lblNameJ5, lblNameJ6, lblNameJ7};
		pseudosJoueurs = tabPseudos;
		JLabel[] tabMises = {lblMiseJ1, lblMiseJ2, lblMiseJ3, lblMiseJ4, lblMiseJ5, lblMiseJ6, lblMiseJ7};
		misesJoueurs = tabMises;
		JLabel[] tabPotJoueurs = {};
		potsJoueurs = tabPotJoueurs;
		
		////////////////////////////////////////////////////////////////////////////////////////
		
		textFieldMise = new JTextField();
		textFieldMise.setBounds(430, 729, 108, 28);
		frame.getContentPane().add(textFieldMise);
		textFieldMise.setColumns(10);
		textFieldMise.setText("0.0");
		////////////////////////////////////////////////////////////////////////////////////////
		//ICI
		textFieldChat = new JTextField();
		textFieldChat.setBounds(7, 724, 305, 33);
		frame.getContentPane().add(textFieldChat);
		textFieldChat.setColumns(10);
		textFieldChat.setText("Je suis dans la zone ou j'écris");
		
		
		///////////////////////////////////////////////////////////////////////////////////// ICI
		
		
		//LES BOUTONS
		/////////////////////////////////////////////////////////////////////////////////////
		btnEnvoyer = new JButton("Envoyer");
		btnEnvoyer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEnvoyer.setBounds(319, 730, 89, 23);
		frame.getContentPane().add(btnEnvoyer);
		btnEnvoyer.addActionListener(new CjeuListener());
		//btnEnvoyer.addActionListener(new JButtonListenerJeu());
		
		btnMiser = new JButton("Miser");
		btnMiser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnMiser.setBounds(548, 729, 103, 28);
		frame.getContentPane().add(btnMiser);
		btnMiser.addActionListener(new JButtonListenerClient(c));
		
		btnSuivre = new JButton("Suivre");
		btnSuivre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSuivre.setBounds(661, 729, 103, 28);
		frame.getContentPane().add(btnSuivre);
		btnSuivre.addActionListener(new JButtonListenerClient(c));
		
		btnCheck = new JButton("Check");
		btnCheck.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCheck.setBounds(774, 729, 101, 28);
		frame.getContentPane().add(btnCheck);
		btnCheck.addActionListener(new JButtonListenerClient(c));
		
		btnSeCoucher = new JButton("Se coucher");
		btnSeCoucher.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSeCoucher.setBounds(885, 729, 127, 28);
		frame.getContentPane().add(btnSeCoucher);
		btnSeCoucher.addActionListener(new JButtonListenerClient(c));
		
		//ICI///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		
		

		
		LayerChat.setBounds(0,0,1300,800);
	//LayerChat.setBounds(7, 608, 391, 110);
	

		
		
		Background.setBounds(0, 0, 1284, 761);
		
		lblBackground.setIcon(new ImageIcon(VjeuClient.class.getResource("/fr/poker/view/pictures/background.png")));
		lblBackground.setBounds(0, 0, 1284, 761);
		
		LayerChat.add(lblBackground);
		Background.setLayer(lblBackground, 0);
		
		frame.getContentPane().add(LayerChat);
		//
		showPanel(LayerChat);				
		
	}

	public JLabel getLblValeurPotTotal() {
		return lblValeurPotTotal;
	}

	public void setLblValeurPotTotal(JLabel lblValeurPotTotal) {
		this.lblValeurPotTotal = lblValeurPotTotal;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JButton getBtnEnvoyer() {
		return btnEnvoyer;
	}

	public void setBtnEnvoyer(JButton btnEnvoyer) {
		this.btnEnvoyer = btnEnvoyer;
	}

	public JButton getBtnMiser() {
		return btnMiser;
	}

	public void setBtnMiser(JButton btnMiser) {
		this.btnMiser = btnMiser;
	}

	public JButton getBtnSuivre() {
		return btnSuivre;
	}

	public void setBtnSuivre(JButton btnSuivre) {
		this.btnSuivre = btnSuivre;
	}

	public JButton getBtnCheck() {
		return btnCheck;
	}

	public void setBtnCheck(JButton btnCheck) {
		this.btnCheck = btnCheck;
	}

	public JButton getBtnSeCoucher() {
		return btnSeCoucher;
	}

	public void setBtnSeCoucher(JButton btnSeCoucher) {
		this.btnSeCoucher = btnSeCoucher;
	}
	
	public static void showPanel(JLayeredPane LayerChat){
		Boolean state = true;
		JPanel panelChat = new JPanel();
		panelChat.setBackground(Color.WHITE);
		
		panelChat.setBounds(7, 608, 391, 110);
		System.out.println("On lance la boucle");
		JTextField monTexte = new JTextField("test affichage");
		panelChat.add(monTexte);
		LayerChat.add(panelChat);
		LayerChat.setLayer(panelChat, 1);
		//
		frame.getContentPane().add(LayerChat);
		frame.setVisible(true);
		//Vjeu.showPanel(frame);
		System.out.println("Affichage du panel");	
	}
	
	public static void actualiser(JLayeredPane LayerChat,ArrayList<String> monArrayListe){
		System.out.println("Je suis dans actualiser");
		LayerChat.removeAll();
		System.out.println("J'ai tout supprimé");
		System.out.println("Je crée ma liste c'est bon");
		LayerChat.setBounds(0,0,1300,800);
		LayerChat.add(lblBackground);
		Background.setLayer(lblBackground, 0);
		System.out.println("Le background est ok");
		frame.getContentPane().add(LayerChat);
		JPanel panelChat = new JPanel();
		System.out.println("Je viens de créer panel chat");
		panelChat.setBackground(Color.WHITE);
		panelChat.setBounds(7, 608, 391, 110);
		//Ja vais construire mon texte
		System.out.println("J'ai bien récupéré ma liste");
		for(String elem: monArrayListe)
	       {
			System.out.println ("Je suis dans ma boucle");
			JTextField monTexte = new JTextField(elem);	       	 
	       	panelChat.add(monTexte);
	       }
		
		//JTextField monTexte = new JTextField("test actualisation");
		System.out.println ("Je viens de sortir de ma boucle");
		LayerChat.add(panelChat);
		LayerChat.setLayer(panelChat, 1);
		frame.getContentPane().add(LayerChat);
		frame.setVisible(true);
		LayerChat.revalidate();
		LayerChat.repaint();	
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
