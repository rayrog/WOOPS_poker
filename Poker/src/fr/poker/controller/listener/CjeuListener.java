package fr.poker.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.text.JTextComponent;

import fr.poker.view.Vjeu;

public class CjeuListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Coucou je suis dans CjeuListener");
		//panelChat.updateUI();
		// Je recupere mon texte:
		Vjeu.messageRecu = Vjeu.textFieldChat.getText();
		//JLabel label = new JLabel(textRecupere);
		//Vjeu.panelChat.add(label);
		Vjeu.panelChat.repaint();
		//Vjeu window = new Vjeu(textRecupere);
	    //window.frame.setVisible(true);
	}
}
