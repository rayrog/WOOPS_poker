package fr.poker.controller;

import static java.lang.System.out;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
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
import fr.poker.model.ConstantesServeur;
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
	public Vaccueil getVacc() {
		return vacc;
	}

	public void setVacc(Vaccueil vacc) {
		this.vacc = vacc;
	}

	private Cconnexion ccon;
	private int IDplayer;
	private Cparametre cParam;
	private Ccreation cCrea;
	private Vparametres fentrePara;
	private CBconnect cbcon;
	private CBsalle cSalle;
	private CBcompte cbcpt;
	
	protected BufferedReader in;
	protected PrintStream out;
	protected String adresseServeurPoker;
	protected int portServeur;
	

	//private int IDSalle;
	
	public Caccueil(Cconnexion c,int ID) {
		this.vacc = new Vaccueil(this);
		this.ccon = c;
		this.IDplayer=ID;
		this.adresseServeurPoker = "172.23.2.15";
		this.portServeur = 4554;
		System.out.println("Accueil ouvert pour joueur : " + IDplayer);
		init();
	}
	
	public Caccueil(Cparametre c, int ID){
		this.vacc = new Vaccueil(this);
		this.cParam=c;
		this.IDplayer=ID;
		this.adresseServeurPoker = "172.23.2.15";
		this.portServeur = 4554;
		System.out.println("Accueil ouvert pour joueur : " + IDplayer);
		init();
	}
	
	public Caccueil(Ccreation c, int ID) {
		this.vacc = new Vaccueil(this);
		this.cCrea=c;
		this.IDplayer=ID;
		this.adresseServeurPoker = "172.23.2.15";
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


	public void runCreation() throws Exception {
		Socket socket = new Socket("172.23.2.15",4554);
		this.cCrea = new Ccreation(this, IDplayer,socket);
		vacc.getFrame().setVisible(false);
		cCrea.displayCrea();		
		
		System.out.println("here");
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
	
	public void rejoindrePartie(int iDplayer, String iDSalle) throws Exception {
		/*
		 * Socket socket = new Socket(adresseServeurPoker, portServeur);
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintStream(socket.getOutputStream());
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}*/
		
		
		System.out.println("Tentative de connexion du joueur "+ iDplayer +" a la partie " + iDSalle);
		
		cbcon = new CBconnect();
		cSalle = new CBsalle(cbcon);
		cbcpt = new CBcompte(cbcon);

		

		double credit=Double.parseDouble(cbcpt.getCredit(IDplayer));
		String pseudo=cbcpt.getPseudo(iDplayer);
		int portSalle=cSalle.getPortSalle(iDSalle);
		int portChat=cSalle.getPortChat(iDSalle);
		

		
		System.out.println(iDplayer);
		System.out.println(credit);
		System.out.println(pseudo);
		System.out.println(portSalle);
		System.out.println(portChat);
		int tempport = 4555 ;

		Socket socketClient = new Socket("172.23.2.15",tempport);
		Cclient c = new Cclient(socketClient,iDplayer,credit,pseudo,portSalle, portChat, this);	

	
		
		
		//cSalle.isPrivate();
		
		// Ceck si partie private et recuper son ID.
		// Si partie private demander password
		
		//		
		
		
//		port salle.
//		○ ID du joueur
//		○ Pseudo
//		○ Argent cagnotte Sans avoir retiré !

//		○ Ca lui lance le contrleur Cclient 		
		
	}
}