package fr.poker.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CinscriptionListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Inscription") {
				System.out.println("On essaye de se connecter");
				
		}
	}
}
