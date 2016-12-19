package fr.poker.controller;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.EventListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import fr.poker.view.Vaccueil;
import fr.poker.view.Vinscription;
import fr.poker.view.Vparametres;

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
	private int IDplayer;
	private Cparametre cParam;;
	private Vparametres fentrePara;
	
	public Caccueil(Cconnexion c,int ID) {
		this.vacc = new Vaccueil(this);
		this.ccon = c;
		this.IDplayer=ID;
		System.out.println("Accueil ouvert pour joueur : " + IDplayer);

	}
	
	
	public Caccueil(Cparametre c, int ID){
		this.vacc = new Vaccueil(this);
		this.cParam=c;
		this.IDplayer=ID;
		System.out.println("Accueil ouvert pour joueur : " + IDplayer);

	}


	public int getIDplayer() {
		return IDplayer;
	}


	public void setIDplayer(int iDplayer) {
		IDplayer = iDplayer;
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
	
	
	public void runParametres(){
		this.cParam = new Cparametre(this, IDplayer);
		vacc.getFrame().setVisible(false);
		cParam.displayParametres();
		
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