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

public class Vcreation {

	private JFrame frame;
	private JTextField txtRoomName;
	private JMenu mnGameMode;
	private JButton btnTournament;
	private JButton btnClassic;
	private JMenu mnRoomType;
	private JButton btnPublic;
	private JButton btnPrivate;
	private JPasswordField passwordRoom;

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
		passwordRoom.setBounds(649, 411, 176, 41);
		frame.getContentPane().add(passwordRoom);
		
		JButton btnCreate = new JButton("Cr\u00E9er la salle");
		btnCreate.setBounds(424, 411, 215, 52);
		frame.getContentPane().add(btnCreate);
		frame.setBounds(100, 100, 1300, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTxtRoomName() {
		return txtRoomName;
	}

	public void setTxtRoomName(JTextField txtRoomName) {
		this.txtRoomName = txtRoomName;
	}

	public JMenu getMnGameMode() {
		return mnGameMode;
	}

	public void setMnGameMode(JMenu mnGameMode) {
		this.mnGameMode = mnGameMode;
	}

	public JButton getBtnTournament() {
		return btnTournament;
	}

	public void setBtnTournament(JButton btnTournament) {
		this.btnTournament = btnTournament;
	}

	public JButton getBtnClassic() {
		return btnClassic;
	}

	public void setBtnClassic(JButton btnClassic) {
		this.btnClassic = btnClassic;
	}

	public JMenu getMnRoomType() {
		return mnRoomType;
	}

	public void setMnRoomType(JMenu mnRoomType) {
		this.mnRoomType = mnRoomType;
	}

	public JButton getBtnPublic() {
		return btnPublic;
	}

	public void setBtnPublic(JButton btnPublic) {
		this.btnPublic = btnPublic;
	}

	public JButton getBtnPrivate() {
		return btnPrivate;
	}

	public void setBtnPrivate(JButton btnPrivate) {
		this.btnPrivate = btnPrivate;
	}

	public JPasswordField getPasswordRoom() {
		return passwordRoom;
	}

	public void setPasswordRoom(JPasswordField passwordRoom) {
		this.passwordRoom = passwordRoom;
	}


	
	
	
}
