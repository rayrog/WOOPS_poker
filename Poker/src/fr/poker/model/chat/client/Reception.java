package fr.poker.model.chat.client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.poker.view.Vjeu;
import fr.poker.view.VjeuClient;


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
				System.out.println("Je suis dans le while true");
	        try {
	        	System.out.println("Je suis dans le try");
	        	Object objetRecu = in.readObject();
	            String[] tableauRecu = (String[]) objetRecu;
	            System.out.println("J'ai mon tableau");
	            //List<List<String>> stuff = new ArrayList<List<String>>();
	            List<String> tabList = Arrays.asList(tableauRecu);
	        	for(String elem: tabList)
			       {
	        		array_Liste.add(elem);
			       }
	        	//System.out.println("Voici mon in : " + objetRecu.toString());
	        	//array_Liste = (ArrayList<String>) objetRecu;	
	            //System.out.println("Client recoit: " + Arrays.toString(array_Liste));
				for(String elem: tabList)
			       {
			       	 System.out.println ("Voici mon élément:" + elem);
			       }
				System.out.println("Je vais lancer actualiser");
				VjeuClient.actualiser(VjeuClient.LayerChat, array_Liste);
				Thread.sleep(500);
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
