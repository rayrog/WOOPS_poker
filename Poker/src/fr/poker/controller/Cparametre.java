package fr.poker.controller;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;

import fr.poker.view.Vparametres;

public class Cparametre {
	private Vparametres vParam;
	private JFrame frameParam;
	private ArrayList<String> txtFields;
	private Caccueil cAcc;
	private int IDplayer;
	

	public Cparametre(Caccueil a,int Id) {
		this.vParam=new Vparametres(this);
		this.IDplayer = Id;
		this.cAcc= a;
		System.out.println("Param�tre ouvert pour joueur : " + IDplayer);
		this.txtFields = new ArrayList<>();
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

	public void deleteTxtInField(JTextField txtField) {
		txtField.setText("");	
	}

	public Vparametres getvParam() {
		return vParam;
	}
	
}
