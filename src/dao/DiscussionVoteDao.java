package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import bean.Contribution;
import bean.DiscussionVote;
import bean.NormalUser;

public class DiscussionVoteDao {

	private static Logger LOGGER = Logger.getAnonymousLogger();

	/**
	 * create new DiscussionVote
	 * @param dv
	 * @param idIdea
	 * @return
	 */
	public static int insert(DiscussionVote dv, int idIdea) {
		int res = 0;
		Connection cnx = null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();

			// Requete
			String sql = "INSERT INTO discussionvote(dat,participant,idea,updown) "
					+ "VALUES(?,?,?,?)";
			PreparedStatement ps = cnx.prepareStatement(sql);
			java.sql.Date creationDate = new java.sql.Date(dv.getDate().getTime());
			ps.setDate(1, creationDate);
			ps.setInt(2, dv.getUser().getId());
			ps.setInt(3, idIdea);
			ps.setInt(4, dv.getUpDown());
			// Execution et traitement de la reponse
			res = ps.executeUpdate();

			ConnexionBDD.getInstance().closeCnx();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	
	/**
	 * find all DiscussionVote for an Idea
	 * 
	 * @return list of DiscussionVote
	 */
	public static List<DiscussionVote> findAllForIdea(int idIdea) {

		List<DiscussionVote> ldv = new ArrayList<DiscussionVote>();
		Connection cnx = null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

			// Requete
			String sql = "SELECT id,dat,participant,idea,updown FROM discussionvote WHERE idea=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, idIdea);

			// Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				DiscussionVote dv = new DiscussionVote();
				dv.setId(res.getInt("id"));
				Date creationDate = new Date(res.getDate("dat").getTime());
				dv.setDate(creationDate);
				NormalUser usr = UserDao.findUser(res.getInt("participant"));
				dv.setUser(usr);
				dv.setUpDown(res.getInt("updown"));
				ldv.add(dv);
			}

			res.close();
			ConnexionBDD.getInstance().closeCnx();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//

		return ldv;
	}
	
	public static int onDeleteIdea(int idIdea) {
		int res = 0;
		Connection cnx = null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();

			// Requete
			String sql = "DELETE FROM discussionvote WHERE idea=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, idIdea);
			// Execution et traitement de la reponse
			res = ps.executeUpdate();

			ConnexionBDD.getInstance().closeCnx();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
}
