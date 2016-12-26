package fr.poker.model.chat.Serveur;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import fr.poker.view.Vjeu;


public class Reception implements Runnable {

	private BufferedReader in;
	private String message = null, login = null;
	public int i = 0;
	public String MessageAfficher;
	static public ArrayList<String> array_L=new ArrayList<String>();
	public Reception(BufferedReader in, String login,ArrayList<String> array_Liste){
		array_L=array_Liste;
		this.in = in;
		this.login = login;
	}
	
	public void run() {
		
		while(true){
	        try {
			message = in.readLine();
			System.out.println(login+" dit"+" : "+message);
			MessageAfficher= login+" dit"+" : "+message;
			array_L.add(MessageAfficher);
			//listeMessage[i] = MessageAfficher;
			
			//System.out.println(listeMessage);
			//Vjeu window = new Vjeu("message parametre du serveur");
			//i++;
			//System.out.println("i= "+ i);
			System.out.println("Voici ma liste :");
			 for(String elem: array_L)
		       {
		       	 System.out.println (elem);
		       }
//			System.out.println(listeMessage[i]);
//			if(i!=0){
//				for(int y=0; y<i; i++){
//					System.out.println(listeMessage[i]);
//				}
			//}
		    } catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

}
