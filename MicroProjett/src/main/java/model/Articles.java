package model;

public class Articles {
	
	private String codeArticle;
	private String designation;
	private double prix;
	private int stock;
	private String categorie;
	private String photo;
	
	

	public Articles(String codeArticle, String designation, double prix, int stock, String categorie, String photo) {
		super();
		this.codeArticle = codeArticle;
		this.designation = designation;
		this.prix = prix;
		this.stock = stock;
		this.categorie = categorie;
		this.photo = photo;
	}



	public String getCodeArticle() {
		return codeArticle;
	}



	public String getDesignation() {
		return designation;
	}



	public double getPrix() {
		return prix;
	}



	public int getStock() {
		return stock;
	}



	public String getCategorie() {
		return categorie;
	}



	public String getPhoto() {
		return photo;
	}



	public Articles() {
		// TODO Auto-generated constructor stub
	}

	

	

}
