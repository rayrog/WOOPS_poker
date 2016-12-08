package fr.poker.model.chat.Serveur;
import java.io.BufferedReader;
import java.io.IOException;

import fr.poker.view.Vjeu;


public class Reception implements Runnable {

	private BufferedReader in;
	private String message = null, login = null;
	
	public Reception(BufferedReader in, String login){
		
		this.in = in;
		this.login = login;
	}
	
	public void run() {
		
		while(true){
	        try {	
			message = in.readLine();
			System.out.println(login+"dit"+" : "+message);
			//Vjeu window = new Vjeu("message parametre du serveur");
			
		    } catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

}
