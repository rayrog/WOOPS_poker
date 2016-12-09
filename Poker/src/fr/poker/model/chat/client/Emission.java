package fr.poker.model.chat.client;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import fr.poker.view.Vjeu;


public class Emission implements Runnable {

	private PrintWriter out;
	private String login = null, message = null;
	private Scanner sc = null;
	
	public Emission(PrintWriter out) {
		this.out = out;
		
	}

	
	public void run() {
		
		  sc = new Scanner(System.in);
		  
		  while(true){
			    System.out.println("Votre message :");
				message = sc.nextLine();
				out.println(message);
			    out.flush();
			    Vjeu window = new Vjeu(message);
			    window.frame.setVisible(true);
			  }
	}
}
