package fr.poker.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class JoueurServeur extends Joueur implements Runnable{
	protected BufferedReader in;
	protected PrintStream out;
	public JoueurServeur(Socket socket) throws Exception{
		super();
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintStream(socket.getOutputStream());
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		//On lance la communication
		(new Thread(this)).start();
	}
	
	public void traiterMessage(String message) { //message représente les informations envoyés par le controleur Cpartie
		Scanner scan = new Scanner(message);
		int type = scan.nextInt();
		switch(type){
		case ConstantesServeur.MISER :
			System.out.println("Je mise ");
			miser(50); //TO DO
			break;
		case ConstantesServeur.SECOUCHER :
			System.out.println("Je me couche ");
			break;
		case ConstantesServeur.RELANCER :
			System.out.println("Je relance ");
			break;
		case ConstantesServeur.QUITTERSALLE :
			System.out.println("Je quitte la salle ");
			break;
		}
	}
	
	@Override
	public void run() {
		while(!partieFinie) {
			
		}
		
	}
}
