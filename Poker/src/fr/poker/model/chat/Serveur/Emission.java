package fr.poker.model.chat.Serveur;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class Emission implements Runnable {
	
	private ObjectOutputStream out;
	//private PrintWriter out;
	private String message = "coucou";
	private Scanner sc = null;
	
	public Emission(ObjectOutputStream out) {
		this.out = out;
	}

	
	public void run() {
		
		  sc = new Scanner(System.in);
		  
		  while(true){
//			    System.out.println("Votre message :");
//				message = sc.nextLine();
//				out.println(message);
//			    out.flush();
			   		 
		        System.out.println("Serveur a cree les flux");
		 

		        try {
//					 for(String elem: Reception.array_L)
//				       {
//				       	 System.out.println (elem);
//				       	//out.writeObject(elem);
//				       }
		        	 System.out.println("Voici mon arraylist: "+Reception.array_L);
					 System.out.println("Je vais transmettre mon arraylist");
					 // Créer un tableau de même taille que le nombre d'objet de ArrayList
					 String tab[] = new String[Reception.array_L.size()];
					 
					 // Transformer Le ArrayList en Tableau
					 tab = Reception.array_L.toArray(tab);
					 
					 
					 //ByteArrayOutputStream bao = new ByteArrayOutputStream();
					 //ObjectOutputStream oos = new ObjectOutputStream(bao);
					 //oos.writeObject(Reception.array_L);
					 out.writeObject(tab);
					 System.out.println("Je viens de transmettre mon tableau");
					 Thread.sleep(2000);
			       	 //out.flush();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		 
		        System.out.println("Serveur: donnees emises");
			  }
	}
}
