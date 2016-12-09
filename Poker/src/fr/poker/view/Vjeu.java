package fr.poker.view;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import fr.poker.controller.listener.CconnexionListener;
import fr.poker.controller.listener.CjeuListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Vjeu{

	public JFrame frame;
	private JTextField textFieldMise;
	public static JTextField textFieldChat;
	public static JPanel panelChat;
	public static String messageRecu;
	public static JLabel label;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vjeu window = new Vjeu("message parametre");
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
	public Vjeu(String message) {
		this.messageRecu=message;
		initialize();	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		
		JLabel lblMyProfil = new JLabel("Mon Profil");
		lblMyProfil.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyProfil.setForeground(Color.LIGHT_GRAY);
		lblMyProfil.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMyProfil.setBounds(1124, 569, 134, 30);
		frame.getContentPane().add(lblMyProfil);
		
		JLabel lblJ1 = new JLabel("");
		lblJ1.setIcon(new ImageIcon(Vjeu.class.getResource("/fr/poker/view/pictures/avatar/Avatar1.png")));
		lblJ1.setBounds(355, 48, 64, 70);
		frame.getContentPane().add(lblJ1);
		
		JLabel lblJ2 = new JLabel("");
		lblJ2.setIcon(new ImageIcon(Vjeu.class.getResource("/fr/poker/view/pictures/avatar/Avatar2.png")));
		lblJ2.setBounds(195, 220, 64, 70);
		frame.getContentPane().add(lblJ2);
		
		JLabel lblJ3 = new JLabel("");
		lblJ3.setIcon(new ImageIcon(Vjeu.class.getResource("/fr/poker/view/pictures/avatar/Avatar3.png")));
		lblJ3.setBounds(361, 438, 64, 70);
		frame.getContentPane().add(lblJ3);
		
		JLabel lblJ4 = new JLabel("");
		lblJ4.setIcon(new ImageIcon(Vjeu.class.getResource("/fr/poker/view/pictures/avatar/Avatar4.png")));
		lblJ4.setBounds(606, 442, 64, 70);
		frame.getContentPane().add(lblJ4);
		
		JLabel lblJ5 = new JLabel("");
		lblJ5.setIcon(new ImageIcon(Vjeu.class.getResource("/fr/poker/view/pictures/avatar/Avatar5.png")));
		lblJ5.setBounds(878, 440, 64, 70);
		frame.getContentPane().add(lblJ5);
		
		JLabel lblJ6 = new JLabel("");
		lblJ6.setIcon(new ImageIcon(Vjeu.class.getResource("/fr/poker/view/pictures/avatar/Avatar6.png")));
		lblJ6.setBounds(1064, 220, 64, 70);
		frame.getContentPane().add(lblJ6);
		
		JLabel lblJ7 = new JLabel("");
		lblJ7.setIcon(new ImageIcon(Vjeu.class.getResource("/fr/poker/view/pictures/avatar/Avatar7.png")));
		lblJ7.setBounds(873, 48, 64, 70);
		frame.getContentPane().add(lblJ7);
		
		JLabel lblJ1C1 = new JLabel("");
		lblJ1C1.setIcon(new ImageIcon(Vjeu.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblJ1C1.setBounds(424, 82, 64, 70);
		frame.getContentPane().add(lblJ1C1);
		
		JLabel lblJ1C2 = new JLabel("");
		lblJ1C2.setIcon(new ImageIcon(Vjeu.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblJ1C2.setBounds(475, 82, 64, 70);
		frame.getContentPane().add(lblJ1C2);
		
		JLabel lblJ2C2 = new JLabel("");
		lblJ2C2.setIcon(new ImageIcon(Vjeu.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblJ2C2.setBounds(320, 235, 64, 70);
		frame.getContentPane().add(lblJ2C2);
		
		JLabel lblJ2C1 = new JLabel("");
		lblJ2C1.setIcon(new ImageIcon(Vjeu.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblJ2C1.setBounds(269, 235, 64, 70);
		frame.getContentPane().add(lblJ2C1);
		
		JLabel lblJ3C2 = new JLabel("");
		lblJ3C2.setIcon(new ImageIcon(Vjeu.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblJ3C2.setBounds(475, 398, 64, 70);
		frame.getContentPane().add(lblJ3C2);
		
		JLabel lblJ3C1 = new JLabel("");
		lblJ3C1.setIcon(new ImageIcon(Vjeu.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblJ3C1.setBounds(424, 398, 64, 70);
		frame.getContentPane().add(lblJ3C1);
		
		JLabel lblJ4C2 = new JLabel("");
		lblJ4C2.setIcon(new ImageIcon(Vjeu.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblJ4C2.setBounds(634, 348, 64, 70);
		frame.getContentPane().add(lblJ4C2);
		
		JLabel lblJ4C1 = new JLabel("");
		lblJ4C1.setIcon(new ImageIcon(Vjeu.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblJ4C1.setBounds(583, 348, 64, 70);
		frame.getContentPane().add(lblJ4C1);
		
		JLabel lblJ5C2 = new JLabel("");
		lblJ5C2.setIcon(new ImageIcon(Vjeu.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblJ5C2.setBounds(811, 398, 64, 70);
		frame.getContentPane().add(lblJ5C2);
		
		JLabel lblJ5C1 = new JLabel("");
		lblJ5C1.setIcon(new ImageIcon(Vjeu.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblJ5C1.setBounds(760, 398, 64, 70);
		frame.getContentPane().add(lblJ5C1);
		
		JLabel lblJ6C2 = new JLabel("");
		lblJ6C2.setIcon(new ImageIcon(Vjeu.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblJ6C2.setBounds(979, 235, 64, 70);
		frame.getContentPane().add(lblJ6C2);
		
		JLabel lblJ6C1 = new JLabel("");
		lblJ6C1.setIcon(new ImageIcon(Vjeu.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblJ6C1.setBounds(928, 235, 64, 70);
		frame.getContentPane().add(lblJ6C1);
		
		JLabel lblJ7C1 = new JLabel("");
		lblJ7C1.setIcon(new ImageIcon(Vjeu.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblJ7C1.setBounds(760, 82, 64, 70);
		frame.getContentPane().add(lblJ7C1);
		
		JLabel lblJ7C2 = new JLabel("");
		lblJ7C2.setIcon(new ImageIcon(Vjeu.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblJ7C2.setBounds(811, 82, 64, 70);
		frame.getContentPane().add(lblJ7C2);
		
		JLabel lblC1 = new JLabel("");
		lblC1.setIcon(new ImageIcon(Vjeu.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblC1.setBounds(474, 235, 64, 70);
		frame.getContentPane().add(lblC1);
		
		JLabel lblC2 = new JLabel("");
		lblC2.setIcon(new ImageIcon(Vjeu.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblC2.setBounds(540, 235, 64, 70);
		frame.getContentPane().add(lblC2);
		
		JLabel lblC3 = new JLabel("");
		lblC3.setIcon(new ImageIcon(Vjeu.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblC3.setBounds(606, 235, 64, 70);
		frame.getContentPane().add(lblC3);
		
		JLabel lblC4 = new JLabel("");
		lblC4.setIcon(new ImageIcon(Vjeu.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblC4.setBounds(672, 235, 64, 70);
		frame.getContentPane().add(lblC4);
		
		JLabel lblC5 = new JLabel("");
		lblC5.setIcon(new ImageIcon(Vjeu.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblC5.setBounds(738, 235, 64, 70);
		frame.getContentPane().add(lblC5);
		
		JLabel lblMJ = new JLabel("");
		lblMJ.setIcon(new ImageIcon(Vjeu.class.getResource("/fr/poker/view/pictures/avatar/Avatar1.png")));
		lblMJ.setBounds(1183, 610, 64, 70);
		frame.getContentPane().add(lblMJ);
		
		JLabel lblMC1 = new JLabel("");
		lblMC1.setIcon(new ImageIcon(Vjeu.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblMC1.setBounds(1210, 680, 64, 70);
		frame.getContentPane().add(lblMC1);
		
		JLabel lblMC2 = new JLabel("");
		lblMC2.setIcon(new ImageIcon(Vjeu.class.getResource("/fr/poker/view/pictures/cards/card_back.png")));
		lblMC2.setBounds(1159, 680, 64, 70);
		frame.getContentPane().add(lblMC2);
		
		JLabel lblNameJ1 = new JLabel("NameJ1");
		lblNameJ1.setBackground(Color.LIGHT_GRAY);
		lblNameJ1.setForeground(new Color(128, 0, 0));
		lblNameJ1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNameJ1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameJ1.setBounds(358, 118, 59, 14);
		frame.getContentPane().add(lblNameJ1);
		
		JLabel lblNameJ2 = new JLabel("NameJ2");
		lblNameJ2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameJ2.setForeground(new Color(128, 0, 0));
		lblNameJ2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNameJ2.setBackground(Color.LIGHT_GRAY);
		lblNameJ2.setBounds(200, 291, 59, 14);
		frame.getContentPane().add(lblNameJ2);
		
		JLabel lblNameJ3 = new JLabel("NameJ3");
		lblNameJ3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameJ3.setForeground(new Color(128, 0, 0));
		lblNameJ3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNameJ3.setBackground(Color.LIGHT_GRAY);
		lblNameJ3.setBounds(365, 507, 59, 14);
		frame.getContentPane().add(lblNameJ3);
		
		JLabel lblNameJ4 = new JLabel("NameJ4");
		lblNameJ4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameJ4.setForeground(new Color(128, 0, 0));
		lblNameJ4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNameJ4.setBackground(Color.LIGHT_GRAY);
		lblNameJ4.setBounds(611, 512, 59, 14);
		frame.getContentPane().add(lblNameJ4);
		
		JLabel lblNameJ5 = new JLabel("NameJ5");
		lblNameJ5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameJ5.setForeground(new Color(128, 0, 0));
		lblNameJ5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNameJ5.setBackground(Color.LIGHT_GRAY);
		lblNameJ5.setBounds(880, 510, 59, 14);
		frame.getContentPane().add(lblNameJ5);
		
		JLabel lblNameJ6 = new JLabel("NameJ6");
		lblNameJ6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameJ6.setForeground(new Color(128, 0, 0));
		lblNameJ6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNameJ6.setBackground(Color.LIGHT_GRAY);
		lblNameJ6.setBounds(1071, 288, 59, 14);
		frame.getContentPane().add(lblNameJ6);
		
		JLabel lblNameJ7 = new JLabel("NameJ7");
		lblNameJ7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameJ7.setForeground(new Color(128, 0, 0));
		lblNameJ7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNameJ7.setBackground(Color.LIGHT_GRAY);
		lblNameJ7.setBounds(876, 118, 59, 14);
		frame.getContentPane().add(lblNameJ7);
		
		JLabel lblMiseJ1 = new JLabel("MiseJ1");
		lblMiseJ1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMiseJ1.setForeground(new Color(128, 0, 0));
		lblMiseJ1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMiseJ1.setBackground(Color.LIGHT_GRAY);
		lblMiseJ1.setBounds(357, 136, 59, 14);
		frame.getContentPane().add(lblMiseJ1);
		
		JLabel lblMiseJ2 = new JLabel("MiseJ2");
		lblMiseJ2.setHorizontalAlignment(SwingConstants.CENTER);
		lblMiseJ2.setForeground(new Color(128, 0, 0));
		lblMiseJ2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMiseJ2.setBackground(Color.LIGHT_GRAY);
		lblMiseJ2.setBounds(200, 309, 59, 14);
		frame.getContentPane().add(lblMiseJ2);
		
		JLabel lblMiseJ3 = new JLabel("MiseJ3");
		lblMiseJ3.setHorizontalAlignment(SwingConstants.CENTER);
		lblMiseJ3.setForeground(new Color(128, 0, 0));
		lblMiseJ3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMiseJ3.setBackground(Color.LIGHT_GRAY);
		lblMiseJ3.setBounds(366, 525, 59, 14);
		frame.getContentPane().add(lblMiseJ3);
		
		JLabel lblMiseJ4 = new JLabel("MiseJ4");
		lblMiseJ4.setHorizontalAlignment(SwingConstants.CENTER);
		lblMiseJ4.setForeground(new Color(128, 0, 0));
		lblMiseJ4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMiseJ4.setBackground(Color.LIGHT_GRAY);
		lblMiseJ4.setBounds(612, 530, 59, 14);
		frame.getContentPane().add(lblMiseJ4);
		
		JLabel lblMiseJ5 = new JLabel("MiseJ5");
		lblMiseJ5.setHorizontalAlignment(SwingConstants.CENTER);
		lblMiseJ5.setForeground(new Color(128, 0, 0));
		lblMiseJ5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMiseJ5.setBackground(Color.LIGHT_GRAY);
		lblMiseJ5.setBounds(882, 529, 59, 14);
		frame.getContentPane().add(lblMiseJ5);
		
		JLabel lblMiseJ6 = new JLabel("MiseJ6");
		lblMiseJ6.setHorizontalAlignment(SwingConstants.CENTER);
		lblMiseJ6.setForeground(new Color(128, 0, 0));
		lblMiseJ6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMiseJ6.setBackground(Color.LIGHT_GRAY);
		lblMiseJ6.setBounds(1073, 306, 59, 14);
		frame.getContentPane().add(lblMiseJ6);
		
		JLabel lblMiseJ7 = new JLabel("MiseJ7");
		lblMiseJ7.setHorizontalAlignment(SwingConstants.CENTER);
		lblMiseJ7.setForeground(new Color(128, 0, 0));
		lblMiseJ7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMiseJ7.setBackground(Color.LIGHT_GRAY);
		lblMiseJ7.setBounds(877, 136, 59, 14);
		frame.getContentPane().add(lblMiseJ7);
		
		JLabel lblPotTotal = new JLabel("PotTotal");
		lblPotTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPotTotal.setForeground(new Color(128, 0, 0));
		lblPotTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPotTotal.setBackground(Color.LIGHT_GRAY);
		lblPotTotal.setBounds(597, 187, 73, 14);
		frame.getContentPane().add(lblPotTotal);
		
		JLabel lblPotJoueur = new JLabel("PotJoueur");
		lblPotJoueur.setHorizontalAlignment(SwingConstants.CENTER);
		lblPotJoueur.setForeground(new Color(128, 0, 0));
		lblPotJoueur.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPotJoueur.setBackground(Color.LIGHT_GRAY);
		lblPotJoueur.setBounds(1057, 631, 89, 14);
		frame.getContentPane().add(lblPotJoueur);
		
		textFieldMise = new JTextField();
		textFieldMise.setBounds(430, 729, 108, 28);
		frame.getContentPane().add(textFieldMise);
		textFieldMise.setColumns(10);
		////////////////////////////////////////////////////////////////////////////////////////
		//ICI
		textFieldChat = new JTextField();
		textFieldChat.setBounds(7, 724, 305, 33);
		frame.getContentPane().add(textFieldChat);
		textFieldChat.setColumns(10);
		textFieldChat.setText("Je suis dans la zone ou j'écris");
		
		
		///////////////////////////////////////////////////////////////////////////////////// ICI
		JButton btnEnvoyer = new JButton("Envoyer");
		btnEnvoyer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEnvoyer.setBounds(319, 730, 89, 23);
		frame.getContentPane().add(btnEnvoyer);
		btnEnvoyer.addActionListener(new CjeuListener());
		
		JButton btnMiser = new JButton("Miser");
		btnMiser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnMiser.setBounds(548, 729, 103, 28);
		frame.getContentPane().add(btnMiser);
		
		JButton btnSuivre = new JButton("Suivre");
		btnSuivre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSuivre.setBounds(661, 729, 103, 28);
		frame.getContentPane().add(btnSuivre);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCheck.setBounds(774, 729, 101, 28);
		frame.getContentPane().add(btnCheck);
		
		JButton btnSeCoucher = new JButton("Se coucher");
		btnSeCoucher.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSeCoucher.setBounds(885, 729, 127, 28);
		frame.getContentPane().add(btnSeCoucher);
		
		//ICI///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		JPanel panelChat = new JPanel();
		panelChat.setBounds(7, 608, 391, 110);
		frame.getContentPane().add(panelChat);
		// Modif Corentin PRIMA
		panelChat.setLayout(new FlowLayout());
		//JLabel label = new JLabel("Ici il faut afficher le resultat du chat");
		JLabel label = new JLabel(messageRecu);
		panelChat.add(label);
		// Modif update
		//panelChat.updateUI();
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(Vjeu.class.getResource("/fr/poker/view/pictures/background.png")));
		lblBackground.setBounds(0, 0, 1284, 761);
		frame.getContentPane().add(lblBackground);
	}
}
