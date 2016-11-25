package fr.poker.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenu;

public class Accueil {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accueil window = new Accueil();
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
	public Accueil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(39, 78, 19));
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Accueil.class.getResource("/fr/poker/view/pictures/logo.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(538, 156, 160, 154);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("WOOP");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.LIGHT_GRAY);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 45));
		label_1.setBounds(530, 38, 168, 63);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("World Of Online Poker");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.LIGHT_GRAY);
		label_2.setFont(new Font("Tahoma", Font.ITALIC, 20));
		label_2.setBounds(500, 96, 234, 63);
		frame.getContentPane().add(label_2);
		
		JButton btnDconnexion = new JButton("D\u00E9connexion");
		btnDconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDconnexion.setIcon(new ImageIcon(Accueil.class.getResource("/fr/poker/view/pictures/logout.png")));
		btnDconnexion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDconnexion.setBounds(10, 11, 191, 51);
		frame.getContentPane().add(btnDconnexion);
		
		JButton btnParamtres = new JButton("Param\u00E8tres");
		btnParamtres.setIcon(new ImageIcon(Accueil.class.getResource("/fr/poker/view/pictures/settings.png")));
		btnParamtres.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnParamtres.setBounds(1083, 201, 191, 51);
		frame.getContentPane().add(btnParamtres);
		
		JButton btnCrerUnePartie = new JButton("Cr\u00E9er une partie");
		btnCrerUnePartie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCrerUnePartie.setBounds(530, 321, 191, 51);
		frame.getContentPane().add(btnCrerUnePartie);
		
		JButton btnRejoindreUnePartie = new JButton("Rejoindre une partie");
		btnRejoindreUnePartie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRejoindreUnePartie.setEnabled(false);
		btnRejoindreUnePartie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRejoindreUnePartie.setBounds(519, 619, 215, 51);
		frame.getContentPane().add(btnRejoindreUnePartie);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"N\u00B0", "Type", "Nom", "Mode", "Joueurs"
			}
		));
		table.setBounds(380, 409, 454, 136);
		frame.getContentPane().add(table);
		frame.setBounds(100, 100, 1300, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
