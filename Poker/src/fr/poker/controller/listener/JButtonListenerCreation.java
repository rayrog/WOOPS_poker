package fr.poker.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.poker.controller.Cconnexion;
import fr.poker.controller.Ccreation;

public class JButtonListenerCreation implements ActionListener{
	private Ccreation cCre;
	public JButtonListenerCreation(Ccreation c) {
		this.cCre = c;		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Retour")) {
			System.out.println("Retour");
			cCre.runAccueil();
		}
		if (e.getActionCommand().equals("Créer la salle")){
			//System.out.println("Créer la salle");
			try {
				cCre.runSalle();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getActionCommand().equals("Publique")){
			System.out.println("Publique");
			cCre.maskPwd();
		}
		if (e.getActionCommand().equals("Privée")){
			System.out.println("Privée");
			cCre.displayPwd();
			
			//cCre.runSalle();
		}
		//System.out.println(e.getActionCommand());
		
		
	}	
}

