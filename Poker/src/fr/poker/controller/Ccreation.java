package fr.poker.controller;

import javax.swing.JFrame;

import fr.poker.controller.bdd.CBconnect;
import fr.poker.controller.bdd.CBsalle;
import fr.poker.view.Vcreation;
import fr.poker.view.Vparametres;

public class Ccreation{
	
	private Vcreation vCrea;
	private JFrame frameCrea;
	private Caccueil cAcc;
	private int IDplayer;

	
	public Ccreation(Caccueil a,int Id) {
		this.vCrea=new Vcreation(this);
		this.IDplayer = Id;
		this.cAcc= a;
		System.out.println("Creation Ouvert pour joueur : " + IDplayer);
	}


	public void displayCrea(){
		//System.out.println("display creation ");
		vCrea.getFrame().setVisible(true);
	}
	
	public void runAccueil() {
		this.cAcc = new Caccueil(this, IDplayer);
		cAcc.displayAccueil();
		vCrea.getFrame().dispose();
		System.out.println("close crea");	
	}



	public void runSalle() {
		/*creation d'une salle avec les param : 
		- Nom / privée ou publique 
		- Password
		*/	

	}
	
	
	
}



