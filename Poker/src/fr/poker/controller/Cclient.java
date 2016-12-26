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
	public Cclient(Socket socket) throws Exception{
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintStream(socket.getOutputStream());
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		(new Thread(this)).start();
		//adversaire = new Joueur(); // à voir
		this.vJeu = new Vjeu(this);
		this.j = new JoueurClient(socket);
		
	}
	
	public void traiterMessage(String message) { //message représente les informations envoyés par le controleur Cpartie
		Scanner scan = new Scanner(message);
		int type = scan.nextInt();
		switch(type){
		case Constantes.POT :
			break;
		case Constantes.TOURGAGNE :
			break;
		case Constantes.GAINTOUR :
			break;
		case Constantes.PERTETOUR :
			break;
		case Constantes.CHOIX_ADVERSAIRE :
			break;
		case Constantes.GAINPARTIE :
			break;
		case Constantes.PARTIE_GAGNEE :
			break;
		case Constantes.JOUE :
			break;
		case Constantes.NOUVEL_ADVERSAIRE :
			break;
		case Constantes.ADVERSAIRE_OUT :
			break;
		}
		//On notifie à la vue les changements
		j.setChangedView();
		}
		//TO DO Tous les cases (donc switchcase) à traiter : gangner perdu , choix adversaire

		
	
	@Override
	public void run() {

	}
	public static void main(String[] args) throws Exception { // Cette méthode ne sera plus un main et sera appelée par l'action du bouton rejoindre salle
		int portServeur = 4555; // Le port sera trasnmis par la méthode réécrite
		Socket socket = new Socket("172.23,2,15", portServeur);
		Cclient c = new Cclient(socket);
	}
	
}
