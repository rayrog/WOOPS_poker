package fr.poker.view;


import java.awt.EventQueue;
import static java.lang.System.out;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import fr.poker.controller.listener.CconnexionListener;

import java.awt.Font;
import javax.swing.JTextField;


public class Vconnexion extends JFrame {
		JFrame frame;
		JPasswordField pwdMotDePasse;
		JTextField txtEmail;
		JButton btnConnexion;
		JButton btnInscription;
		
		public Vconnexion(){		
			frame = new JFrame();
			frame.getContentPane().setBackground(new Color(39, 78, 19));
			frame.getContentPane().setLayout(null);
			
			pwdMotDePasse = new JPasswordField();
			pwdMotDePasse.setBackground(Color.LIGHT_GRAY);
			pwdMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 25));
			pwdMotDePasse.setText("Mot de passe");
			pwdMotDePasse.setBounds(445, 396, 367, 51);
			frame.getContentPane().add(pwdMotDePasse);
			
			JLabel lblLogo = new JLabel("");
			lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
			lblLogo.setIcon(new ImageIcon(Vconnexion.class.getResource("/fr/poker/view/pictures/logo.png")));
			lblLogo.setBounds(434, 145, 160, 154);
			frame.getContentPane().add(lblLogo);
			
			txtEmail = new JTextField();
			txtEmail.setBackground(Color.LIGHT_GRAY);
			txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 25));
			txtEmail.setText("E-mail");
			txtEmail.setBounds(447, 326, 365, 51);
			frame.getContentPane().add(txtEmail);
			txtEmail.setColumns(10);
			
			JLabel lblWoop = new JLabel("WOOP");
			lblWoop.setHorizontalAlignment(SwingConstants.CENTER);
			lblWoop.setFont(new Font("Tahoma", Font.BOLD, 45));
			lblWoop.setForeground(Color.LIGHT_GRAY);
			lblWoop.setBounds(627, 163, 168, 63);
			frame.getContentPane().add(lblWoop);
			
			JLabel lblWorldOfOnline = new JLabel("World Of Online Poker");
			lblWorldOfOnline.setHorizontalAlignment(SwingConstants.CENTER);
			lblWorldOfOnline.setForeground(Color.LIGHT_GRAY);
			lblWorldOfOnline.setFont(new Font("Tahoma", Font.ITALIC, 20));
			lblWorldOfOnline.setBounds(597, 221, 234, 63);
			frame.getContentPane().add(lblWorldOfOnline);
			
			this.btnInscription = new JButton("Inscription");
			btnInscription.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnInscription.setBounds(445, 468, 176, 51);
			btnInscription.addActionListener(new CconnexionListener());
		
			this.btnConnexion = new JButton("Connexion");
			btnConnexion.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnConnexion.setBounds(636, 468, 176, 51);
			btnConnexion.addActionListener(new CconnexionListener());	
			
			frame.getContentPane().add(btnInscription);
			frame.getContentPane().add(btnConnexion);
			frame.setBounds(100, 100, 1300, 800);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			
			
		}
		
		
		public JFrame getFrame() {
			return frame;
		}


		public void setFrame(JFrame frame) {
			this.frame = frame;
		}


		public JButton getBtnInscription() {
			return btnInscription;
		}


		public void setBtnInscription(JButton btnInscription) {
			this.btnInscription = btnInscription;
		}


		public void setPwdMotDePasse(JPasswordField pwdMotDePasse) {
			this.pwdMotDePasse = pwdMotDePasse;
		}


		public void setTxtEmail(JTextField txtEmail) {
			this.txtEmail = txtEmail;
		}


		public JButton getBtnConnexion() {
			return btnConnexion;
		}


		public JPasswordField getPwdMotDePasse() {
			return pwdMotDePasse;
		}


		public JTextField getTxtEmail() {
			return txtEmail;
		}


}
