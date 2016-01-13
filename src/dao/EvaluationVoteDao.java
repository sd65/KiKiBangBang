package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import bean.DiscussionVote;
import bean.EvaluationVote;
import bean.NormalUser;

public class EvaluationVoteDao {

	private static Logger LOGGER = Logger.getAnonymousLogger();

	/**
	 * create new EvaluationVote
	 * @param ev
	 * @param idIdea
	 * @return
	 */
	public static int insert(EvaluationVote ev, int idIdea) {
		int res = 0;
		Connection cnx = null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();

			// Requete
			String sql = "INSERT INTO evaluationvote(id,dat,participant,idea,updown,criterion) "
					+ "VALUES(?,?,?,?,?,?)";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, ev.getId());
			java.sql.Date creationDate = new java.sql.Date(ev.getDate().getTime());
			ps.setDate(2, creationDate);
			ps.setInt(3, ev.getUser().getId());
			ps.setInt(4, idIdea);
			ps.setInt(5, ev.getUpDown());
			ps.setString(6, ev.getCriterion());
			// Execution et traitement de la reponse
			res = ps.executeUpdate();

			ConnexionBDD.getInstance().closeCnx();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	
	/**
	 * find all EvaluationVote for an Idea
	 * 
	 * @return list of EvaluationVote
	 */
	public static List<EvaluationVote> findAllForIdea(int idIdea) {

		List<EvaluationVote> lev = new ArrayList<EvaluationVote>();
		Connection cnx = null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

			// Requete
			String sql = "SELECT id,dat,participant,idea,updown,criterion FROM evaluationvote WHERE idea=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, idIdea);

			// Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				EvaluationVote ev = new EvaluationVote();
				ev.setId(res.getInt("id"));
				Date creationDate = new Date(res.getDate("dat").getTime());
				ev.setDate(creationDate);
				NormalUser usr = UserDao.findUser(res.getInt("participant"));
				ev.setUser(usr);
				ev.setUpDown(res.getInt("updown"));
				ev.setCriterion(res.getString("criterion"));
				lev.add(ev);
			}

			res.close();
			ConnexionBDD.getInstance().closeCnx();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//

		return lev;
	}
	
	public static int onDeleteIdea(int idIdea) {
		int res = 0;
		Connection cnx = null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();

			// Requete
			String sql = "DELETE FROM evaluationvote WHERE idea=?";
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
