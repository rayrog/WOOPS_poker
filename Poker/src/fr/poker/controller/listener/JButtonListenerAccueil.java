package fr.poker.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.poker.controller.Caccueil;
import fr.poker.controller.Cconnexion;
import fr.poker.controller.Cparametre;

public class JButtonListenerAccueil implements ActionListener{
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
			//System.out.println("Parametres");
			CAcc.runParametres();
		}
		if (e.getActionCommand() == "Cr\u00E9er une partie") {
			//System.out.println("Creer une partie");
			try {
				CAcc.runCreation();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		if (e.getActionCommand() == "Rejoindre salle"){
		//	System.out.println("Rejoindre salle");
			try {
				CAcc.rejoindrePartie(CAcc.getIDplayer(),CAcc.getIDSalle());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getActionCommand() == "Rafraichir"){
			//System.out.println("Raffraichir");
			CAcc.reloadData();
			
		}
		
	}
}
