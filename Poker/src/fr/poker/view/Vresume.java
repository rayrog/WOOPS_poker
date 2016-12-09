package fr.poker.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Vresume {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vresume window = new Vresume();
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
	public Vresume() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(39, 78, 19));
		frame.setBounds(100, 100, 1300, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Vresume.class.getResource("/fr/poker/view/pictures/logo.png")));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(548, 11, 160, 154);
		frame.getContentPane().add(lblLogo);
		
		JLabel lblTitle = new JLabel("Partie Finie");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.LIGHT_GRAY);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblTitle.setBounds(482, 164, 293, 63);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblSlogan = new JLabel("World Of Online Poker");
		lblSlogan.setHorizontalAlignment(SwingConstants.CENTER);
		lblSlogan.setForeground(Color.LIGHT_GRAY);
		lblSlogan.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblSlogan.setBounds(514, 218, 234, 63);
		frame.getContentPane().add(lblSlogan);
		
		JLabel lblAvatar = new JLabel("");
		lblAvatar.setIcon(new ImageIcon(Vresume.class.getResource("/fr/poker/view/pictures/avatar/Avatar1.png")));
		lblAvatar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvatar.setBounds(575, 272, 111, 111);
		frame.getContentPane().add(lblAvatar);
		
		JLabel lblWinnerName = new JLabel("WinnerName");
		lblWinnerName.setHorizontalAlignment(SwingConstants.CENTER);
		lblWinnerName.setForeground(Color.LIGHT_GRAY);
		lblWinnerName.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblWinnerName.setBounds(514, 375, 234, 63);
		frame.getContentPane().add(lblWinnerName);
		
		JLabel lblPotWin = new JLabel("Pot gagn\u00E9 : 100 \u20AC");
		lblPotWin.setHorizontalAlignment(SwingConstants.CENTER);
		lblPotWin.setForeground(Color.LIGHT_GRAY);
		lblPotWin.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblPotWin.setBounds(514, 437, 222, 63);
		frame.getContentPane().add(lblPotWin);
		
		JLabel lblGamesNumbers = new JLabel("Nombre de jeux : 24");
		lblGamesNumbers.setHorizontalAlignment(SwingConstants.CENTER);
		lblGamesNumbers.setForeground(Color.LIGHT_GRAY);
		lblGamesNumbers.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblGamesNumbers.setBounds(514, 498, 222, 63);
		frame.getContentPane().add(lblGamesNumbers);
	}
}
