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
	private Double misePlusHaute;
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
		this.mise = 0.0;
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
			System.out.println("Je suis le joueur "+getPseudo()+" et je mise ");
			String mise = scan.next();
			this.miser(Double.parseDouble(mise));
			break;
		case ConstantesServeur.SECOUCHER :
			System.out.println("Je suis le joueur "+getPseudo()+" et je me couche ");
			this.coucher();
			maSalle.getMaPartie().setJoueurCourantParle(false);
			break;
		case ConstantesServeur.RELANCER :
			for(JoueurServeur j : maSalle.getTable().getJoueursEnJeu()){
				if(misePlusHaute < j.getMise()) misePlusHaute = j.getMise();		
			}
			System.out.println("Je relance de "+Double.toString(this.getMise()-misePlusHaute));
			this.relancer(this.getMise()-misePlusHaute);
			break;
		case ConstantesServeur.SUIVRE :
			System.out.println("Je suis");
			misePlusHaute = 0.0;
			for(JoueurServeur joueur : maSalle.getTable().getJoueursEnJeu()){
				if(misePlusHaute < joueur.getMise()) misePlusHaute = joueur.getMise();		
			}
			System.out.println("Je suis de "+Double.toString(misePlusHaute-this.getMise()));
			this.suivre(misePlusHaute-this.getMise());
			break;
		case ConstantesServeur.CHECK :
			System.out.println("Je check");
			this.setaSuivi(true);
			maSalle.getMaPartie().setJoueurCourantParle(false);
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
	

	public void miser(Double montant) {
		if (creditPartie - montant >= 0) {
			creditPartie -= montant;
			mise = montant;
			maSalle.getTable().setPot(maSalle.getTable().getPot() + mise);
			maSalle.getMaPartie().setJoueurCourantParle(false);
		}
		else{
			System.out.println("Credit insuffisant pour miser " + montant);
			this.out.println(ConstantesClient.NOTIFICATIONSPARTIE+" "+"Credit%insuffisant%pour%miser%ce%montant");
		}
	}

	public void relancer(Double montant) {
		if (creditPartie - montant >= 0) {
			creditPartie -= montant;
			mise += montant;
			maSalle.getTable().setPot(maSalle.getTable().getPot() + mise);
			for (Joueur j : maSalle.getTable().getJoueursEnJeu()) { // On réinitialise le
				// flag aSuivi en cas de
				// relance
				j.setaSuivi(false);
			}
			setaSuivi(true);
			maSalle.getMaPartie().setJoueurCourantParle(false);
		} else {
			System.out.println("Credit insuffisant");
			this.out.println(ConstantesClient.NOTIFICATIONSPARTIE+" "+"Credit%insuffisant%pour%miser%ce%montant");
		}
	}

	public void suivre(Double montantPrecedent) {// Pour utiliser cette
													// fonction il faut faire un
													// getMise()
		if (creditPartie - montantPrecedent >= 0) { // sur le joueur précedent
			// et le proposer en
			// parametre.
			mise += montantPrecedent;
			maSalle.getTable().setPot(maSalle.getTable().getPot() + mise);
			setaSuivi(true);
			maSalle.getMaPartie().setJoueurCourantParle(false);
		} else {
			System.out.println("Credit insuffisant");
			this.out.println(ConstantesClient.NOTIFICATIONSPARTIE+" "+"Credit%insuffisant%pour%suivre");
			setaSuivi(false);
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
