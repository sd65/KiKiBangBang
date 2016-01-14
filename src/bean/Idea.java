package bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import dao.IdeaDao;

public abstract class Idea implements Serializable {
	/**
	 * 
	 */
	private static Logger LOGGER = Logger.getAnonymousLogger();
	private static final long serialVersionUID = 6074952096682311133L;
	private int id;
	private String name;
	private Date creationDate;
	private BigDecimal fundsRequired;
	private Date stepDate;
	private String shortDescription;
	private String redactionEnrich;
	// private Map<String, List<Participation>> participations = new
	// HashMap<String, List<Participation>>();
	private List<Question> discussionQuestions = new ArrayList<Question>();

	public void setDiscussionQuestions(List<Question> discussionQuestions) {
		this.discussionQuestions = discussionQuestions;
	}

	public void setDiscussionVotes(List<DiscussionVote> discussionVotes) {
		this.discussionVotes = discussionVotes;
	}

	public void setRedactionComments(List<Comment> redactionComments) {
		this.redactionComments = redactionComments;
	}

	public void setEvaluationVotes(List<EvaluationVote> evaluationVotes) {
		this.evaluationVotes = evaluationVotes;
	}

	public void setFundingContributions(List<Contribution> fundingContributions) {
		this.fundingContributions = fundingContributions;
	}

	private List<DiscussionVote> discussionVotes = new ArrayList<DiscussionVote>();
	private List<Comment> redactionComments = new ArrayList<Comment>();
	private List<EvaluationVote> evaluationVotes = new ArrayList<EvaluationVote>();
	private List<Contribution> fundingContributions = new ArrayList<Contribution>();
	private NormalUser proposer;

	public int getEvaluationScore() {
		Integer score = 0;
		for (EvaluationVote vote : getEvaluationVotes()) {
			score += vote.getUpDown();
		}
		return score;
	}

	public List<DiscussionVote> getDiscussionVotes() {
		return discussionVotes;
	}

	public Integer getDiscussionScore() {
		Integer score = 0;
		for (DiscussionVote vote : getDiscussionVotes()) {
			score += vote.getUpDown();
		}
		return score;
	}

	public List<Question> getDiscussionQuestions() {
		return discussionQuestions;
	}

	public List<Comment> getRedactionComments() {
		return redactionComments;
	}

	public List<EvaluationVote> getEvaluationVotes() {
		return evaluationVotes;
	}

	public List<Contribution> getFundingContributions() {
		return fundingContributions;
	}

	// public void setParticipations(Map<String, List<Participation>>
	// pParticipations) {
	// participations = pParticipations;
	// }

	public void nextStep() {
		IdeaDao.updateNextStep(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public BigDecimal getFundsRequired() {
		return fundsRequired;
	}

	public void setFundsRequired(BigDecimal fundsRequired) {
		this.fundsRequired = fundsRequired;
	}

	public String getRedactionEnrich() {
		return redactionEnrich;
	}

	public void setRedactionEnrich(String redactionEnrich) {
		this.redactionEnrich = redactionEnrich;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public NormalUser getProposer() {
		return proposer;
	}

	public void setProposer(NormalUser proposer) {
		this.proposer = proposer;
	}

	public Date getStepDate() {
		return stepDate;
	}

	public void setStepDate(Date stepDate) {
		this.stepDate = stepDate;
	}

	public BigDecimal getRaisedFunds() {
		BigDecimal sum = new BigDecimal(0);
		for (Contribution c : getFundingContributions()) {
			BigDecimal result = sum.add(new BigDecimal(c.getAmount().floatValue()));
			sum = result;
			LOGGER.info(sum.toString());
		}
		return sum;
	}
	
	public String getStepName(){
		if (getClass().getName().equals(ProposalIdea.class.getName())) {
			return ApplicationConstants.IDEA_STEPNAME_PROPOSAL;
		}
		if (getClass().getName().equals(DiscussionIdea.class.getName())) {
			return ApplicationConstants.IDEA_STEPNAME_DISCUSSION;
		}
		if (getClass().getName().equals(RedactionIdea.class.getName())) {
			return ApplicationConstants.IDEA_STEPNAME_REDACTION;
		}
		if (getClass().getName().equals(EvaluationIdea.class.getName())) {
			return ApplicationConstants.IDEA_STEPNAME_EVALUATION;
		}
		if (getClass().getName().equals(FundingIdea.class.getName())) {
			return ApplicationConstants.IDEA_STEPNAME_FUNDING;
		}
		if (getClass().getName().equals(ProductionIdea.class.getName())) {
			return ApplicationConstants.IDEA_STEPNAME_PRODUCTION;
		}
		return "UNKNOWN";
	}
}
