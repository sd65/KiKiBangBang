package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import bean.ApplicationConstants;
import bean.Idea;
import bean.NormalUser;
import bean.Question;

public class QuestionDao {

	private static Logger LOGGER = Logger.getAnonymousLogger();

	/**
	 * Create new Question
	 * 
	 * @param question
	 * @param idIdea
	 * @return
	 */
	public static int insert(Question question, int idIdea) {
		int res = 0;
		Connection cnx = null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();

			// Requete
			String sql = "INSERT INTO idea(id,dat,participant,idea,question,answer,answerdate) "
					+ "VALUES(?,?,?,?,?,?,?)";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, question.getId());
			java.sql.Date creationDate = new java.sql.Date(question.getDate().getTime());
			ps.setDate(2, creationDate);
			ps.setInt(3, question.getUser().getId());
			ps.setInt(4, idIdea);
			ps.setString(5, question.getQuestion());
			ps.setString(6, question.getAnswer());
			java.sql.Date answerDate = new java.sql.Date(question.getDateAnswer().getTime());
			ps.setDate(7, answerDate);

			// Execution et traitement de la reponse
			res = ps.executeUpdate();

			ConnexionBDD.getInstance().closeCnx();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	/**
	 * Update a question
	 * 
	 * @param u
	 * @return
	 */
	public static int update(Question question) {
		int res = 0;

		Connection cnx = null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();

			// Requete
			String sql = "UPDATE question SET answer=?,answerdate=? " + "WHERE id=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, question.getAnswer());
			java.sql.Date answerDate = new java.sql.Date(question.getDateAnswer().getTime());
			ps.setDate(2, answerDate);
			ps.setInt(3, question.getId());

			// Execution et traitement de la reponse
			res = ps.executeUpdate();

			ConnexionBDD.getInstance().closeCnx();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	/**
	 * find all questions
	 * 
	 * @return list of Question
	 */
	public static List<Question> findAll() {

		List<Question> lq = new ArrayList<Question>();
		Connection cnx = null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

			// Requete
			String sql = "SELECT id,dat,participant,idea,question,answer,answerdate FROM question";
			PreparedStatement ps = cnx.prepareStatement(sql);

			// Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				Question q = new Question();
				q.setId(res.getInt("id"));
				Date creationDate = new Date(res.getDate("dat").getTime());
				q.setDate(creationDate);
				NormalUser usr = UserDao.findUser(res.getInt("participant"));
				q.setUser(usr);
				q.setQuestion(res.getString("question"));
				q.setAnswer(res.getString("answer"));
				Date answerDate = new Date(res.getDate("answerDate").getTime());
				q.setDateAnswer(answerDate);
				lq.add(q);
			}

			res.close();
			ConnexionBDD.getInstance().closeCnx();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//

		return lq;
	}

	/**
	 * find all questions for an Idea
	 * 
	 * @return list of Question
	 */
	public static List<Question> findAllForIdea(int idIdea) {

		List<Question> lq = new ArrayList<Question>();
		Connection cnx = null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

			// Requete
			String sql = "SELECT id,dat,participant,idea,question,answer,answerdate FROM question where idea=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, idIdea);

			// Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				Question q = new Question();
				q.setId(res.getInt("id"));
				Date creationDate = new Date(res.getDate("dat").getTime());
				q.setDate(creationDate);
				NormalUser usr = UserDao.findUser(res.getInt("participant"));
				q.setUser(usr);
				q.setQuestion(res.getString("question"));
				q.setAnswer(res.getString("answer"));
				Date answerDate = new Date(res.getDate("answerDate").getTime());
				q.setDateAnswer(answerDate);
				lq.add(q);
			}

			res.close();
			ConnexionBDD.getInstance().closeCnx();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//

		return lq;
	}
	
	
	public static int onDeleteIdea(int idIdea) {
		int res = 0;
		Connection cnx = null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();

			// Requete
			String sql = "DELETE FROM question WHERE idea=?";
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
