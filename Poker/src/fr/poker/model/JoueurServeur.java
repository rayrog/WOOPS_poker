package fr.poker.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import fr.poker.controller.CpartieServeur;

/**
 * 
 * @author mflorycelini
 *
 */
public class JoueurServeur extends Joueur implements Runnable{
	private Salle maSalle;
	protected BufferedReader in;
	protected PrintStream out;
	protected Thread t;
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
		this.t = new Thread(this);
		t.start();
		this.setNumeroJoueurTable(-1); // on met l'id à -1
	}
	
	public void traiterMessage(String message) throws Exception { //message représente les informations envoyés par le controleur Cpartie
		Scanner scan = new Scanner(message);
		int type = scan.nextInt();
		switch(type){
		case ConstantesServeur.MESINFORMATIONS:
			int id = scan.nextInt();
			setId(id);
			String pseudo = scan.next();
			setPseudo(pseudo);
			String potJoueur = scan.next();
			setCreditPartie(Double.parseDouble(potJoueur));
			//System.out.println("Je renseigne mon ID "+id+" mon PSEUDO "+pseudo+" mon CREDIT DE DEPART "+potJoueur);
			maSalle.setAjoutSuccess(true);
			break;
		case ConstantesServeur.MISER :
			System.out.println("Je suis le joueur "+getId()+" et je mise ");
			//miser(50); //TO DO
			break;
		case ConstantesServeur.SECOUCHER :
			System.out.println("Je suis le joueur "+getId()+" et je me couche ");
			this.coucher();
			System.out.println(maSalle.getMaPartie().isJoueurCourantParle());
			this.setDown(true);
			maSalle.getMaPartie().setJoueurCourantParle(false);
			break;
		case ConstantesServeur.RELANCER :
			System.out.println("Je relance de");
			break;
		case ConstantesServeur.SUIVRE :
			System.out.println("Je suis");
			break;
		case ConstantesServeur.REJOINDRETABLE :
			System.out.println("Je rejoint la table de jeu");
			maSalle.rejoindre(this);
			break;
		case ConstantesServeur.QUITTERSALLE :
			System.out.println("Je suis le joueur "+getId()+" et je quitte la salle ");
			maSalle.quitter(this);
			if(this.etat) maSalle.table.quitter(this);
			t.stop();
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
			System.out.println("Joueur déconnecter");
			e.printStackTrace();
			try {
				maSalle.quitter(this);
				t.stop();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
