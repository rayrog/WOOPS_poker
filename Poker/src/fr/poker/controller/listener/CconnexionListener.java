package fr.poker.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import fr.poker.controller.*;

public class CconnexionListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Inscription") {
			System.out.println("Ouverture de la page d'inscription");
			Cconnexion.closeConnexion();
			Cinscription.displayInscription();
		}
		if (e.getActionCommand() == "Connexion") {
			System.out.println("Tentative de connexion");
			Cconnexion.login();
			
		}
	}
}
