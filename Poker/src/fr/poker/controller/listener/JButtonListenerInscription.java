package fr.poker.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

import fr.poker.controller.Cinscription;

public class JButtonListenerInscription implements ActionListener {
	private Cinscription cIns;
	public JButtonListenerInscription(Cinscription c) {
		// TODO Auto-generated constructor stub
		this.cIns = c;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Inscription")) {
			System.out.println("Tentative de d'inscription");
			if(cIns.verifyFields()){
				if(cIns.verifyBdd()) {
					cIns.insertNewUserData();
				}
			}
		}
		if (e.getActionCommand().equals("Retour")) {
			cIns.closeInscription();
			cIns.getCcon().displayConnexion();
		}
	}

}
