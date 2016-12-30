package fr.poker.controller;

import javax.swing.JFrame;

import fr.poker.controller.bdd.CBcompte;
import fr.poker.controller.bdd.CBconnect;
import fr.poker.controller.bdd.CBsalle;
import fr.poker.view.Vcreation;
import fr.poker.view.Vparametres;

public class Ccreation{
	
	private Vcreation vCrea;
	private JFrame frameCrea;
	private Caccueil cAcc;
	private int IDplayer;
	private boolean isPrivate=false;
	
	private CBconnect cbCon;
	private CBsalle cbSalle;
	private CBcompte cbCpt;
	
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
		System.out.println("close creation");	
	}



	public boolean isPrivate() {
		return isPrivate;
	}


	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}


	public void runSalle() {
		
		cbCon = new CBconnect();
		cbSalle = new CBsalle(cbCon);
		boolean pwdOK=false;
		boolean nomOK=false;
		
		//verifie si les Pwd entrés sont identique si if isPrivate=true

		if (isPrivate==true){
			if (vCrea.getStringPwdSalle()==vCrea.getStringPwdSalleConfirm())
			{	
				System.out.println("Champs pwd identiques");
				pwdOK=true;
			}
			else
			{
				System.out.println("Champs pwd différents");
			}
		}
		if (isPrivate==false){
			pwdOK=true;
		}
		
		//Verfie que le nom donnée à la salle  n'existe pas
		nomOK=cbSalle.verifDataSalle(vCrea.getStringTxtNameSalle().toString());
		
		// Creation de la salle : 
		if (nomOK==true && pwdOK==true){
			cbSalle.creeSalle(isPrivate,vCrea.getStringPwdSalleConfirm(),vCrea.getStringTxtNameSalle());
			//Ferme Interface de création et retour a l'ecran d'accueil 
			System.out.println(vCrea.getStringPwdSalleConfirm());
			System.out.println("partie crée : "+ vCrea.getStringTxtNameSalle());
			runAccueil();
		}
		
	}


	public void maskPwd() {
		vCrea.activePassword(false);
		isPrivate=false;
	}


	public void displayPwd() {
		vCrea.activePassword(true);
		isPrivate=true;
	}
	
	
	
}



