package fr.poker.controller;

import javax.swing.JFrame;

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
		System.out.println("display creation ");
		vCrea.getFrame().setVisible(true);
		
	}
	
	public void closeCrea() {
		/*this.cAcc = new Caccueil(this, IDplayer);
		cAcc.displayAccueil();
		vParam.getFrame().dispose();
		System.out.println("close parametre");*/
	}
	
	
}



