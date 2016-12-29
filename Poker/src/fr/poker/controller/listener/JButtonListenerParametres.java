package fr.poker.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import fr.poker.controller.Cparametre;

public class JButtonListenerParametres implements ActionListener
{
	private Cparametre cPara;
	public JButtonListenerParametres(Cparametre c) {
		this.cPara = c;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Enregistrer")) {
			System.out.println("Enregistrer");

		}
		if (e.getActionCommand().equals("Crediter")) {
			System.out.println("Crediter");

		}
		if (e.getActionCommand().equals("Retirer")) {
			System.out.println("Retirer");

		}
		if (e.getActionCommand().equals("Annuler")) {
			cPara.closePara();
		}
	}
}





