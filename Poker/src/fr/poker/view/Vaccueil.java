package fr.poker.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import fr.poker.controller.Caccueil;
import fr.poker.controller.Cconnexion;
import fr.poker.controller.listener.JButtonListenerAccueil;
import fr.poker.controller.listener.JButtonListenerConnexion;;

public class Vaccueil{
		private JFrame frame;
		private JTable tableGameList;
		private JButton btnLogoff;
		private JButton btnParameters;	
		private JButton btnCreate;
		private JButton btnJoin;	
		
		public Vaccueil(Caccueil cacc){
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
			
			this.btnLogoff = new JButton("Deconnexion");
			btnLogoff.addActionListener(new JButtonListenerAccueil(cacc));
			btnLogoff.setIcon(new ImageIcon(Vaccueil.class.getResource("/fr/poker/view/pictures/logout.png")));
			btnLogoff.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnLogoff.setBounds(10, 11, 191, 51);
			frame.getContentPane().add(btnLogoff);
			
			
			this.btnParameters = new JButton("Parametres");
			btnParameters.addActionListener(new JButtonListenerAccueil(cacc));
			btnParameters.setIcon(new ImageIcon(Vaccueil.class.getResource("/fr/poker/view/pictures/settings.png")));
			btnParameters.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnParameters.setBounds(1093, 11, 191, 51);
			frame.getContentPane().add(btnParameters);
			
			
			this.btnCreate = new JButton("Cr\u00E9er une partie");
			btnCreate.addActionListener(new JButtonListenerAccueil(cacc));
			btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnCreate.setBounds(530, 321, 191, 51);
			frame.getContentPane().add(btnCreate);
			
			this.btnJoin = new JButton("Rejoindre une partie");
			btnJoin.addActionListener(new JButtonListenerAccueil(cacc));
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
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTable getTableGameList() {
		return tableGameList;
	}

	public void setTableGameList(JTable tableGameList) {
		this.tableGameList = tableGameList;
	}
	public JButton getBtnLogoff() {
		return btnLogoff;
	}
	public JButton getBtnParameters() {
		return btnParameters;
	}
	public JButton getBtnCreate() {
		return btnCreate;
	}
	public JButton getBtnJoin() {
		return btnJoin;
	}
	
	
}
