package fr.poker.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.poker.controller.Cpartie;
import fr.poker.model.Joueur;

public class JButtonListenerJeu implements ActionListener {
	private Cpartie cPart;
	private Joueur joueur;
	public JButtonListenerJeu(Cpartie c) {
		this.cPart = c;	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Miser")) {
			System.out.println("Je mise");

			
		}
		if (e.getActionCommand().equals("Suivre")) {
			System.out.println("Je suis");
		
		}
		if (e.getActionCommand().equals("Check")) {
			System.out.println("Je check");
		
		}
		if (e.getActionCommand().equals("Se coucher")) {
			System.out.println("je me couche");
		
		}
	}
	
}
