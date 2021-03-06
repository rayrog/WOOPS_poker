package fr.poker.model.chat.Serveur;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;


public class Chat_ClientServeur implements Runnable {

	private Socket socket = null;
	private BufferedReader in = null;
	private PrintWriter out = null;
	private String login = "zero";
	private Thread t3, t4;
	ArrayList<String> array_Liste=new ArrayList<String>();
	
	
	public Chat_ClientServeur(Socket s, String log, ArrayList<String> array_Liste2){
		array_Liste=array_Liste2;
		socket = s;
		login = log;
	}
	public void run() {
		
		try {
		System.out.println("je suis dans chat client serveur");	
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		//out = new PrintWriter(socket.getOutputStream());
		ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
		
		Thread t3 = new Thread(new Reception(in,login,array_Liste));
		t3.start();
		Thread t4 = new Thread(new Emission(out));
		t4.start();
		
		} catch (IOException e) {
			System.err.println(login +"s'est déconnecté ");
		}
}
}
