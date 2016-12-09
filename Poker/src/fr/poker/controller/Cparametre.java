package fr.poker.controller;

import javax.swing.JFrame;

import fr.poker.view.Vparametres;

public class Cparametre {
	private Vparametres vParam;
	private JFrame frameParam;
	private Caccueil cAcc;
	private int IDplayer;
	

	public Cparametre(Caccueil a,int Id) {
		this.vParam=new Vparametres(this);
		this.IDplayer = Id;
		this.cAcc= a;
		System.out.println("Paramètre ouvert pour joueur : " + IDplayer);
	}

	public void displayParametres(){
		vParam.getFrame().setVisible(true);
	}

}
