package fr.poker.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.poker.controller.Cclient;

import fr.poker.model.ConstantesServeur;
import fr.poker.model.Joueur;

public class JButtonListenerClient implements ActionListener {
	private Cclient cCli;
	private Joueur joueur;
	public JButtonListenerClient(Cclient c) {
		this.cCli = c;	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Miser")) {
			if(cCli.j.miser(Double.parseDouble(cCli.getvJeu().getTextFieldMise().getText()))){
				cCli.getOut().println(ConstantesServeur.MISER+" "+cCli.getvJeu().getTextFieldMise().getText());
			} else cCli.getvJeu().getLblNotificationsPartie().setText("Credit insuffisant pour miser ce montant");
		}
		if (e.getActionCommand().equals("Suivre")) {
/*			if(cCli.j.miser(Double.parseDouble(cCli.getvJeu().getTextFieldMise().getText()))){
				cCli.getOut().println(ConstantesServeur.MISER+" "+cCli.getvJeu().getTextFieldMise().getText());
			} else cCli.getvJeu().getLblNotificationsPartie().setText("Credit insuffisant pour miser ce montant");*/
			cCli.getOut().println(ConstantesServeur.SUIVRE);
			
		}
		if (e.getActionCommand().equals("Check")) {
			cCli.getOut().println(ConstantesServeur.CHECK);
		}
		if (e.getActionCommand().equals("Se coucher")) {
			cCli.getOut().println(ConstantesServeur.SECOUCHER);
			cCli.setJouer(false);
			cCli.getvJeu().update(cCli, null);
			cCli.getTimerDecision().stop();
		}
		if (e.getActionCommand().equals("Rejoindre Table")) {
			cCli.getOut().println(ConstantesServeur.REJOINDRETABLE);
		}
		if (e.getActionCommand().equals("Quitter la salle")) {
			cCli.getOut().println(ConstantesServeur.QUITTERSALLE);
			cCli.fermerClient();
		}
	}
	
}
