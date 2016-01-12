package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import bean.NormalUser;
import bean.Question;

public class CriterionDao {

	private static Logger LOGGER = Logger.getAnonymousLogger();

	/**
	 * Find all existing criterions
	 * 
	 * @return
	 */
	public static List<String> findAll() {

		List<String> ls = new ArrayList<String>();
		Connection cnx = null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

			// Requete
			String sql = "SELECT criterion FROM criterionenum";
			PreparedStatement ps = cnx.prepareStatement(sql);

			// Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				ls.add(res.getString("criterion"));
			}

			res.close();
			ConnexionBDD.getInstance().closeCnx();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ls;
	}
}
