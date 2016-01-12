package dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Logger;

import bean.Admin;
import bean.ApplicationConstants;
import bean.NormalUser;

public class UserDao {
	
	private static Logger LOGGER = Logger.getAnonymousLogger();

	public final static int TYPEUSER_ADMIN = 0;
	public final static int TYPEUSER_NORMALUSER = 1;

	/**
	 * Create new NormalUser in Database
	 * @param u NormalUser to create
	 * @return
	 */
	public static int insert(NormalUser u) {
		int res = 0;

		Connection cnx = null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();

			// Requete
			String sql = "INSERT INTO person(email,password,familyname,firstname,adress,phone,creationdate,typeuser,availablefunds,accountstatus,lastconnexiondate) "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFamilyName());
			ps.setString(4, u.getFirstName());
			ps.setString(5, u.getAddress());
			ps.setString(6, u.getTelephone());
			Date newDate = new Date();
			java.sql.Date d = new java.sql.Date(newDate.getTime());
			ps.setDate(7, d);
			ps.setInt(8, TYPEUSER_NORMALUSER);
			ps.setBigDecimal(9, u.getFunds());
			ps.setInt(10, ApplicationConstants.ACCOUNTSTATUS_ACTIVE);
			ps.setDate(11, d);

			// Execution et traitement de la reponse
			res = ps.executeUpdate();

			ConnexionBDD.getInstance().closeCnx();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	/**
	 * Create new Admin in Database
	 * @param u Admin to create
	 * @return
	 */
	public static int insert(Admin u) {
		int res = 0;

		Connection cnx = null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();

			// Requete
			String sql = "INSERT INTO person(email,password,familyname,firstname,adress,phone,creationdate,typeuser) "
					+ "VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFamilyName());
			ps.setString(4, u.getFirstName());
			ps.setString(5, u.getAddress());
			ps.setString(6, u.getTelephone());
			ps.setDate(7, (java.sql.Date) u.getCreationDate());
			ps.setInt(8, TYPEUSER_ADMIN);

			// Execution et traitement de la reponse
			res = ps.executeUpdate();

			ConnexionBDD.getInstance().closeCnx();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	/**
	 * Update a NormalUser
	 * @param u NormalUser to update
	 * @return
	 */
	public static int update(NormalUser u) {
		int res = 0;

		Connection cnx = null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();

			// Requete
			String sql = "UPDATE person SET email=?,password=?,familyname=?,firstname=?,adress=?,phone=?,creationdate=?,typeuser=?,availablefunds=?,accountstatus=?,lastconnexiondate=? "
					+ "WHERE id=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFamilyName());
			ps.setString(4, u.getFirstName());
			ps.setString(5, u.getAddress());
			ps.setString(6, u.getTelephone());
			java.sql.Date d = new java.sql.Date(u.getCreationDate().getTime());
			ps.setDate(7, d);
			ps.setInt(8, TYPEUSER_NORMALUSER);
			ps.setBigDecimal(9, u.getFunds());
			ps.setInt(10, ApplicationConstants.ACCOUNTSTATUS_ACTIVE);
			Date newDate = new Date();
			java.sql.Date dup = new java.sql.Date(newDate.getTime());
			ps.setDate(11, dup);
			ps.setInt(12, u.getId());

			// Execution et traitement de la reponse
			res = ps.executeUpdate();

			ConnexionBDD.getInstance().closeCnx();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	/**
	 * find all normal users
	 * @return list of NormalUser
	 */
	public static List<NormalUser> findAll() {

		List<NormalUser> lu = new ArrayList<NormalUser>();
		Connection cnx = null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

			// Requete
			String sql = "SELECT id,email,password,familyname,firstname,adress,phone,creationdate,typeuser,availablefunds,accountstatus,lastconnexiondate FROM person WHERE typeuser=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, TYPEUSER_NORMALUSER);

			// Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				NormalUser nu = new NormalUser();
				nu.setId(res.getInt("id"));
				nu.setEmail(res.getString("email"));
				nu.setPassword(res.getString("password"));
				nu.setFamilyName(res.getString("familyName"));
				nu.setFirstName(res.getString("firstName"));
				nu.setAddress(res.getString("adress"));
				nu.setTelephone(res.getString("phone"));
				java.sql.Date creationDateSql = res.getDate("creationdate");
				LOGGER.info(String.valueOf(creationDateSql.getTime()));
				Date creationDate = new Date(res.getDate("creationdate").getTime());
				nu.setCreationDate(creationDate);
				nu.setFunds(res.getBigDecimal("availablefunds"));
				nu.setAccountStatus(res.getInt("accountstatus"));
				Date lastConnexionDate = new Date(res.getDate("creationdate").getTime());
				nu.setLastConnexionDate(lastConnexionDate);
				lu.add(nu);
			}

			res.close();
			ConnexionBDD.getInstance().closeCnx();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//

		return lu;
	}
	
	/**
	 * Find an user by ID
	 * @param id
	 * @return
	 */
	public static NormalUser findUser(int id) {
		Connection cnx = null;
		NormalUser nu = new NormalUser();
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

			// Requete
			String sql = "SELECT id,email,password,familyname,firstname,adress,phone,creationdate,typeuser,availablefunds,accountstatus,lastconnexiondate FROM person WHERE id=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, id);

			// Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			while(res.next()){
				nu.setId(res.getInt("id"));
				nu.setEmail(res.getString("email"));
				nu.setPassword(res.getString("password"));
				nu.setFamilyName(res.getString("familyName"));
				nu.setFirstName(res.getString("firstName"));
				nu.setAddress(res.getString("adress"));
				nu.setTelephone(res.getString("phone"));
				java.sql.Date creationDateSql = res.getDate("creationdate");
				LOGGER.info(String.valueOf(creationDateSql.getTime()));
				Date creationDate = new Date(res.getDate("creationdate").getTime());
				nu.setCreationDate(creationDate);
				nu.setFunds(res.getBigDecimal("availablefunds"));
				nu.setAccountStatus(res.getInt("accountstatus"));
				Date lastConnexionDate = new Date(res.getDate("creationdate").getTime());
				nu.setLastConnexionDate(lastConnexionDate);
				break;
			}
			res.close();
			ConnexionBDD.getInstance().closeCnx();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nu;
	}
	
	/**
	 * Fin a normal user by email
	 * @param email
	 * @return
	 */
	public static NormalUser findUserByEmail(String email) {
		Connection cnx = null;
		NormalUser nu = new NormalUser();
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

			// Requete
			String sql = "SELECT id,email,password,familyname,firstname,adress,phone,creationdate,typeuser,availablefunds,accountstatus,lastconnexiondate FROM person WHERE email=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, email);

			// Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			while(res.next()){
				nu.setId(res.getInt("id"));
				nu.setEmail(res.getString("email"));
				nu.setPassword(res.getString("password"));
				nu.setFamilyName(res.getString("familyName"));
				nu.setFirstName(res.getString("firstName"));
				nu.setAddress(res.getString("adress"));
				nu.setTelephone(res.getString("phone"));
				Date creationDate = new Date(res.getDate("creationdate").getTime());
				nu.setCreationDate(creationDate);
				nu.setFunds(res.getBigDecimal("availablefunds"));
				nu.setAccountStatus(res.getInt("accountstatus"));
				Date lastConnexionDate = new Date(res.getDate("creationdate").getTime());
				nu.setLastConnexionDate(lastConnexionDate);
				break;
			}
			res.close();
			ConnexionBDD.getInstance().closeCnx();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nu;
	}
}
