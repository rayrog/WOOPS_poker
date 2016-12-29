package fr.poker.controller;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTextField;

import fr.poker.controller.bdd.CBcompte;
import fr.poker.controller.bdd.CBconnect;
import fr.poker.controller.bdd.CBsalle;
import fr.poker.view.Vparametres;

public class Cparametre {
	private Vparametres vParam;
	private JFrame frameParam;
	private ArrayList<String> txtFields;
	private Caccueil cAcc;
	private int IDplayer;
	private CBconnect cbcon;
	private CBcompte cbcpt;
	

	public Cparametre(Caccueil a,int Id) {
		this.vParam=new Vparametres(this);
		this.IDplayer = Id;
		this.cAcc= a;
		System.out.println("Paramètre ouvert pour joueur : " + IDplayer);
		this.txtFields = new ArrayList<>();
		this.displayInfos();
	}

	public void displayParametres(){
		vParam.getFrame().setVisible(true);
	}
	
	public void fillField(JTextField txtField, String txt) {
		txtField.setText(txt);
	}

	public void closePara() {
		this.cAcc = new Caccueil(this, IDplayer);
		cAcc.displayAccueil();
		vParam.getFrame().dispose();
		System.out.println("close parametre");
	}
	
	
	public String[] displayInfos(){	
		cbcon = new CBconnect();
		cbcpt = new CBcompte(cbcon);
		//cbcpt.getCredit(getIDplayer()); // recupere le credit du joueur 
		cbcpt.getPlayerInfo(getIDplayer());
		Vector<String> infos = new Vector();
		infos=cbcpt.getPlayerInfo(getIDplayer());
		//Créer la liste contenant les infos des salles
		String[] data = new String [7];
		int i=0;
		for (Object o : infos) {
			i++;
			//System.out.println(i);
			//System.out.println(o.toString());
			data[i]=new String (o.toString());
		}
		vParam.setInfoToDisplay(data);
		return data;
	}
	
	public void deleteTxtInField(JTextField txtField) {
		txtField.setText("");	
	}

	public Vparametres getvParam() {
		return vParam;
	}

	public int getIDplayer() {
		return IDplayer;
	}

	public void setIDplayer(int iDplayer) {
		IDplayer = iDplayer;
	}
	
	
	
	
	
}
