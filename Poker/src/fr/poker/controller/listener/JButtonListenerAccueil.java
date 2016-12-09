package fr.poker.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.poker.controller.Caccueil;
import fr.poker.controller.Cconnexion;

public class JButtonListenerAccueil implements ActionListener {
	private Cconnexion cCon;
	private Caccueil CAcc;
	
	public JButtonListenerAccueil(Caccueil c) {
		this.CAcc=c;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Deconnexion") {
			System.out.println("Deconnexion");
			CAcc.closeAccueil();
			cCon=new Cconnexion();
			cCon.displayConnexion();
			
			
		}
		if (e.getActionCommand() == "Parametres") {
			System.out.println("Parametres");

			
		}
	}
}
