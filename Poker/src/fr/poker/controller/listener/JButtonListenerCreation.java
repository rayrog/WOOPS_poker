package fr.poker.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.poker.controller.Cconnexion;

public class JButtonListenerCreation implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}


/*




public class JButtonListenerConnexion 
	private Cconnexion cCon;
	public JButtonListenerConnexion(Cconnexion c) {
		// TODO Auto-generated constructor stub
		this.cCon = c;
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Inscription")) {
			System.out.println("Tentative de d'inscription");
			cCon.runInscription();
			
		}
		if (e.getActionCommand().equals("Connexion")) {
			System.out.println("Tentative de connexion");
			cCon.login();
			
		}
	}
}*/
