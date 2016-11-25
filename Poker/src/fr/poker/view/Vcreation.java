package fr.poker.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Vcreation {

	private JFrame frame;
	private JTextField txtNomDeLa;
	private JMenu mnNewMenu;
	private JButton btnTournoi;
	private JButton btnClassique;
	private JMenu mnTypeDeSalle;
	private JButton btnPublique;
	private JButton btnPrive;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the application.
	 */
	public Vcreation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(39, 78, 19));
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("World Of Online Poker");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.LIGHT_GRAY);
		label.setFont(new Font("Tahoma", Font.ITALIC, 20));
		label.setBounds(504, 100, 234, 63);
		frame.getContentPane().add(label);
		
		JLabel lblCrationDePartie = new JLabel("Cr\u00E9ation de partie");
		lblCrationDePartie.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrationDePartie.setForeground(Color.LIGHT_GRAY);
		lblCrationDePartie.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblCrationDePartie.setBounds(385, 42, 466, 63);
		frame.getContentPane().add(lblCrationDePartie);
		
		txtNomDeLa = new JTextField();
		txtNomDeLa.setForeground(Color.GRAY);
		txtNomDeLa.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtNomDeLa.setText("Nom de la salle");
		txtNomDeLa.setBounds(424, 172, 401, 63);
		frame.getContentPane().add(txtNomDeLa);
		txtNomDeLa.setColumns(10);
		
		mnNewMenu = new JMenu("Mode de jeu");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnNewMenu.setBounds(424, 269, 196, 32);
		frame.getContentPane().add(mnNewMenu);
		
		btnClassique = new JButton("Classique");
		mnNewMenu.add(btnClassique);
		
		btnTournoi = new JButton("Tournoi");
		mnNewMenu.add(btnTournoi);
		
		mnTypeDeSalle = new JMenu("Type de salle");
		mnTypeDeSalle.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnTypeDeSalle.setBounds(424, 337, 196, 32);
		frame.getContentPane().add(mnTypeDeSalle);
		
		btnPublique = new JButton("Publique");
		mnTypeDeSalle.add(btnPublique);
		
		btnPrive = new JButton("Priv\u00E9e");
		mnTypeDeSalle.add(btnPrive);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField.setBounds(649, 411, 176, 41);
		frame.getContentPane().add(passwordField);
		
		JButton btnCreer = new JButton("Cr\u00E9er la salle");
		btnCreer.setBounds(424, 411, 215, 52);
		frame.getContentPane().add(btnCreer);
		frame.setBounds(100, 100, 1300, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
