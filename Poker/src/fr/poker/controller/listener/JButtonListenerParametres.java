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
			System.out.println("Tentative d'Enregistrement");
			if(cPara.verifyBdd()){
				System.out.println("verif BDD OK");
				if(cPara.verifyFields()) {
					System.out.println("verif fields");
					cPara.insertNewUserData();
					System.out.println("infos enregistrée");
				}
			}
		}
		if (e.getActionCommand().equals("Crediter")) {
			int credit;
			credit = cPara.getvParam().displayCrediter();
			System.out.println("Crediter");
			cPara.crediterDe(credit);

			
		}
		
		if (e.getActionCommand().equals("Retirer")) {
			int retrait;
			retrait = cPara.getvParam().displayRetirer();
			System.out.println("Retirer");
			cPara.retirerDe(retrait);

			
		}
		if (e.getActionCommand().equals("Annuler")) {
			cPara.closePara();
		}
	}
}





