package fr.poker.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane; //TO DO à supprimer uniquement présent pour les test

import fr.poker.model.*;
import fr.poker.view.Vjeu;
import fr.poker.view.VjeuClient;

public class Cclient implements Runnable {
	public JoueurClient j;
	private VjeuClient vJeu;
	private Compte compte;
	protected BufferedReader in;
	protected PrintStream out;
	protected boolean partieTerminee;
	public Cclient(Compte c) {
		this.compte = c;
	}
	public Cclient(Socket socket, int idjoueur) throws Exception{
		//On lance la communication
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintStream(socket.getOutputStream());
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		(new Thread(this)).start();
		this.j = new JoueurClient(idjoueur);
		this.vJeu = new VjeuClient(this);
		this.partieTerminee = false;
		
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
			System.out.println("Coix adversaire");
			break;
		case ConstantesClient.GAINPARTIE :
			System.out.println("Gain Partie");
			break;
		case ConstantesClient.PARTIE_GAGNEE :
			System.out.println("Partie Gangnee");
			break;
		case ConstantesClient.JOUE :
			System.out.println("Je joue");
			//à toi de jouer
			break;
		case ConstantesClient.NOUVEL_ADVERSAIRE :
			System.out.println("Nouvel adversaire");
			break;
		case ConstantesClient.ADVERSAIRE_OUT :
			System.out.println("L'adversaire à quitter la partie");
			break;
		}
		//On notifie à la vue les changements
		j.setChangedView();
	}

		
	@Override
	public void run() {
		while(!partieTerminee) {
			try {
				String message = in.readLine();
				traiterMessage(message);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void lancementClient() {
		
		
		
		// TODO : cette fonction va remplacer le main plus bas
	}
	
	public static void main(String[] args) throws Exception { // Cette méthode ne sera plus un main et sera appelée par l'action du bouton rejoindre salle
		String monid = JOptionPane.showInputDialog
		(null, "Donner l'id du nouveau joueur");
		String pseudo = JOptionPane.showInputDialog
		(null, "Votre pseudo");
		int cagnotte = 50;

		int portSalle = 4555; // Le port sera trasnmis par la méthode réécrite
		//TODO : adresse du serveur 
		Socket socket = new Socket("127.0.0.1", portSalle);
		System.out.println(Integer.parseInt(monid));
		Cclient c = new Cclient(socket, Integer.parseInt(monid));
		//On envoie l'id du joueur
		c.out.println(ConstantesServeur.MESINFORMATIONS+" "+monid+" "+pseudo+" "+cagnotte);
	}

	public PrintStream getOut() {
		return out;
	}
	
}
