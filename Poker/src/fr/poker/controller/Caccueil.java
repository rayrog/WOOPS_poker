package fr.poker.controller;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.EventListener;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import fr.poker.controller.bdd.CBcompte;
import fr.poker.controller.bdd.CBconnect;
import fr.poker.controller.bdd.CBsalle;
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
	 * listener param�tres { controller. parametrage compte ; }
	 * 
	 * listener cr�er une partie {
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
	private Cparametre cParam;
	private Ccreation cCrea;
	private Vparametres fentrePara;
	private CBconnect cbcon;
	private CBsalle cSalle;
	
	public Caccueil(Cconnexion c,int ID) {
		this.vacc = new Vaccueil(this);
		this.ccon = c;
		this.IDplayer=ID;
		System.out.println("Accueil ouvert pour joueur : " + IDplayer);
		listeSalles();
	}
	
	public Caccueil(Cparametre c, int ID){
		this.vacc = new Vaccueil(this);
		this.cParam=c;
		this.IDplayer=ID;
		System.out.println("Accueil ouvert pour joueur : " + IDplayer);
		listeSalles();
	}
	
	public Caccueil(Ccreation c, int ID) {
		this.vacc = new Vaccueil(this);
		this.cCrea=c;
		this.IDplayer=ID;
		System.out.println("Accueil ouvert pour joueur : " + IDplayer);
		listeSalles();
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
	
	
	public void runAccueil(){
		displayAccueil();
	}


	public void runCreation() {
		this.cCrea = new Ccreation(this, IDplayer);
		vacc.getFrame().setVisible(false);
		cCrea.displayCrea();
		// TODO Auto-generated method stub
		
	}
	
	public void listeSalles() {
		int nbSalle=0;
		System.out.println("fct liste salle");
		cbcon = new CBconnect();
		cSalle = new CBsalle(cbcon);
		nbSalle=cSalle.listeSalles();
		System.out.println("Nombre de salle : " + nbSalle);
	}

}