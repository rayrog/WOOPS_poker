package fr.poker.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.poker.controller.Cconnexion;

public class JButtonListenerAccueil implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Deconnexion") {
			System.out.println("Deconnexion");
		}
		if (e.getActionCommand() == "Parametres") {
			System.out.println("Parametres");
	//		Cconnexion.login();
			
		}
	}
}
