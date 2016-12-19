package fr.poker.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonListenerSeCoucher implements ActionListener{
	public JButtonListenerSeCoucher()
	{
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("Je mise");
		//Vjeu.mise = Vjeu.textFieldMise.getText();
		
		//Joueur.miser(Vjeu.mise);
	}
}
