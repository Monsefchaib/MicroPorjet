package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;



public class ConnectDB {
	Connection conn;
	Statement st;
	ResultSet rs;
	
	
	public Connection getConnection() throws ClassNotFoundException {	
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		System.out.println("connecting to db");
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://mysql-27512-0.cloudclusters.net:27520/Commandes", "root", "root1234");
			return conn;
		}catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
			return null;
		}
	}
		
	void executeQuery(String query) throws ClassNotFoundException {
		Connection conn = getConnection();
		Statement st;
		
		try {
			st = conn.createStatement();
			st.executeUpdate(query);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public void addUser(Clients cl) throws ClassNotFoundException {
		String query = "Insert into clients ( `Email`, `Nom`, `Prenom`, `Adresse`, `CodePostal`, `Ville`, `Tel`, `MotPasse`) Values ('"+cl.getEmail()+"','"+cl.getNom()+"', '"+cl.getPrenom()+"','"+cl.getAdresse()+"', "+cl.getCodePostal()+",'"+cl.getVille()+"', '"+cl.getTel()+"','"+cl.getPassword()+"')";
		executeQuery(query);
	}
	
	public String getUsername(String login) throws ClassNotFoundException {
		conn = getConnection();
		String fullname=null;
		String query = "SELECT `Nom`,`Prenom` FROM clients WHERE Email = '"+login+"'";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				fullname = rs.getString("Nom") +" "+ rs.getString("Prenom");
				System.out.println(fullname);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return fullname;	
	}
	
	public Boolean verifyLogin(String login, String mdp) throws ClassNotFoundException {
		
		String motp=null;
		conn = getConnection();
		String query = "SELECT `MotPasse` FROM clients WHERE Email = '"+login+"'";
		
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				motp = rs.getString("MotPasse");
				System.out.println(motp);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Password Invalid");
		}
		System.out.println(mdp);
		System.out.println(motp);
		if(mdp.equals(motp)) {
			System.out.println("trueee");
			return true;
		}else {
			return false;
		}	
		
	}
	
	public void fermeBase() {
		try { st.close();
		conn.close(); }
		catch (Exception E) {
		E.printStackTrace();
		}
		}
	
	public ArrayList<Articles> articlesInfo(String type) throws ClassNotFoundException {
		ArrayList<Articles> arr = new ArrayList<Articles>();
		conn = getConnection();
		String query = "SELECT \n"
				+ "articles.CodeArticle,\n"
				+ "articles.Designation,\n"
				+ "articles.Prix,\n"
				+ "articles.Stock,\n"
				+ "articles.Categorie,\n"
				+ "articles.Photo\n"
				+ "FROM articles\n"
				+ "JOIN categories\n"
				+ "ON articles.Categorie=categories.RefCat\n"
				+ "WHERE categories.Cat='"+type+"'";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				Articles ar = new Articles(rs.getString("CodeArticle"),rs.getString("Designation"),Double.parseDouble(rs.getString("Prix")),Integer.parseInt(rs.getString("Stock")),rs.getString("Categorie"),rs.getString("Photo"));
				arr.add(ar);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		return arr;
		
		
		
		
		
		
	}
	

	public ArrayList<Articles> articlesInfoId(int id) throws ClassNotFoundException {
		ArrayList<Articles> arr = new ArrayList<Articles>();
		conn = getConnection();
		String query = "SELECT \n"
				+ "articles.CodeArticle,\n"
				+ "articles.Designation,\n"
				+ "articles.Prix,\n"
				+ "articles.Stock,\n"
				+ "articles.Categorie,\n"
				+ "articles.Photo\n"
				+ "FROM articles\n"
				+ "JOIN categories\n"
				+ "ON articles.Categorie=categories.RefCat\n"
				+ "WHERE articles.CodeArticle="+id+"";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				Articles ar = new Articles(rs.getString("CodeArticle"),rs.getString("Designation"),Double.parseDouble(rs.getString("Prix")),Integer.parseInt(rs.getString("Stock")),rs.getString("Categorie"),rs.getString("Photo"));
				arr.add(ar);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		for (int i = 0; i < arr.size(); i++) {
			System.out.println("TEEEESSSSTT");
            System.out.println(arr.get(i).getCategorie());
        }
		
		return arr;
		
		
		
		
		
		
	}
	
	
	
	
}
