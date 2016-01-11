package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;



public final class ConnexionBDD {
	private static Logger LOGGER = Logger.getAnonymousLogger();
	private static volatile ConnexionBDD instance;
	private Connection cnx; 
	
	public final static String DATABASE_DRIVER = "org.postgresql.Driver";
	public final static String DATABASE_URL = "jdbc:postgresql://localhost:5432/kikibangbang";
	public final static String DATABASE_LOGIN = "postgres";
	public final static String DATABASE_PWD = "admin";
	
	private ConnexionBDD() {
		try {				
			// chargement du driver
			Class.forName(DATABASE_DRIVER);
			cnx = DriverManager.getConnection(DATABASE_URL,
					DATABASE_LOGIN, DATABASE_PWD);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
//		catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	} 
	
	public static synchronized ConnexionBDD getInstance() {
		if(instance==null)
			instance = new ConnexionBDD();
		
		return instance;
	}

	public Connection getCnx() {
		return cnx;
	}

	public void closeCnx() throws SQLException{
		if(cnx!=null){
			cnx.close();
			instance=null;
		}
	}
}
