package fr.poker.controller;

import static java.lang.System.out;

import java.awt.List;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
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
	private CBcompte cbcpt;

	//private int IDSalle;
	
	public Caccueil(Cconnexion c,int ID) {
		this.vacc = new Vaccueil(this);
		this.ccon = c;
		this.IDplayer=ID;
		System.out.println("Accueil ouvert pour joueur : " + IDplayer);
		init();
	}
	
	public Caccueil(Cparametre c, int ID){
		this.vacc = new Vaccueil(this);
		this.cParam=c;
		this.IDplayer=ID;
		System.out.println("Accueil ouvert pour joueur : " + IDplayer);
		init();
	}
	
	public Caccueil(Ccreation c, int ID) {
		this.vacc = new Vaccueil(this);
		this.cCrea=c;
		this.IDplayer=ID;
		System.out.println("Accueil ouvert pour joueur : " + IDplayer);
		init();
	}
	
	private void init(){
		listeSalles();
		displayCredit();
		displayPseudo();
	}
	
	private void displayPseudo(){	
		cbcon = new CBconnect();
		cbcpt = new CBcompte(cbcon);
		//cbcpt.getCredit(getIDplayer()); // recupere le credit du joueur 
		vacc.setPseudo(cbcpt.getPseudo(getIDplayer()));
	}

	private void displayCredit(){
		cbcon = new CBconnect();
		cbcpt = new CBcompte(cbcon);
		//cbcpt.getCredit(getIDplayer()); // recupere le credit du joueur 
		vacc.setCredit(cbcpt.getCredit(getIDplayer()));
	
	}

	public int getIDplayer() {
		return IDplayer;
	}
	

	public String getIDSalle() {
		return vacc.getiDChoisie(); 
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
		//System.out.println("fct liste salle : ");
		cbcon = new CBconnect();
		cSalle = new CBsalle(cbcon);
		
		Vector<String> listSalles = new Vector();
		listSalles=cSalle.listeSalles();
		
		Vector<String> listId = new Vector();
		listId=cSalle.getListId();
		
		// Compte nb de salles
		int nbSalles = 0;
		for (Object o : listSalles) {
			nbSalles++;
		}
		//Créer la liste contenant les infos des salles
		String[] data = new String [nbSalles+1];
		nbSalles=0;
		for (Object o : listSalles) {
			nbSalles++;
			//System.out.println(nbSalles);
			data[nbSalles]=new String (o.toString());
		}
		
		String[] dataId = new String [nbSalles+1];
		nbSalles=0;
		for (Object o : listId) {
			nbSalles++;
			dataId[nbSalles]=new String (o.toString());
		}
        //Update le Scroll pane contenant la liste des parties + celui lui donne les ID des parties
		vacc.setScrollPane_1DataList(data,dataId);
	}

	public void reloadData() {
		listeSalles();
	}

	public void rejoindrePartie(int iDplayer, String iDSalle) {
		System.out.println("Tentative de connexion du joueur "+ iDplayer +" a la partie " + iDSalle);
		
		
		// Ceck si partie private et recuper son ID.
		// Si partie private demander password
		
		System.out.println("TO DO  Ajout du joueur a la salle ");
	}
}