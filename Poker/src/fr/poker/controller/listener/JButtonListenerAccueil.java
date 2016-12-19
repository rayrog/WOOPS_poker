package fr.poker.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.poker.controller.Caccueil;
import fr.poker.controller.Cconnexion;
import fr.poker.controller.Cparametre;

public class JButtonListenerAccueil implements ActionListener {
	private Cconnexion cCon;
	private Caccueil CAcc;
	private Cparametre CPara;
	
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
			CAcc.runParametres();
		}
		if (e.getActionCommand() == "Creer") {
			System.out.println("Creer une partie");
		}
		if (e.getActionCommand() == "Rejoindre") {
			System.out.println("Rejoindre une partie");
		}
		
	}
}
