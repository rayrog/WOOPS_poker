package fr.poker;
import fr.poker.model.*;
public class Poker {

	public static void main(String[] args) {
		Paquet paq = new Paquet("Jeu de 52 cartes");
		
		System.out.println(paq);
		System.out.println(paq.piocher());
		System.out.println(paq);
	}

}
