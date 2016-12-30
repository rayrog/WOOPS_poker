package fr.poker.view;

import javax.swing.JFrame;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.omg.CORBA.PUBLIC_MEMBER;

import fr.poker.controller.Cinscription;
import fr.poker.controller.listener.JButtonListenerInscription;
import fr.poker.controller.listener.JTextFieldListenerInscription;

import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JPanel;

public class Vinscription {

	private JFrame frame;
	private JPasswordField pwdAccount;
	private JTextField txtLastName;
	private JTextField txtPseudo;
	private JTextField txtFirstName;
	private JPasswordField pwdConfirm;
	private JTextField txtEmail;
	private JTextField txtPhoneNumber;
	private String [] textInitiaux;
	private JButton btnSignUp;
	private JButton btnBack;
	private JLabel lblErrorField;
	private JLabel lblSuccess;
	private JLabel lblAvatar;


	public JLabel getLblAvatar() {
		return lblAvatar;
	}

	public void setLblAvatar(JLabel lblAvatar) {
		this.lblAvatar = lblAvatar;
	}

	/*
	 * Create the application.
	 */
	public Vinscription(Cinscription cins, JFrame feneco) {
		String[] texts = {"Mot de passe", "Confirmer", "Nom", "Pr\u00E9nom",  "Pseudo", "E-mail", "N\u00B0 T\u00E9l\u00E9phone"};
		textInitiaux = texts;
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 16));
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(39, 78, 19));
		frame.setBounds(100, 100, 1300, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Vinscription.class.getResource("/fr/poker/view/pictures/logo.png")));
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
		
	
		lblAvatar = new JLabel("");
		lblAvatar.setIcon(new ImageIcon(Vinscription.class.getResource("/fr/poker/view/pictures/avatar/Avatar1.png")));
		lblAvatar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvatar.setBounds(541, 35, 111, 111);
		frame.getContentPane().add(lblAvatar);
		
		lblSuccess = new JLabel("Enregistrement effectué avec succès !");
		lblSuccess.setBackground(new Color(0, 128, 0));
		lblSuccess.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuccess.setForeground(Color.RED);
		lblSuccess.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblSuccess.setBounds(202, 129, 835, 63);
		frame.getContentPane().add(lblSuccess);
		lblSuccess.setVisible(false);
		
		pwdAccount = new JPasswordField();
		pwdAccount.setText(textInitiaux[0]);
		pwdAccount.setName("pwdAccount");
		pwdAccount.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pwdAccount.setBackground(Color.LIGHT_GRAY);
		pwdAccount.setBounds(427, 308, 367, 51);
		frame.getContentPane().add(pwdAccount);
		pwdAccount.addMouseListener(new JTextFieldListenerInscription(cins, pwdAccount));
		pwdAccount.addFocusListener(new JTextFieldListenerInscription(cins, pwdAccount));
		//pwdAccount.addActionListener(new JTextFieldListener(pwdAccount));
		
		pwdConfirm = new JPasswordField();
		pwdConfirm.setText(textInitiaux[1]);
		pwdConfirm.setName("pwdConfirm");
		pwdConfirm.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pwdConfirm.setBackground(Color.LIGHT_GRAY);
		pwdConfirm.setBounds(427, 370, 367, 51);
		frame.getContentPane().add(pwdConfirm);
		pwdConfirm.addMouseListener(new JTextFieldListenerInscription(cins, pwdConfirm));
		pwdConfirm.addFocusListener(new JTextFieldListenerInscription(cins, pwdConfirm));
		//pwdConfirm.addActionListener(new CinscriptionListener(pwdConfirm));
		
		txtLastName = new JTextField();
		txtLastName.setText(textInitiaux[2]);
		txtLastName.setName("txtLastName");
		txtLastName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtLastName.setColumns(10);
		txtLastName.setBackground(Color.LIGHT_GRAY);
		txtLastName.setBounds(427, 184, 176, 51);
		frame.getContentPane().add(txtLastName);
		txtLastName.addMouseListener(new JTextFieldListenerInscription(cins, txtLastName));
		txtLastName.addFocusListener(new JTextFieldListenerInscription(cins, txtLastName));
		//txtLastName.addActionListener(new CinscriptionListener(txtLastName)); 

		
		txtFirstName = new JTextField();
		txtFirstName.setText(textInitiaux[3]);
		txtFirstName.setName("txtFirstName");
		txtFirstName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtFirstName.setColumns(10);
		txtFirstName.setBackground(Color.LIGHT_GRAY);
		txtFirstName.setBounds(618, 184, 176, 51);
		frame.getContentPane().add(txtFirstName);
		txtFirstName.addMouseListener(new JTextFieldListenerInscription(cins, txtFirstName));
		txtFirstName.addFocusListener(new JTextFieldListenerInscription(cins, txtFirstName));
		//txtFirstName.addActionListener(new CinscriptionListener(txtFirstName));
		
		txtPseudo = new JTextField();
		txtPseudo.setText(textInitiaux[4]);
		txtPseudo.setName("txtPseudo");
		txtPseudo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtPseudo.setColumns(10);
		txtPseudo.setBackground(Color.LIGHT_GRAY);
		txtPseudo.setBounds(427, 246, 367, 51);
		frame.getContentPane().add(txtPseudo);
		txtPseudo.addMouseListener(new JTextFieldListenerInscription(cins, txtPseudo));
		txtPseudo.addFocusListener(new JTextFieldListenerInscription(cins, txtPseudo));
		//txtPseudo.addActionListener(new CinscriptionListener(txtPseudo));
		
		txtEmail = new JTextField();
		txtEmail.setText(textInitiaux[5]);
		txtEmail.setName("txtEmail");
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtEmail.setColumns(10);
		txtEmail.setBackground(Color.LIGHT_GRAY);
		txtEmail.setBounds(427, 432, 367, 51);
		frame.getContentPane().add(txtEmail);
		txtEmail.addMouseListener(new JTextFieldListenerInscription(cins, txtEmail));
		txtEmail.addFocusListener(new JTextFieldListenerInscription(cins, txtEmail));
		//txtEmail.addActionListener(new CinscriptionListener(txtEmail));
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setText(textInitiaux[6]);
		txtPhoneNumber.setName("txtPhoneNumber");
		txtPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBackground(Color.LIGHT_GRAY);
		txtPhoneNumber.setBounds(427, 494, 367, 51);
		frame.getContentPane().add(txtPhoneNumber);
		txtPhoneNumber.addMouseListener(new JTextFieldListenerInscription(cins, txtPhoneNumber));
		txtPhoneNumber.addFocusListener(new JTextFieldListenerInscription(cins, txtPhoneNumber));
		//txtPhoneNumber.addActionListener(new CinscriptionListener(txtPhoneNumber));
		
		btnSignUp = new JButton("Inscription");
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSignUp.setBounds(427, 556, 367, 51);
		btnSignUp.addActionListener(new JButtonListenerInscription(cins));
		frame.getContentPane().add(btnSignUp);
		
		btnBack = new JButton("Retour");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.setBounds(427, 610, 367, 51);
		btnBack.addActionListener(new JButtonListenerInscription(cins));
		frame.getContentPane().add(btnBack);
		
		lblErrorField = new JLabel("");
		lblErrorField.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblErrorField.setForeground(Color.RED);
		lblErrorField.setBounds(360, 162, 486, 16);
		frame.getContentPane().add(lblErrorField);
		lblErrorField.setVisible(false);
		
		JLabel lblInfoFields = new JLabel("Tous les champs sont obligatoires !");
		lblInfoFields.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoFields.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblInfoFields.setBounds(488, 673, 249, 16);
		frame.getContentPane().add(lblInfoFields);
		
        Object[] items =
        {	
        	new ImageIcon(Vinscription.class.getResource("/fr/poker/view/pictures/avatar/Avatar1.png")),
        	new ImageIcon(Vinscription.class.getResource("/fr/poker/view/pictures/avatar/Avatar2.png")),
        	new ImageIcon(Vinscription.class.getResource("/fr/poker/view/pictures/avatar/Avatar3.png")),
        	new ImageIcon(Vinscription.class.getResource("/fr/poker/view/pictures/avatar/Avatar4.png")),
        	new ImageIcon(Vinscription.class.getResource("/fr/poker/view/pictures/avatar/Avatar5.png")),
        	new ImageIcon(Vinscription.class.getResource("/fr/poker/view/pictures/avatar/Avatar6.png")),
        	new ImageIcon(Vinscription.class.getResource("/fr/poker/view/pictures/avatar/Avatar7.png")),
        	new ImageIcon(Vinscription.class.getResource("/fr/poker/view/pictures/avatar/Avatar8.png")),
        	new ImageIcon(Vinscription.class.getResource("/fr/poker/view/pictures/avatar/Avatar9.png"))
        };
        JComboBox comboBoxAvatar = new JComboBox( items );
        comboBoxAvatar.setSize(new Dimension(100, 100));
        comboBoxAvatar.setBounds(620, 11, 35, 154);
        frame.getContentPane().add( comboBoxAvatar);
        comboBoxAvatar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		        JComboBox cb = (JComboBox)e.getSource();
		        lblAvatar.setIcon((Icon) cb.getSelectedItem());	
			}
		});
		
	}

	static class CustomComboBox extends JLabel implements ListCellRenderer {

        @Override
        public Component getListCellRendererComponent(
                JList list, 
                Object value, 
                int index, 
                boolean isSelected, 
                boolean cellHasFocus) {

            JLabel label = new JLabel(){
                public Dimension getPreferredSize(){
                    return new Dimension(200, 100);
                }
            };
            label.setText(String.valueOf(value));

            return label;
        }
    }  
    
	public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				Vinscription window = new Vinscription(null, new JFrame());
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
	}

	public JLabel getLblSuccess() {
		return lblSuccess;
	}

	public void setLblSuccess(JLabel lblSuccess) {
		this.lblSuccess = lblSuccess;
	}

	public String[] getTextInitiaux() {
		return textInitiaux;
	}

	public void setTextInitiaux(String[] textInitiaux) {
		this.textInitiaux = textInitiaux;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JPasswordField getPwdAccount() {
		return pwdAccount;
	}

	public void setPwdAccount(JPasswordField pwdAccount) {
		this.pwdAccount = pwdAccount;
	}

	public JTextField getTxtLastName() {
		return txtLastName;
	}

	public void setTxtLastName(JTextField txtLastName) {
		this.txtLastName = txtLastName;
	}

	public JTextField getTxtPseudo() {
		return txtPseudo;
	}

	public void setTxtPseudo(JTextField txtPseudo) {
		this.txtPseudo = txtPseudo;
	}

	public JTextField getTxtFirstName() {
		return txtFirstName;
	}

	public void setTxtFirstName(JTextField txtFirstName) {
		this.txtFirstName = txtFirstName;
	}

	public JPasswordField getPwdConfirm() {
		return pwdConfirm;
	}

	public void setPwdConfirm(JPasswordField pwdConfirm) {
		this.pwdConfirm = pwdConfirm;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public JTextField getTxtPhoneNumber() {
		return txtPhoneNumber;
	}

	public void setTxtPhoneNumber(JTextField txtPhoneNumber) {
		this.txtPhoneNumber = txtPhoneNumber;
	}
	
	public JLabel getLblErrorField() {
		return lblErrorField;
	}

	public void setLblErrorField(JLabel lblErrorField) {
		this.lblErrorField = lblErrorField;
	}
	
}
