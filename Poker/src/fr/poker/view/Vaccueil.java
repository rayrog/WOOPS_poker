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

import fr.poker.controller.listener.JButtonListenerAccueil;;

public class Vaccueil {

	private JFrame frame;
	private JTable tableGameList;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vaccueil window = new Vaccueil();
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
	public Vaccueil() {
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
		lblLogo.setIcon(new ImageIcon(Vaccueil.class.getResource("/fr/poker/view/pictures/logo.png")));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(538, 156, 160, 154);
		frame.getContentPane().add(lblLogo);
		
		JLabel lblTitle = new JLabel("WOOP");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.LIGHT_GRAY);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblTitle.setBounds(530, 38, 168, 63);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblSlogan = new JLabel("World Of Online Poker");
		lblSlogan.setHorizontalAlignment(SwingConstants.CENTER);
		lblSlogan.setForeground(Color.LIGHT_GRAY);
		lblSlogan.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblSlogan.setBounds(500, 96, 234, 63);
		frame.getContentPane().add(lblSlogan);
		
		JButton btnLogoff = new JButton("Deconnexion");
		btnLogoff.addActionListener(new JButtonListenerAccueil());
		btnLogoff.setIcon(new ImageIcon(Vaccueil.class.getResource("/fr/poker/view/pictures/logout.png")));
		btnLogoff.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogoff.setBounds(10, 11, 191, 51);
		frame.getContentPane().add(btnLogoff);
		
		JButton btnParameters = new JButton("Parametres");
		btnParameters.addActionListener(new JButtonListenerAccueil());
		btnParameters.setIcon(new ImageIcon(Vaccueil.class.getResource("/fr/poker/view/pictures/settings.png")));
		btnParameters.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnParameters.setBounds(1093, 11, 191, 51);
		frame.getContentPane().add(btnParameters);
		
		JButton btnCreate = new JButton("Cr\u00E9er une partie");
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCreate.setBounds(530, 321, 191, 51);
		frame.getContentPane().add(btnCreate);
		
		JButton btnJoin = new JButton("Rejoindre une partie");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnJoin.setEnabled(false);
		btnJoin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnJoin.setBounds(519, 619, 215, 51);
		frame.getContentPane().add(btnJoin);
		
		tableGameList = new JTable();
		tableGameList.setModel(new DefaultTableModel(
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
		tableGameList.setBounds(380, 409, 454, 136);
		frame.getContentPane().add(tableGameList);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(1093, 154, 176, 27);
		frame.getContentPane().add(lblNewLabel);
		frame.setBounds(100, 100, 1300, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
