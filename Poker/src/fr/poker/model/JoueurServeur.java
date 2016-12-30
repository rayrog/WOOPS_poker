package fr.poker.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import fr.poker.controller.CpartieServeur;

public class JoueurServeur extends Joueur implements Runnable{
	private Salle maSalle;
	protected BufferedReader in;
	protected PrintStream out;
	public JoueurServeur(Socket socket, Salle salle) throws Exception{
		super();
		this.maSalle = salle;
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintStream(socket.getOutputStream());
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		//On lance la communication
		(new Thread(this)).start();
		this.setNumeroJoueurTable(-1); // on met l'id à -1
	}
	
	public void traiterMessage(String message) { //message représente les informations envoyés par le controleur Cpartie
		Scanner scan = new Scanner(message);
		int type = scan.nextInt();
		switch(type){
		case ConstantesServeur.MESINFORMATIONS:
			int id = scan.nextInt();
			setId(id);
			String pseudo = scan.next();
			setPseudo(pseudo);
			int potJoueur = scan.nextInt();
			System.out.println("Mon pot "+potJoueur);
			setCreditPartie(potJoueur);
			System.out.println("Je renseigne mon ID "+id+" mon PSEUDO "+pseudo+" mon CREDIT DE DEPART "+potJoueur);
			maSalle.setAjoutSuccess(true);
			break;
		case ConstantesServeur.MISER :
			System.out.println("Je suis le joueur "+getId()+" et je mise ");
			//miser(50); //TO DO
			break;
		case ConstantesServeur.SECOUCHER :
			System.out.println("Je suis le joueur "+getId()+" et je me couche ");
			break;
		case ConstantesServeur.RELANCER :
			System.out.println("Je relance ");
			break;
		case ConstantesServeur.REJOINDRETABLE :
			System.out.println("Je rejoint la table de jeu");
			maSalle.rejoindre(this);
			break;
		case ConstantesServeur.QUITTERSALLE :
			System.out.println("Je suis le joueur "+getId()+" et je quitte la salle ");
			break;
		}
	}
	
	public PrintStream getOut() {
		return out;
	}

	public void setOut(PrintStream out) {
		this.out = out;
	}

	@Override
	public void run() {
		String message;
		try {
			message = in.readLine();
			while(!partieFinie) {
				traiterMessage(message);
				message = in.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
