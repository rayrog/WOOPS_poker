package fr.poker.controller;

import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	

	public Cparametre(Caccueil a,int ID) {
		this.vParam=new Vparametres(this);
		this.IDplayer = ID;
		this.cAcc= a;
		System.out.println("Paramètre ouvert pour joueur : " + IDplayer);
		this.txtFields = new ArrayList<>();
		//this.displayInfos();
		displayInfos();
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
		//Créer la liste contenant les infos du Joueur
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

	public void insertNewUserData() {
		// TODO Auto-generated method stub
		
	}

	public boolean verifyBdd() {
		cbcon = new CBconnect();
		cbcpt = new CBcompte(cbcon);
		//Vérifie si le pseudo existe déjà en BDD
		if(cbcpt.checkPseudo(vParam.getTxtPseudo().getText()) != -1) {
			System.out.println("Le pseudo existe déjà en Bdd !");
			vParam.getLblErrorField().setText("Le pseudo existe déjà !");
			vParam.getLblErrorField().setVisible(true);
			return false;
		}
		//Vérifie si le mail existe déjà en BDD
		if(cbcpt.checkMail(vParam.getTxtEmail().getText()) != -1) {
			System.out.println("Le mail existe déjà en BDD");
			vParam.getLblErrorField().setText(" Le mail est déjà enregistré avec un autre compte !");
			vParam.getLblErrorField().setVisible(true);
			return false;
		}
		
		return true;
	}

	public boolean verifyFields() {
		//Expression régulière pour les caractèress spéciaux
		Pattern p_special_charac = Pattern.compile("[^ \\w]");
		//Expression régulière pour l'adresse mail
		Pattern p_mail = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		//Expression régulière pour le numéro de téléphone
		Pattern p_num = Pattern.compile("^[0-9]{10}$");
		ArrayList<String> compare = new ArrayList<String>();
		for(int i = 0; i<vParam.getTextInitiaux().length; i++){
					compare.add(vParam.getTextInitiaux()[i]);
				}
		txtFields = new ArrayList<>();
		txtFields.add(vParam.getTxtLastName().getText());
		txtFields.add(vParam.getTxtFirstName().getText());
		txtFields.add(vParam.getTxtPseudo().getText());
		txtFields.add(vParam.getPwdAccount().getText());
		txtFields.add(vParam.getPwdConfirm().getText());
		//txtFields.add(vParam.getTxtEmail().getText());
		//txtFields.add(vParam.getTxtPhoneNumber().getText());
		
		for(String s : txtFields){
			//Vérifie si l'utilisateur à renseigner tous les champs : useless ici 
					/*if(compare.contains(s)){
						vins.getLblErrorField().setText("Tous les champs doivent être renseignés !");
						vins.getLblErrorField().setVisible(true);
						return false;					
					}*/
			Matcher m = p_special_charac.matcher(s);
			//Vérifie si il y a des espaces ou caractères spéciaux dans les champs
					if(s.contains(" ") == true || m.find()){
						vParam.getLblErrorField().setText("Des champs contiennent des espaces ou des caractères spéciaux !");
						vParam.getLblErrorField().setVisible(true);
						return false;	
					}
				}
				//Vérifie que le mot de passe entré et sa confirmation sont semblables
				if((vParam.getPwdAccount().getText()).equals(vParam.getPwdConfirm().getText()) == false){
					vParam.getLblErrorField().setText("Les mots de passes doivent être identiques !");
					vParam.getLblErrorField().setVisible(true);
					return false;	
				}
				//Vérifie si l'email a le bon format
				Matcher m_mail = p_mail.matcher(vParam.getTxtEmail().getText());
				if(m_mail.find() == false) {
					vParam.getLblErrorField().setText("L'email doit être au bon format !");
					vParam.getLblErrorField().setVisible(true);
					return false;		
				}		
				//Vérifie si e numéro de téléphone a le bon format
				Matcher m_num = p_num.matcher(vParam.getTxtPhoneNumber().getText());
				if(m_num.find() == false) {
					vParam.getLblErrorField().setText("Le numéro de téléphone doit être au bon format !");
					vParam.getLblErrorField().setVisible(true);
					return false;	
				}
				return true;
	}
	
	
}
