package bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Idea implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6074952096682311133L;
	private Long id;
	private String name;
	private Date creationDate;
	private BigDecimal fundsRequired;
	private String shortDescription;
	private String redactionEnrich;
	//private Map<String, List<Participation>> participations = new HashMap<String, List<Participation>>();
	private List<Question> discussionQuestions = new ArrayList<Question>();
	private List<DiscussionVote> discussionVotes = new ArrayList<DiscussionVote>();
	private List<Comment> redactionComments = new ArrayList<Comment>();
	private List<EvaluationVote> evaluationVotes = new ArrayList<EvaluationVote>();
	private List<Contribution> fundingContributions = new ArrayList<Contribution>();
	private NormalUser proposer;
	
//	public Map<String, List<Participation>> getParticipations() {
//		return participations;
//	}

	public List<DiscussionVote> getDiscussionVotes() {
		return discussionVotes;
	}
	
	public Integer getDiscussionScore() {
		Integer score = 0;
		for (DiscussionVote vote : getDiscussionVotes()){
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
	
//	public void setParticipations(Map<String, List<Participation>> pParticipations) {
//		participations = pParticipations;
//	}
	
	public abstract void nextStep();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
}
