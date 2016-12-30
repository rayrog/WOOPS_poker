package fr.poker.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.poker.controller.Cclient;
import fr.poker.controller.Cpartie;
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
			cCli.getOut().println(ConstantesServeur.MISER);		
		}
		if (e.getActionCommand().equals("Suivre")) {
			cCli.getOut().println(ConstantesServeur.SUIVRE);
		}
		if (e.getActionCommand().equals("Check")) {
			cCli.getOut().println(ConstantesServeur.CHECK);
		}
		if (e.getActionCommand().equals("Se coucher")) {
			cCli.getOut().println(ConstantesServeur.SECOUCHER);
		}
		if (e.getActionCommand().equals("Rejoindre Table")) {
			cCli.getOut().println(ConstantesServeur.REJOINDRETABLE);
		}
		if (e.getActionCommand().equals("Quitter Salle")) {
			cCli.getOut().println(ConstantesServeur.QUITTERSALLE);
		}
	}
	
}
