package fr.poker.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.poker.view.Vconnexion;

public class CconnexionListener implements ActionListener{


	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Inscription") {
				System.out.println("Ouverture de la page d'inscription");
				
		}
		if (e.getActionCommand() == "Connexion") {
			System.out.println("Tentative de connexion");
		//	System.out.println(Vconnexion.getFrames().);
		//	System.out.println(pwdMotDePasse.getPassword());

		}
	}
	

}
