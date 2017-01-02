package fr.poker.model.chat.Serveur;
import java.io.*;
import java.net.*;

public class Serveur {
 public static ServerSocket ss = null;
 public static Thread monthread;

<<<<<<< HEAD
 public Serveur(int portChat) {
		try {
			ss = new ServerSocket(portChat);
			System.out.println("Le serveur est est à l'écoute du port"+ss.getLocalPort());
=======
 
	public static void main(String[] args) {
		int portChat = 5009;
		try {
			ss = new ServerSocket(portChat);
			System.out.println("Le serveur est est à l'écoute du port "+ss.getLocalPort());
>>>>>>> master
			
			monthread = new Thread(new Accepter_connexion(ss));
			monthread.start();
			
		} catch (IOException e) {
			System.err.println("Le port "+ss.getLocalPort()+" est déja utilisé!");
		}
	
	}
}


