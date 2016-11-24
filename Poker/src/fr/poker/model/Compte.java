package fr.poker.model;
/***********************************************************************
 * Module:  Compte.java
 * Author:  Rayan
 * Purpose: Defines the Class Compte
 ***********************************************************************/

import java.util.*;

/** @pdOid 8902f8c9-f17e-4df7-8098-2aec67d74285 */
public class Compte {
	/** @pdOid 5ec4455c-bc6d-476e-8bee-4c53f9b49756 */
	private int id;
	/** @pdOid 28e6ef37-bcc7-4348-aa48-1016312a1c47 */
	private String pseudo;
	/** @pdOid 89dc4d5f-925f-4aa5-b995-df070b561fac */
	private String nom;
	/** @pdOid 82001975-bef7-4e0b-b4a6-b519361d5a16 */
	private String prenom;
	/** @pdOid 564c8461-4f5b-4167-96f4-52cd4ebc17ac */
	private String mail;
	/** @pdOid 8ef7913c-320e-48e9-9031-463eb921cbfa */
	private int tel;
	/** @pdOid 2872dcf1-66d0-4492-a534-71628307821a */
	private int hash;
	/** @pdOid 1358fb7a-9b9c-4fe4-bb00-d42824686eb7 */
	private int credit;
	/** @pdOid 34249d47-6e4d-4fbd-8b36-269f80caa2a5 */
	private String bio;

	/** @pdRoleInfo migr=no name=Joueur assc=association87 mult=0..1 */
	public Joueur joueur;

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

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public int getHash() {
		return hash;
	}

	public void setHash(int hash) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bio == null) ? 0 : bio.hashCode());
		result = prime * result + credit;
		result = prime * result + hash;
		result = prime * result + id;
		result = prime * result + ((joueur == null) ? 0 : joueur.hashCode());
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((pseudo == null) ? 0 : pseudo.hashCode());
		result = prime * result + tel;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compte other = (Compte) obj;
		if (bio == null) {
			if (other.bio != null)
				return false;
		} else if (!bio.equals(other.bio))
			return false;
		if (credit != other.credit)
			return false;
		if (hash != other.hash)
			return false;
		if (id != other.id)
			return false;
		if (joueur == null) {
			if (other.joueur != null)
				return false;
		} else if (!joueur.equals(other.joueur))
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (pseudo == null) {
			if (other.pseudo != null)
				return false;
		} else if (!pseudo.equals(other.pseudo))
			return false;
		if (tel != other.tel)
			return false;
		return true;
	}

}