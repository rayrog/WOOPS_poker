package fr.poker.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.poker.model.Joueur;
import fr.poker.view.Vjeu;

public class JButtonListenerMiser implements ActionListener{
	public JButtonListenerMiser()
	{
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("Je mise");
		//Vjeu.mise = Vjeu.textFieldMise.getText();
		
		//Joueur.miser(Vjeu.mise);
	}
}
