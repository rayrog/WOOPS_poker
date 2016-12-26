package fr.poker.model.chat.client;
import java.io.*;
import java.net.*;

public class Client {

	public static Socket socket = null;
	public static Thread monthread;
	
	public static void main(String[] args) {
		runClient();
	}
//	try {
//		
//		System.out.println("Demande de connexion");
//		//socket = new Socket("127.0.0.1",5009);
//		socket = new Socket("172.23.2.15",5009);
//		System.out.println("La connexion avec le serveur est ok :"); // Si le message s'affiche c'est que je suis connect�
//		
//		monthread = new Thread(new Connexion(socket));
//		monthread.start();
//		
//		
//		
//	} catch (UnknownHostException e) {
//	  System.err.println("Impossible de se connecter � l'adresse "+socket.getLocalAddress());
//	} catch (IOException e) {
//	  System.err.println("Aucun serveur � l'�coute du port "+socket.getLocalPort());
//	}
//	
//	
//
//	}
	
	public static void runClient() {
		
		try{
		System.out.println("Demande de connexion");
		//socket = new Socket("127.0.0.1",5009);
		socket = new Socket("172.23.2.15",5009);
		System.out.println("La connexion avec le serveur est ok :"); // Si le message s'affiche c'est que je suis connect�
		
		monthread = new Thread(new Connexion(socket));
		monthread.start();
		
		
		
	} catch (UnknownHostException e) {
	  System.err.println("Impossible de se connecter � l'adresse "+socket.getLocalAddress());
	} catch (IOException e) {
	  System.err.println("Aucun serveur � l'�coute du port "+socket.getLocalPort());
	}
	}
}

