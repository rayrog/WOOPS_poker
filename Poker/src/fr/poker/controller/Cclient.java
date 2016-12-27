package fr.poker.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JFrame;

import fr.poker.model.*;
import fr.poker.view.Vjeu;

public class Cclient implements Runnable {
	public JoueurClient j;
	private Vjeu vJeu;
	protected BufferedReader in;
	protected PrintStream out;
	protected boolean partieTerminee;
	public Cclient(Socket socket) throws Exception{
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintStream(socket.getOutputStream());
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		//On lance la communication
		(new Thread(this)).start();
		//adversaire = new Joueur(); // à voir
		this.vJeu = new Vjeu(this);
		this.j = new JoueurClient(socket);
		this.partieTerminee = false;
		
	}
	
	public void traiterMessage(String message) { //message représente les informations envoyés par le controleur Cpartie
		Scanner scan = new Scanner(message);
		int type = scan.nextInt();
		switch(type){
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
			System.out.println("PArtie Gangnee");
			break;
		case ConstantesClient.JOUE :
			System.out.println("Nouvel adversaire");
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
	public static void main(String[] args) throws Exception { // Cette méthode ne sera plus un main et sera appelée par l'action du bouton rejoindre salle
		int portServeur = 4555; // Le port sera trasnmis par la méthode réécrite
		//TO DO adresse du serveur 
		Socket socket = new Socket("127.0.0.1", portServeur);
		Cclient c = new Cclient(socket);
	}
	
}
