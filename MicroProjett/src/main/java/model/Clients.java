package model;

public class Clients {
	
	private String Nom;
	private String Prenom;
	private String Adresse;
	private String Ville;
	private int CodePostal;
	private String Email;
	private String password;
	public String getTel() {
		return Tel;
	}

	private String Tel;
	
	
	public Clients(String nom, String prenom, String adresse, String ville, int codePostal, String email,
			String password, String TEL) {
		super();
		Nom = nom;
		Prenom = prenom;
		Adresse = adresse;
		Ville = ville;
		CodePostal = codePostal;
		Email = email;
		Tel = TEL;
		this.password = password;
	}

	public String getNom() {
		return Nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public String getAdresse() {
		return Adresse;
	}

	public String getVille() {
		return Ville;
	}

	public int getCodePostal() {
		return CodePostal;
	}

	public String getEmail() {
		return Email;
	}

	public String getPassword() {
		return password;
	}
	
	

}
