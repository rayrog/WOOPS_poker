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
			//System.out.println("Je mise");
			cCli.getOut().println(ConstantesServeur.MISER);
			
		}
		if (e.getActionCommand().equals("Suivre")) {
			//System.out.println("Je suis");
			cCli.getOut().println(ConstantesServeur.SUIVRE);
		}
		if (e.getActionCommand().equals("Check")) {
			//System.out.println("Je check");
			cCli.getOut().println(ConstantesServeur.CHECK);
		}
		if (e.getActionCommand().equals("Se coucher")) {
			//System.out.println("je me couche");
			cCli.getOut().println(ConstantesServeur.SECOUCHER);
		}
	}
	
}
