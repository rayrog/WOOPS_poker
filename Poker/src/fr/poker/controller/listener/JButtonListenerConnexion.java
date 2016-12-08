package fr.poker.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import fr.poker.controller.*;

public class JButtonListenerConnexion implements ActionListener{
	private Cconnexion cc;
	public JButtonListenerConnexion(Cconnexion c) {
		// TODO Auto-generated constructor stub
		this.cc = c;
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Inscription")) {
			System.out.println("Tentative de d'inscription");
			cc.runInscription();
			
		}
		if (e.getActionCommand().equals("Connexion")) {
			System.out.println("Tentative de connexion");
			//Cconnexion.login();
			
		}
	}
}
