package fr.poker.model.chat.client;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import fr.poker.view.Vjeu;


public class Emission implements Runnable {

	private static PrintWriter out;
	private String login = null, message = null;
	private Scanner sc = null;
	
	public Emission(PrintWriter out) {
		this.out = out;
		
	}

	
	public static void run(String message) {
		
		  //sc = new Scanner(System.in);
		  Boolean etat = true;
		  while(etat){
			    System.out.println("Votre message :");
			    //out.println();
			    
				//message = sc.nextLine();
			    System.out.println(message);
			    System.out.flush();
				out.println(message);
			    out.flush();
			    //Vjeu window = new Vjeu(message);
			    //window.frame.setVisible(true);
			    etat=false;
			  }
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
