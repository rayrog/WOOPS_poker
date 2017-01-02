package fr.poker.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JTextField;

import fr.poker.controller.bdd.CBcompte;
import fr.poker.controller.bdd.CBconnect;
import fr.poker.controller.bdd.CBsalle;
import fr.poker.model.ConstantesServeur;
import fr.poker.view.Vcreation;
import fr.poker.view.Vparametres;

public class Ccreation implements Runnable{
	
	private Vcreation vCrea;
	private JFrame frameCrea;
	private Caccueil cAcc;
	private ArrayList<String> txtFields;
	private int IDplayer;
	private boolean isPrivate=false;
	

	protected BufferedReader in;
	protected PrintStream out;
	protected Thread t; 
	private Socket socket;
	
	private CBconnect cbCon;
	private CBsalle cbSalle;
	private CBcompte cbCpt;
	
	
	public Ccreation(Caccueil a,int Id,Socket socket)throws Exception {
		this.vCrea=new Vcreation(this);
		this.IDplayer = Id;
		this.cAcc= a;
		this.socket=socket;
		System.out.println("Creation Ouvert pour joueur : " + IDplayer);
		
		
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintStream(socket.getOutputStream());
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		this.t = new Thread(this);
		t.start();
					
		
	}


	public Vcreation getvCrea() {
		return vCrea;
	}


	public void setvCrea(Vcreation vCrea) {
		this.vCrea = vCrea;
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


	public void runSalle() throws Exception {
		// Sert au clique sur le bouton de lancement de la salle, fait differentes verification, recupère un ID disponnible et l'assigne à la salle
		
		cbCon = new CBconnect();
		cbSalle = new CBsalle(cbCon);
		String pwdSalle = "";
		String pwdConf = "";
		String nomSalle = "";
		int mise=0;
		int portSalle;
		int portChat;
		boolean pwdOK=false;
		boolean nomOK=false;
		boolean miseOK=false;
		
		
		//verifie si les Pwd entrés sont identique si if isPrivate=true
		
		if (isPrivate==true){
			
			pwdSalle=vCrea.getStringPwdSalle();
			pwdConf=vCrea.getStringPwdSalleConfirm();
			//System.out.println(pwdSalle + pwdConf);
			if (pwdSalle.equals(pwdConf)==true)
			{	
				//System.out.println("Champs pwd identiques");
				pwdOK=true;
			}
		}
		if (isPrivate==false){
			pwdSalle="";
			pwdConf="";
			pwdOK=true;
		}
		
		//Verfie que le nom donnée à la salle  n'existe pas.
		//System.out.println(vCrea.getStringTxtNameSalle().toString());
		
		nomOK=cbSalle.verifNomSalle(vCrea.getStringTxtNameSalle().toString());
		
		if (nomOK==true){
			nomSalle=vCrea.getStringTxtNameSalle().toString();
		}
		//Essaye de récupérer un port disponnible dans la Base de donnée pour le Chat et un port pour la salle
		
		portSalle=cbSalle.getAvailablePort("salle");
		portChat=cbSalle.getAvailablePort("chat");
		
		//System.out.println("portSalle obtenue : "+ portSalle);
		//System.out.println("portChat obtenue : " + portChat);
		
		//Verifie si la mise entrée est correcte : 
		
		//Expression pour les nombre : 
		Pattern p_num = Pattern.compile(".*[^0-9].*");
		//System.out.println(vCrea.getTxtMise().getText());
		//System.out.println( "does " + vCrea.getTxtMise().getText() + " is number : " + !p_num.matcher(vCrea.getTxtMise().getText()).matches());
		if(!p_num.matcher(vCrea.getTxtMise().getText()).matches()) {
			
			mise=Integer.parseInt(vCrea.getTxtMise().getText());
			miseOK=true;
			//System.out.println("mise Ok " + mise );
		}
		
		// Creation de la salle : 
		if (nomOK==true && pwdOK==true && portChat !=-1 && portSalle !=-1 && miseOK==true){
			//créer la salle 
			
			/* 
			 * Valeur de test  : 
			 */
			//isPrivate=false;
			///pwdSalle="";
			//nomSalle= "SallePublique1";
			//portSalle=4565;//4555-4565 
			//portChat=4580;//4570 */
			
			cbSalle.creeSalle(isPrivate,pwdSalle, nomSalle, portSalle, portChat, mise);
			
			
			/// mettre tout en string + mettre le hash  // Verifier la misre de la salle
			
			// Creation socket serveu
			this.out.println(ConstantesServeur.CREERSALLE+" "+portSalle+" "+portChat+" "+nomSalle+" "+pwdSalle+" "+Boolean.toString(isPrivate));
			
			
			//recup cagnotte !! / Recup pseudo // 			Cclient c = new Cclient(socket, Integer.parseInt(IDplayer), 1000, "jackie");	
			Cclient c = new Cclient(socket, IDplayer,Double.parseDouble("1000"), "jackie",portSalle, portChat, cAcc);	
			
			//On lance la communication
	
			// utiliser isPrivate,pwdSalle, nomSalle, portSalle, portChat, mise 
			
			//	Lancement de la partide pour le joueur 
				
			//c.lancementClient();
		}
		else if(nomOK==false){
			System.out.println("le nom de la salle existe deja");
		}
		else if(pwdOK==false){
			System.out.println("Erreure Mot de passe");
		}
		else if(portChat==-1){
			System.out.println("Problème port Chat");
		}
		else if(portSalle==-1){
			System.out.println("Problème port Salle");
		}
		else if(miseOK==false){
			System.out.println("Problème mise");
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


	public void deleteTxtInField(JTextField txtFields) {
		txtFields.setText("");
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}



