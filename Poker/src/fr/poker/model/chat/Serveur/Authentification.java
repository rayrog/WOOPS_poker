package fr.poker.model.chat.Serveur;
import java.net.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import fr.poker.model.Joueur;
import fr.poker.model.JoueurClient;

import java.io.*;

public class Authentification implements Runnable {
	public JoueurClient j;
	private Socket socket;
	private PrintWriter out = null;
	private BufferedReader in = null;
	private String login = "toto", pass =  null;
	public boolean authentifier = false;
	public Thread t2;
	
	public Authentification(Socket s){
		 socket = s;
		}
	public void run() {
	
		try {
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			
		while(!authentifier){
//			out.println("Entrez votre login :");
//			out.flush();
//			login = in.readLine();
//			
//			
//			out.println("Entrez votre mot de passe :");
//			out.flush();
//			pass = in.readLine();
			login = j.getPseudo();
			//if(isValid(login, pass)){
			if(isValid(login)){	
				out.println("connecte");
				System.out.println(login +" vient de se connecter ");
				out.flush();
				authentifier = true;	
			}
			else {out.println("erreur"); out.flush();}
		 }
		//}
			System.out.println("je vais lancer chat client-serveur");
			// Création de la liste
			ArrayList<String> array_Liste=new ArrayList<String>();
			t2 = new Thread(new Chat_ClientServeur(socket,login,array_Liste));
			t2.start();
			
		} catch (IOException e) {
			
			System.err.println(login+" ne répond pas !");
		}
		
	}
	
//private static boolean isValid(String login, String pass) {
//		boolean connexion = false;
////		if ("user".equals(login) && "user".equals(pass) || "user2".equals(login) && "user2".equals(pass)){
////			connexion=true;
////			return connexion;
////		}
////		else{
////			return connexion;
////		}	
//		
//	}
	private static boolean isValid(String login) {
		return true;
	}

}
