package fr.poker.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.poker.controller.*;
import fr.poker.view.Vconnexion;

public class CconnexionListener implements ActionListener{


	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Inscription") {
			System.out.println("Ouverture de la page d'inscription");
			//CInscription.displayInscription();
			//test
				
		}
		if (e.getActionCommand() == "Connexion") {
			System.out.println("Tentative de connexion");
			Cconnexion.login();
			
		}
	}
	

}

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.poker.controller.*;
import fr.poker.view.Vconnexion;

public class CconnexionListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Inscription") {
			System.out.println("Ouverture de la page d'inscription");
			//CInscription.displayInscription();
		}
		if (e.getActionCommand() == "Connexion") {
			System.out.println("Tentative de connexion");
			Cconnexion.login();
			
		}
	}
}
