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
	
	@SuppressWarnings("deprecation")
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
			String mise = scan.next();
			System.out.println(this.getPseudo()+" mise " + mise);
			this.miser(Double.parseDouble(mise));
			break;
			
		case ConstantesServeur.SECOUCHER :
			System.out.println(this.getPseudo()+" se couche ");
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
			misePlusHaute = maSalle.getTable().getBestMise();
			System.out.println("Je suis de "+Double.toString(misePlusHaute-this.getMise()));
			this.miser(misePlusHaute-this.getMise());
			break;
		case ConstantesServeur.CHECK :
			System.out.println(this.getPseudo() + " check");
			this.miser(0.0);
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
			if(montant + mise >= maSalle.getTable().getBestMise()){ //On vérifie qu'on mise au moins pour suivre
				creditPartie -= montant;
				mise += montant;
				maSalle.getTable().setPot(maSalle.getTable().getPot() + mise);
				
				if(montant > maSalle.getTable().getBestMise()) //En cas de relance
					maSalle.getTable().setBestMise(mise);		//update la mise a suivre
				
				maSalle.getMaPartie().setJoueurCourantParle(false);
			}else
				this.out.println(ConstantesClient.NOTIFICATIONSPARTIE+" "+"Mise%insuffisante");			
		}
		else{
			System.out.println("Credit insuffisant pour miser " + montant);
			this.out.println(ConstantesClient.NOTIFICATIONSPARTIE+" "+"Credit%insuffisant%pour%miser%ce%montant");
		}
	}

	public PrintStream getOut() {
		return out;
	}

	public void setOut(PrintStream out) {
		this.out = out;
	}

	@SuppressWarnings("deprecation")
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
