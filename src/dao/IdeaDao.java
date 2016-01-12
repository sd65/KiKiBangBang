package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Logger;

import bean.ApplicationConstants;
import bean.DiscussionIdea;
import bean.EvaluationIdea;
import bean.FundingIdea;
import bean.Idea;
import bean.NormalUser;
import bean.ProductionIdea;
import bean.ProposalIdea;
import bean.RedactionIdea;

public class IdeaDao {

	private static Logger LOGGER = Logger.getAnonymousLogger();

	public static int insert(Idea idea) {
		int res = 0;
		Connection cnx = null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();

			// Requete
			String sql = "INSERT INTO idea(id,name,creationdate,requiredfunds,step,stepdate,shortdescription,redactionenrich,proposer) "
					+ "VALUES(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, idea.getId());
			ps.setString(2, idea.getName());
			java.sql.Date creationDate = new java.sql.Date(idea.getCreationDate().getTime());
			ps.setDate(3, creationDate);
			ps.setBigDecimal(4, idea.getFundsRequired());
			ps.setInt(5, getStepNumber(idea));
			java.sql.Date stepDate = new java.sql.Date(idea.getStepDate().getTime());
			ps.setDate(6, stepDate);
			ps.setString(7, idea.getShortDescription());
			ps.setString(8, idea.getRedactionEnrich());
			ps.setInt(9, idea.getProposer().getId());

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
		idea.setRedactionComments(CommentDao.findAllForIdea(id));
		idea.setFundingContributions(ContributionDao.findAllForIdea(id));
		// TODO To be continued...
		
		
		return idea;
	}
	// TODO updateIdea prenant en compte le changement de step

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
