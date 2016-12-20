package fr.poker.model;

public class Compte {
	private int id;
	private String pseudo;
	private String nom;
	private String prenom;
	private String mail;
	private String tel;
	private String hash;
	private int credit;
	private String bio;
	public Joueur joueur;

	public Compte(int id, String pseudo, String nom, String prenom, String mail, String tel, String hash, int credit) {
		super();
		this.id = id;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.tel = tel;
		this.hash = hash;
		this.credit = credit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void createJoueur(float creditPartie) {
		this.joueur = new Joueur(this, creditPartie, this.pseudo);
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail
				+ ", tel=" + tel + ", hash=" + hash + ", credit=" + credit + ", bio=" + bio + ", joueur=" + joueur
				+ "]";
	}

}