package fr.poker.model.chat.client;
import java.io.*;
import java.net.*;

public class Client {

	public static Socket socket = null;
	public static Thread t1;
	
	public static void main(String[] args) {
	
		
	try {
		
		System.out.println("Demande de connexion");
		//socket = new Socket("127.0.0.1",5009);
		socket = new Socket("172.23.2.15",5009);
		System.out.println("Connexion �tablie avec le serveur, authentification :"); // Si le message s'affiche c'est que je suis connect�
		
		t1 = new Thread(new Connexion(socket));
		t1.start();
		
		
		
	} catch (UnknownHostException e) {
	  System.err.println("Impossible de se connecter � l'adresse "+socket.getLocalAddress());
	} catch (IOException e) {
	  System.err.println("Aucun serveur � l'�coute du port "+socket.getLocalPort());
	}
	
	

	}

}
