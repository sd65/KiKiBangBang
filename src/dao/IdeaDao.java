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
import bean.Contribution;
import bean.DiscussionIdea;
import bean.EvaluationIdea;
import bean.FundingIdea;
import bean.Idea;
import bean.NormalUser;
import bean.ProductionIdea;
import bean.ProposalIdea;
import bean.RedactionIdea;
import bean.User;

public class IdeaDao {

	private static Logger LOGGER = Logger.getAnonymousLogger();

	public static int insert(Idea idea) {
		int res = 0;
		Connection cnx = null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();

			// Requete
			String sql = "INSERT INTO idea(name,creationdate,requiredfunds,step,stepdate,shortdescription,redactionenrich,proposer) "
					+ "VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, idea.getName());
			java.sql.Date creationDate = new java.sql.Date(idea.getCreationDate().getTime());
			ps.setDate(2, creationDate);
			ps.setBigDecimal(3, idea.getFundsRequired());
			ps.setInt(4, getStepNumber(idea));
			java.sql.Date stepDate = new java.sql.Date(new Date().getTime());
			ps.setDate(5, stepDate);
			ps.setString(6, idea.getShortDescription());
			ps.setString(7, idea.getRedactionEnrich());
			ps.setInt(8, idea.getProposer().getId());

			// Execution et traitement de la reponse
			res = ps.executeUpdate();

			ConnexionBDD.getInstance().closeCnx();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	// TODO findIdea + recuperer les participations
	/**
	 * Find an Idea by id create the Idea and add all its participations
	 * 
	 * @param id
	 * @return
	 */
	public static Idea find(int id) {
		Connection cnx = null;
		//TODO CREER L'IDEA EN FONCTION DE SA STEP
		Idea idea = null;
		int idProposer = 0;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

			// Requete
			String sql = "SELECT id,name,creationdate,requiredfunds,step,stepdate,shortdescription,redactionenrich,proposer FROM idea WHERE id=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, id);

			// Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				if(res.getInt("step")==ApplicationConstants.IDEA_STEP_PROPOSAL){
					idea = new ProposalIdea();
				}
				else if(res.getInt("step")==ApplicationConstants.IDEA_STEP_DISCUSSION){
					idea = new DiscussionIdea();
				}
				else if(res.getInt("step")==ApplicationConstants.IDEA_STEP_REDACTION){
					idea = new RedactionIdea();
				}
				else if(res.getInt("step")==ApplicationConstants.IDEA_STEP_EVALUATION){
					idea = new EvaluationIdea();
				}
				else if(res.getInt("step")==ApplicationConstants.IDEA_STEP_FUNDING){
					idea = new FundingIdea();
				}
				else if(res.getInt("step")==ApplicationConstants.IDEA_STEP_PRODUCTION){
					idea = new ProductionIdea();
				}
				idea.setId(res.getInt("id"));
				idea.setName(res.getString("name"));
				Date creationDate = new Date(res.getDate("creationdate").getTime());
				idea.setCreationDate(creationDate);
				idea.setFundsRequired(res.getBigDecimal("requiredfunds"));
				Date stepDate = new Date(res.getDate("stepdate").getTime());
				idea.setStepDate(stepDate);
				idea.setShortDescription(res.getString("shortdescription"));
				idea.setRedactionEnrich(res.getString("redactionenrich"));
				idProposer = res.getInt("proposer");
				break;
			}
			res.close();
			ConnexionBDD.getInstance().closeCnx();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		idea.setProposer(UserDao.findUser(idProposer));
		idea.setDiscussionQuestions(QuestionDao.findAllForIdea(id));
		idea.setDiscussionVotes(DiscussionVoteDao.findAllForIdea(id));
		idea.setRedactionComments(CommentDao.findAllForIdea(id));
		idea.setEvaluationVotes(EvaluationVoteDao.findAllForIdea(id));		
		idea.setFundingContributions(ContributionDao.findAllForIdea(id));
		
		
		return idea;
	}
	
	/**
	 * Find all ideas
	 * 
	 * @return
	 */
	public static List<Idea> findAll() {
		Connection cnx = null;
		List<Idea> li = new ArrayList<Idea>();
		int idProposer = 0;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

			// Requete
			String sql = "SELECT id,name,creationdate,requiredfunds,step,stepdate,shortdescription,redactionenrich,proposer FROM idea";
			PreparedStatement ps = cnx.prepareStatement(sql);

			// Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				Idea idea = null;
				if(res.getInt("step")==ApplicationConstants.IDEA_STEP_PROPOSAL){
					idea = new ProposalIdea();
				}
				else if(res.getInt("step")==ApplicationConstants.IDEA_STEP_DISCUSSION){
					idea = new DiscussionIdea();
				}
				else if(res.getInt("step")==ApplicationConstants.IDEA_STEP_REDACTION){
					idea = new RedactionIdea();
				}
				else if(res.getInt("step")==ApplicationConstants.IDEA_STEP_EVALUATION){
					idea = new EvaluationIdea();
				}
				else if(res.getInt("step")==ApplicationConstants.IDEA_STEP_FUNDING){
					idea = new FundingIdea();
				}
				else if(res.getInt("step")==ApplicationConstants.IDEA_STEP_PRODUCTION){
					idea = new ProductionIdea();
				}
				idea.setId(res.getInt("id"));
				idea.setName(res.getString("name"));
				Date creationDate = new Date(res.getDate("creationdate").getTime());
				idea.setCreationDate(creationDate);
				idea.setFundsRequired(res.getBigDecimal("requiredfunds"));
				Date stepDate = new Date(res.getDate("stepdate").getTime());
				idea.setStepDate(stepDate);
				idea.setShortDescription(res.getString("shortdescription"));
				idea.setRedactionEnrich(res.getString("redactionenrich"));
				idProposer = res.getInt("proposer");
				idea.setProposer(UserDao.findUser(idProposer));
				idea.setDiscussionQuestions(QuestionDao.findAllForIdea(idea.getId()));
				idea.setDiscussionVotes(DiscussionVoteDao.findAllForIdea(idea.getId()));
				idea.setRedactionComments(CommentDao.findAllForIdea(idea.getId()));
				idea.setEvaluationVotes(EvaluationVoteDao.findAllForIdea(idea.getId()));		
				idea.setFundingContributions(ContributionDao.findAllForIdea(idea.getId()));
				li.add(idea);
			}
			res.close();
			ConnexionBDD.getInstance().closeCnx();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return li;
	}
	
	
	/**
	 * Find an Idea by id create the Idea and add all its participations
	 * 
	 * @param id
	 * @return
	 */
	public static List<Idea> findMyIdeas(User u) {
		Connection cnx = null;
		List<Idea> li = new ArrayList<Idea>();
		int idProposer = 0;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

			// Requete
			String sql = "SELECT id,name,creationdate,requiredfunds,step,stepdate,shortdescription,redactionenrich,proposer FROM idea WHERE proposer=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, u.getId());

			// Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				Idea idea = null;
				if(res.getInt("step")==ApplicationConstants.IDEA_STEP_PROPOSAL){
					idea = new ProposalIdea();
				}
				else if(res.getInt("step")==ApplicationConstants.IDEA_STEP_DISCUSSION){
					idea = new DiscussionIdea();
				}
				else if(res.getInt("step")==ApplicationConstants.IDEA_STEP_REDACTION){
					idea = new RedactionIdea();
				}
				else if(res.getInt("step")==ApplicationConstants.IDEA_STEP_EVALUATION){
					idea = new EvaluationIdea();
				}
				else if(res.getInt("step")==ApplicationConstants.IDEA_STEP_FUNDING){
					idea = new FundingIdea();
				}
				else if(res.getInt("step")==ApplicationConstants.IDEA_STEP_PRODUCTION){
					idea = new ProductionIdea();
				}
				idea.setId(res.getInt("id"));
				idea.setName(res.getString("name"));
				Date creationDate = new Date(res.getDate("creationdate").getTime());
				idea.setCreationDate(creationDate);
				idea.setFundsRequired(res.getBigDecimal("requiredfunds"));
				Date stepDate = new Date(res.getDate("stepdate").getTime());
				idea.setStepDate(stepDate);
				idea.setShortDescription(res.getString("shortdescription"));
				idea.setRedactionEnrich(res.getString("redactionenrich"));
				idProposer = res.getInt("proposer");
				idea.setProposer(UserDao.findUser(idProposer));
				idea.setDiscussionQuestions(QuestionDao.findAllForIdea(idea.getId()));
				idea.setDiscussionVotes(DiscussionVoteDao.findAllForIdea(idea.getId()));
				idea.setRedactionComments(CommentDao.findAllForIdea(idea.getId()));
				idea.setEvaluationVotes(EvaluationVoteDao.findAllForIdea(idea.getId()));		
				idea.setFundingContributions(ContributionDao.findAllForIdea(idea.getId()));
				li.add(idea);
			}
			res.close();
			ConnexionBDD.getInstance().closeCnx();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return li;
	}
	
	// TODO updateIdea prenant en compte le changement de step
	/**
	 * Update idea in db to set the next step
	 * @param i
	 * @return
	 */
	public static int updateNextStep(Idea i) {
		int res = 0;

		Connection cnx = null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();

			// Requete
			String sql = "UPDATE idea SET name=?,creationdate=?,requiredfunds=?,step=?,stepdate=?,shortdescription=?,redactionenrich=?,proposer=?"
					+ "WHERE id=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, i.getName());
			java.sql.Date d = new java.sql.Date(i.getCreationDate().getTime());
			ps.setDate(2, d);
			ps.setBigDecimal(3, i.getFundsRequired());
			ps.setInt(4, getStepNumber(i)+1);
			java.sql.Date stepD = new java.sql.Date(new Date().getTime());
			ps.setDate(5, stepD);
			ps.setString(6, i.getShortDescription());
			ps.setString(7, i.getRedactionEnrich());
			ps.setInt(8, i.getProposer().getId());

			// Execution et traitement de la reponse
			res = ps.executeUpdate();

			ConnexionBDD.getInstance().closeCnx();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
	
	/**
	 * Delete an idea and its associated participations
	 * @param idea
	 * @return
	 */
	public static int delete(Idea i) {
		int res = 0;
		Connection cnx = null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			
			// Remboursement des contributions
			for (Contribution c : i.getFundingContributions()){
				NormalUser nu = c.getUser();
				nu.setFunds(nu.getFunds().add(c.getAmount()));
			}
			
			// Suppression - Cascade
			QuestionDao.onDeleteIdea(i.getId());
			DiscussionVoteDao.onDeleteIdea(i.getId());
			CommentDao.onDeleteIdea(i.getId());
			EvaluationVoteDao.onDeleteIdea(i.getId());		
			ContributionDao.onDeleteIdea(i.getId());
			// Requete
			String sql = "DELETE FROM idea WHERE id=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, i.getId());
			

			// Execution et traitement de la reponse
			res = ps.executeUpdate();

			ConnexionBDD.getInstance().closeCnx();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	private static int getStepNumber(Idea idea) {
		if (idea.getClass().getName().equals(ProposalIdea.class.getName())) {
			return ApplicationConstants.IDEA_STEP_PROPOSAL;
		}
		if (idea.getClass().getName().equals(DiscussionIdea.class.getName())) {
			return ApplicationConstants.IDEA_STEP_DISCUSSION;
		}
		if (idea.getClass().getName().equals(RedactionIdea.class.getName())) {
			return ApplicationConstants.IDEA_STEP_REDACTION;
		}
		if (idea.getClass().getName().equals(EvaluationIdea.class.getName())) {
			return ApplicationConstants.IDEA_STEP_EVALUATION;
		}
		if (idea.getClass().getName().equals(FundingIdea.class.getName())) {
			return ApplicationConstants.IDEA_STEP_FUNDING;
		}
		if (idea.getClass().getName().equals(ProductionIdea.class.getName())) {
			return ApplicationConstants.IDEA_STEP_PRODUCTION;
		}
		return 0;
	}
}
