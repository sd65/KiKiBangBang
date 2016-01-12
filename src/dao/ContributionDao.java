package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import bean.Comment;
import bean.Contribution;
import bean.NormalUser;

public class ContributionDao {

	private static Logger LOGGER = Logger.getAnonymousLogger();

	/**
	 * create new Contribution
	 * @param con
	 * @param idIdea
	 * @return
	 */
	public static int insert(Contribution con, int idIdea) {
		int res = 0;
		Connection cnx = null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();

			// Requete
			String sql = "INSERT INTO contribution(id,dat,participant,idea,amount) "
					+ "VALUES(?,?,?,?,?)";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, con.getId());
			java.sql.Date creationDate = new java.sql.Date(con.getDate().getTime());
			ps.setDate(2, creationDate);
			ps.setInt(3, con.getUser().getId());
			ps.setInt(4, idIdea);
			ps.setBigDecimal(5, con.getAmount());
			// Execution et traitement de la reponse
			res = ps.executeUpdate();

			ConnexionBDD.getInstance().closeCnx();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	
	/**
	 * find all comment for an Idea
	 * 
	 * @return list of Comment
	 */
	public static List<Contribution> findAllForIdea(int idIdea) {

		List<Contribution> lc = new ArrayList<Contribution>();
		Connection cnx = null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

			// Requete
			String sql = "SELECT id,dat,participant,idea,amount FROM contribution WHERE idea=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, idIdea);

			// Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				Contribution c = new Contribution();
				c.setId(res.getInt("id"));
				Date creationDate = new Date(res.getDate("dat").getTime());
				c.setDate(creationDate);
				NormalUser usr = UserDao.findUser(res.getInt("participant"));
				c.setUser(usr);
				c.setAmount(res.getBigDecimal("amount"));
				lc.add(c);
			}

			res.close();
			ConnexionBDD.getInstance().closeCnx();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//

		return lc;
	}
}
