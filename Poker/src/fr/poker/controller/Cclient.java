package fr.poker.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane; //TO DO à supprimer uniquement présent pour les test
import javax.swing.Timer;

import fr.poker.controller.listener.taskPerformed;
import fr.poker.model.*;
import fr.poker.view.Vjeu;
import fr.poker.view.VjeuClient;

/**
 * 
 * @author mflorycelini
 *
 */
public class Cclient extends Observable implements Runnable {
	public JoueurClient j;
	private VjeuClient vJeu;
	private Compte compte;
	protected BufferedReader in;
	protected PrintStream out;
	protected boolean partieTerminee;
	protected String notificationsSalle;
	protected String notificationsPartie;
	protected boolean jouer;
	protected boolean enJeu;
	protected Thread t;
	protected boolean newAdversaire;
	protected boolean adversaireOut;
	protected String infosAdversaire [] = {"","",""};
	private Timer timerDecision;
	private int tempsDecision;
	private String potTable;
	
	public Cclient(Compte c) {
		this.compte = c;
	}
	public Cclient(Socket socket, int idjoueur, Double creditJoueur, String pseudo) throws Exception{
		//On lance la communication
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintStream(socket.getOutputStream());
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		this.t = new Thread(this);
		t.start();
		this.j = new JoueurClient(idjoueur);
		j.setCreditPartie(creditJoueur);
		j.setPseudo(pseudo);
		this.notificationsSalle = "";
		this.notificationsPartie = "";
		this.jouer = false;
		this.enJeu = false;
		this.newAdversaire = false;
		this.adversaireOut = false;
		this.partieTerminee = false;
		this.vJeu = new VjeuClient(this);
		this.tempsDecision = 10000;
		ActionListener taskPerformer = new taskPerformed(this);
		this.timerDecision = new Timer(tempsDecision, taskPerformer);
		this.timerDecision.setRepeats(false);
	}
	
	public Timer getTimerDecision() {
		return timerDecision;
	}
	public void setTimerDecision(Timer timerDecision) {
		this.timerDecision = timerDecision;
	}
	public VjeuClient getvJeu() {
		return vJeu;
	}
	public void setvJeu(VjeuClient vJeu) {
		this.vJeu = vJeu;
	}
	public void traiterMessage(String message) { //message représente les informations envoyés par le controleur Cpartie
		Scanner scan = new Scanner(message);
		int type = scan.nextInt();
		switch(type){
		case ConstantesClient.MONIDTABLE :
			//Mise à jour du pot
			int idTable = scan.nextInt();
			j.setNumeroJoueurTable(idTable);
			System.out.println("Mon IDTABLE est le "+idTable);
			break;
		case ConstantesClient.POT :
			//Mise à jour du pot
			System.out.println("Mise à jour du pot");
			String pot = scan.next();
			potTable = pot;
			break;
		case ConstantesClient.TOURGAGNE :
			System.out.println("Tour gagne");
			break;
		case ConstantesClient.GAINTOUR :
			System.out.println("Tour gagne");
			break;
		case ConstantesClient.PERTETOUR :
			System.out.println("Perte du tour");
			break;
		case ConstantesClient.CHOIX_ADVERSAIRE :
			System.out.println("Choix adversaire");
			break;
		case ConstantesClient.GAINPARTIE :
			System.out.println("Gain Partie");
			break;
		case ConstantesClient.PARTIE_GAGNEE :
			System.out.println("Partie Gangnee");
			partieTerminee = true;
			break;
		case ConstantesClient.JOUE :
			jouer = true;
			//this.timerDecision.start();
			break;
		case ConstantesClient.SILENCE :
			System.out.println("fzeiufgzifgizf");
			jouer = false;
			//this.timerDecision.start();
			break;
		case ConstantesClient.ENJEU :
			this.enJeu = true;
			break;
		case ConstantesClient.NOUVEL_ADVERSAIRE :
			System.out.println("Nouvel adversaire");
			int idAdversaire = scan.nextInt();
			String pseudoAdversaire = scan.next();
			String potAdversaire = scan.next();
			infosAdversaire[0] = Integer.toString(idAdversaire);
			infosAdversaire[1] = pseudoAdversaire;
			infosAdversaire[2] = potAdversaire;
			newAdversaire = true;
			break;
		case ConstantesClient.ADVERSAIRE_OUT :
			System.out.println("L'adversaire à quitter la partie");
			int idAdversaireOut = scan.nextInt();
			String pseudoAdversaireOut = scan.next();
			String potAdversaireOut = scan.next();
			infosAdversaire[0] = Integer.toString(idAdversaireOut);
			infosAdversaire[1] = pseudoAdversaireOut;
			infosAdversaire[2] = potAdversaireOut;
			adversaireOut = true;			
			break;
		case ConstantesClient.NOTIFICATIONSSALLE :
			String newNotificationSalle = scan.next();
			newNotificationSalle = newNotificationSalle.replace("%", " ");
			notificationsSalle = newNotificationSalle;
			break;
		case ConstantesClient.NOTIFICATIONSPARTIE :
			String newNotificationPartie = scan.next();
			System.out.println(newNotificationPartie);;
			newNotificationPartie = newNotificationPartie.replace("%", " ");
			notificationsPartie = newNotificationPartie;
			break;
		case ConstantesClient.CARTEJOUEUR :

			break;
		case ConstantesClient.CARTETABLE :

			break;
		}
		//On notifie à la vue les changements
		vJeu.update(this, null);
	}


	public String getPotTable() {
		return potTable;
	}
	public void setPotTable(String potTable) {
		this.potTable = potTable;
	}
	public boolean isAdversaireOut() {
		return adversaireOut;
	}
	public void setAdversaireOut(boolean adversaireOut) {
		this.adversaireOut = adversaireOut;
	}
	@Override
	public void run() {
		while(!partieTerminee) {
			try {
				String message = in.readLine();
				traiterMessage(message);
			} catch (Exception e) {
				System.out.println("Joueur déconnecter");
				e.printStackTrace();
				try {
					t.stop();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	
	public void lancementClient() {			
		// TODO : cette fonction va remplacer le main plus bas
	}
	
	public void fermerClient() {
		vJeu.getFrame().dispose();
	}
	
	public static void main(String[] args) throws Exception { // Cette méthode ne sera plus un main et sera appelée par l'action du bouton rejoindre salle
		String monid = JOptionPane.showInputDialog
		(null, "Donner l'id du nouveau joueur");
		String pseudo = JOptionPane.showInputDialog
		(null, "Votre pseudo");
		Double cagnotte = 50.0;

		int portSalle = 4555; // Le port sera trasnmis par la méthode réécrite
		//TODO : adresse du serveur 
		Socket socket = new Socket("127.0.0.1", portSalle);
		System.out.println(Integer.parseInt(monid));
		Cclient c = new Cclient(socket, Integer.parseInt(monid), cagnotte, pseudo);	
		//On envoie l'id du joueur
		c.out.println(ConstantesServeur.MESINFORMATIONS+" "+monid+" "+pseudo+" "+cagnotte);
		System.out.println(ConstantesServeur.MESINFORMATIONS+" "+monid+" "+pseudo+" "+Double.toString(cagnotte));
	}
	
	public void btnDisable() {
		jouer = false;
		vJeu.getBtnSeCoucher().setEnabled(false);;
		vJeu.getBtnMiser().setEnabled(false);
		vJeu.getBtnSeCoucher().setEnabled(false);
		vJeu.getBtnCheck().setEnabled(false);
		vJeu.getBtnSuivre().setEnabled(false);
		vJeu.getFrame().revalidate();
		vJeu.getFrame().repaint();
		vJeu.update(this, null);
	}

	public PrintStream getOut() {
		return out;
	}
	
	public String getNotificationsSalle() {
		return notificationsSalle;
	}
	public void setNotificationsSalle(String notificationsSalle) {
		this.notificationsSalle = notificationsSalle;
	}
	public String getNotificationsPartie() {
		return notificationsPartie;
	}
	public void setNotificationsPartie(String notificationsPartie) {
		this.notificationsPartie = notificationsPartie;
	}
	
	public boolean isPartieTerminee() {
		return partieTerminee;
	}
	public void setPartieTerminee(boolean partieTerminee) {
		this.partieTerminee = partieTerminee;
	}
	public boolean isJouer() {
		return jouer;
	}
	public void setJouer(boolean jouer) {
		this.jouer = jouer;
	}
	public boolean isNewAdversaire() {
		return newAdversaire;
	}
	public void setNewAdversaire(boolean newAdversaire) {
		this.newAdversaire = newAdversaire;
	}
	public String[] getInfosAdversaire() {
		return infosAdversaire;
	}
	public void setInfosAdversaire(String[] infosAdversaire) {
		this.infosAdversaire = infosAdversaire;
	}
	public boolean isEnJeu() {
		return enJeu;
	}
	public void setEnJeu(boolean enJeu) {
		this.enJeu = enJeu;
	}
}
