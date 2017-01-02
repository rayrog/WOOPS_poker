package fr.poker.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.poker.controller.Cclient;
import fr.poker.model.ConstantesServeur;

public class taskPerformed implements ActionListener {
	private Cclient client;
	public taskPerformed(Cclient c) {
		this.client = c;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		client.getOut().println(ConstantesServeur.SECOUCHER);	
	}

}
