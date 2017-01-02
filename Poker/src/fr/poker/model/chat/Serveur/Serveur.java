package fr.poker.model.chat.Serveur;
import java.io.*;
import java.net.*;

public class Serveur {
 public static ServerSocket ss = null;
 public static Thread monthread;

 public Serveur(int portChat) {
		try {
			ss = new ServerSocket(portChat);
			System.out.println("Le serveur est est à l'écoute du port"+ss.getLocalPort());
			
			monthread = new Thread(new Accepter_connexion(ss));
			monthread.start();
			
		} catch (IOException e) {
			System.err.println("Le port "+ss.getLocalPort()+" est déja utilisé!");
		}
	
	}
}


