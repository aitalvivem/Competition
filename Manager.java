package competition;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Manager {
	private Connection connection;
	
	// constructeur
	public Manager() {
		// pour arriver à se co : https://www.commentcamarche.net/forum/affich-18633582-echec-de-la-connexion-tcp-ip-a-l-hote-guettaf
		String url = "jdbc:sqlserver://DESKTOP-BL48RPL\\TEST_SQL:1433;databaseName=competition;integratedSecurity=true;";
		String user = "MicrosoftAccount\\\\aitalvivem@gmail.com";
		String pass = "Violent-Femme27";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connection = DriverManager.getConnection(url, user, pass);
			this.setConnection(connection);
			System.out.println("Je suis connecté à la bdd\n");
		}
		catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	// public void creeCompet(Competition compet)
	
	// destructeur
	public void destruct() {
		try {
			this.connection.close();
			System.out.println("\nconnection terminée.");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String[] getListCriteres() {
		String req = "SELECT libCritere, importance FROM critere";
		ArrayList<String> listeIntermediaire = new ArrayList<String>();
		String[] listCriteres = null;
		
		try {
			PreparedStatement st = this.connection().prepareStatement(req);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				String str = rs.getString("libCritere")+" ( /"+rs.getInt("importance")+")";
				listeIntermediaire.add(str);
			}
			
			listCriteres = new String[listeIntermediaire.size()] ;
			listeIntermediaire.toArray(listCriteres);
			
			st.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return listCriteres;
	}

	// mutateur
	public void setConnection(Connection co) {
		this.connection = co;
	}
	
	// accesseur
	public Connection connection() {
		return this.connection;
	}
}

