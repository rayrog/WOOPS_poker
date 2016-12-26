package fr.poker.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import fr.poker.model.chat.client.Emission;
import fr.poker.view.Vjeu;

public class CjeuListener implements ActionListener{
	
	public CjeuListener()
	{
		//this.textField = txt;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Coucou je suis dans CjeuListener");
		//panelChat.updateUI();
		// Je recupere mon texte:
		//String message;
		//message = Vjeu.textFieldChat.getText();
		Vjeu.messageRecu = Vjeu.textFieldChat.getText();
		Emission.run(Vjeu.messageRecu);
		//System.out.println(Vjeu.messageRecu);
		//System.out.println("mdr");
		//JLabel label = new JLabel(Vjeu.messageRecu);
		//Vjeu.panelChat.add(label);
		//Vjeu.label.updateUI();
		//Vjeu.panelChat.update(null);
		//Vjeu.panelChat.removeAll();
		//JLabel label = new JLabel(Vjeu.messageRecu);
		//Vjeu.panelChat.removeAll();
		//Vjeu.panelChat.add(label);
		//Vjeu window = new Vjeu(Vjeu.messageRecu);
	    //window.frame.setVisible(true);
	}
}
