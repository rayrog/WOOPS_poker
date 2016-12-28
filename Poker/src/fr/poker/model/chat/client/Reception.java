package fr.poker.model.chat.client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import fr.poker.view.Vjeu;


public class Reception implements Runnable {

	//private BufferedReader in;
	private String message = "coucou";
	private ObjectInputStream in;
	private ArrayList<String> array_Liste = new ArrayList<String>();
	public Reception(ObjectInputStream in){
		this.in = in;
	}
	
	public void run() {
		
		while(true){
	        try {
	        	Object objetRecu = in.readObject();
	            //int[] tableauRecu = (int[]) objetRecu;
	        	System.out.println("Voici mon in : " + objetRecu.toString());
	        	//array_Liste = (ArrayList<String>) objetRecu;	
	            //System.out.println("Client recoit: " + Arrays.toString(array_Liste));
				for(String elem: array_Liste)
			       {
			       	 System.out.println ("Voici mon élément:" + elem);
			       }
				System.out.println("Je vais lancer actualiser");
				Vjeu.actualiser(Vjeu.LayerChat, array_Liste);
				Thread.sleep(2000);
	            //System.out.println("Client recoit: " + Arrays.deepToString(array_Liste));
			//message = in.readLine();
			//System.out.println("Le serveur vous dit :" +message);
			
		    } catch (IOException e) {
				
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
