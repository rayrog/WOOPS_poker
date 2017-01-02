package fr.poker.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import fr.poker.model.ConstantesServeur;
import fr.poker.model.Salle;
/**
 * 
 * @author mflorycelini
 *
 */
public class CgestionSalle implements Runnable{
	protected BufferedReader in;
	protected PrintStream out;
	private Salle nouvelleSalle;
	public CgestionSalle(Socket socket) throws Exception{
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
	
	public void lancementNouvelleSalle (String nom, boolean privat, String hash, int nouveauPort) throws Exception{
		nouvelleSalle = new Salle(nom, privat, hash, nouveauPort);
		nouvelleSalle.lancement();
	}
	
	public void traiterMessage(String message) throws Exception { 
		Scanner scan = new Scanner(message);
		int type = scan.nextInt();
		switch(type){
		case ConstantesServeur.CREERSALLE :
			int nouveauPort = scan.nextInt();
			String nomSalle = scan.next();
			String hash = scan.next();
			boolean privat = scan.nextBoolean();
			System.out.println("Je cree une nouvelle salle avec le port :"+nouveauPort);
			lancementNouvelleSalle(nomSalle, privat, hash, nouveauPort);
			break;
		}
	}
	
	@Override
	public void run() {
		String message;
		try {
			message = in.readLine();
			while(true) {
				traiterMessage(message);
				message = in.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		//Port sera trasnmis lors de la création
		int portServeur = 4554;
		ServerSocket  serveur =  new ServerSocket(portServeur);
		CgestionSalle gestionSalle = new CgestionSalle(serveur.accept());		
	}
}
