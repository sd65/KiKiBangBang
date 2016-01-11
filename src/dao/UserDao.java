package dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Admin;
import bean.NormalUser;

public class UserDao {
	
	public final static int TYPEUSER_ADMIN = 0;
	public final static int TYPEUSER_NORMALUSER = 1;
	public final static int ACCOUNTSTATUS_ACTIVE = 1;
	public final static int ACCOUNTSTATUS_INACTIVE = 0;
	
	
	public static int insert(NormalUser u) {
		int res = 0;
				
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			
			//Requete
			String sql = "INSERT INTO person(email,password,familyname,firstname,adress,phone,creationdate,typeuser,availablefunds,accountstatus,lastconnexiondate) " +
					"VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFamilyName());
			ps.setString(4, u.getFirstName());
			ps.setString(5, u.getAddress());
			ps.setString(6, u.getTelephone());
			ps.setDate(7, (java.sql.Date) u.getCreationDate());
			ps.setInt(8, TYPEUSER_NORMALUSER);
			ps.setBigDecimal(9, u.getFunds());
			ps.setInt(10, ACCOUNTSTATUS_ACTIVE);
			Date newDate = new Date();
			java.sql.Date d = new java.sql.Date(newDate.getTime());
			ps.setDate(11, d);
			
			
			//Execution et traitement de la reponse
			res = ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
	
	public static int insert(Admin u) {
		int res = 0;
				
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			
			//Requete
			String sql = "INSERT INTO person(email,password,familyname,firstname,adress,phone,creationdate,typeuser) " +
					"VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFamilyName());
			ps.setString(4, u.getFirstName());
			ps.setString(5, u.getAddress());
			ps.setString(6, u.getTelephone());
			ps.setDate(7, (java.sql.Date) u.getCreationDate());
			ps.setInt(8, TYPEUSER_ADMIN);
			
			
			//Execution et traitement de la reponse
			res = ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
	
	public static int update(NormalUser u) {
		int res = 0;
				
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			
			//Requete
			String sql = "UPDATE person SET email=?,password=?,familyname=?,firstname=?,adress=?,phone=?,creationdate=?,typeuser=?,availablefunds=?,accountstatus=?,lastconnexiondate=? " +
					"WHERE id=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFamilyName());
			ps.setString(4, u.getFirstName());
			ps.setString(5, u.getAddress());
			ps.setString(6, u.getTelephone());
			ps.setDate(7, (java.sql.Date) u.getCreationDate());
			ps.setInt(8, TYPEUSER_NORMALUSER);
			ps.setBigDecimal(9, u.getFunds());
			ps.setBoolean(10, true);
			ps.setDate(11, (java.sql.Date) new Date());
			ps.setInt(12, u.getId());
			
			
			//Execution et traitement de la reponse
			res = ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
}
