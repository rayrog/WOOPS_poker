package fr.poker.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class JoueurServeur extends Joueur {
	public JoueurServeur(Socket socket) {
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
}
