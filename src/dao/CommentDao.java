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
import bean.NormalUser;
import bean.Question;

public class CommentDao {

	private static Logger LOGGER = Logger.getAnonymousLogger();

	/**
	 * create new comment
	 * @param com
	 * @param idIdea
	 * @return
	 */
	public static int insert(Comment com, int idIdea) {
		int res = 0;
		Connection cnx = null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();

			// Requete
			String sql = "INSERT INTO commentary(dat,participant,idea,commentary) "
					+ "VALUES(?,?,?,?)";
			PreparedStatement ps = cnx.prepareStatement(sql);
			java.sql.Date creationDate = new java.sql.Date(com.getDate().getTime());
			ps.setDate(1, creationDate);
			ps.setInt(2, com.getUser().getId());
			ps.setInt(3, idIdea);
			ps.setString(4, com.getText());
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
	public static List<Comment> findAllForIdea(int idIdea) {

		List<Comment> lc = new ArrayList<Comment>();
		Connection cnx = null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

			// Requete
			String sql = "SELECT id,dat,participant,idea,commentary FROM commentary WHERE idea=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, idIdea);

			// Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				Comment c = new Comment();
				c.setId(res.getInt("id"));
				Date creationDate = new Date(res.getDate("dat").getTime());
				c.setDate(creationDate);
				NormalUser usr = UserDao.findUser(res.getInt("participant"));
				c.setUser(usr);
				c.setText(res.getString("commentary"));
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
	
	public static int onDeleteIdea(int idIdea) {
		int res = 0;
		Connection cnx = null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();

			// Requete
			String sql = "DELETE FROM commentary WHERE idea=?";
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
