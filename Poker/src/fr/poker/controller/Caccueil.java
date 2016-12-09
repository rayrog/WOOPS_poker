package fr.poker.controller;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.EventListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import fr.poker.view.Vaccueil;
import fr.poker.view.Vinscription;

public class Caccueil {
	/*
	 * display connexionscreen;
	 * 
	 * public interface ActionListener extends EventListener{} display list of
	 * current games; display player name / current money;
	 * 
	 * 
	 * while partie not selected on the list { if partie OK to be join { enable
	 * Rejoindre }
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * listener deconnexion { controller.accueil; }
	 * 
	 * listener paramètres { controller. parametrage compte ; }
	 * 
	 * listener créer une partie {
	 * 
	 * controller. } listener rejoindre
	 * 
	 * } catch (NumberFormatException nfe) { JOptionPane.showMessageDialog(null,
	 * "Input must be a number."); } }
	 */
	
	
	
	private Vaccueil vacc;
	private JFrame frameacc;
	private Cconnexion ccon;
	
	public Caccueil(Cconnexion c) {
		this.vacc = new Vaccueil(this);
		this.ccon = c;
		//vacc.set
	}
	
	public Cconnexion getCcon() {
		return ccon;
	}

	public void setCcon(Cconnexion ccon) {
		this.ccon = ccon;
	}

	public void displayAccueil(){
		vacc.getFrame().setVisible(true);
	}
	
	public void closeAccueil(){
		vacc.getFrame().dispose();
	}
	
	/*public void deleteTxtInField(JTextField txtField) {
		txtField.setText("");
	}
	
	public void fillField(JTextField txtField, String txt) {
		txtField.setText(txt);
	}
	*/
	
	public void runAccueil(){
		displayAccueil();
	}
	/*
	
	public void verifyFields(ArrayList<JTextField> fiels){
		
	}*/

}