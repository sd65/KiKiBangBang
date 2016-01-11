public abstract class Idea {
	public java.lang.Long id;
	public java.lang.String name;
	public java.sql.Date creationDate;
	public java.math.BigDecimal fundsRequired;
	public java.lang.String shortDescription;
	public java.lang.String redactionEnrich;
	public Map<participationType:String, participations:List<Participation<NormalUser,Idea>>> participations;
	public List<DiscussionVote> getDiscussionVote() {
	
	}
	
	public java.lang.Integer getDiscussionScore() {
	
	}
	
	public List<Question> getDiscussionQuestions() {
	
	}
	
	public List<Comment> getRedactionComments() {
	
	}
	
	public List<EvaluationVote> getEvaluationVotes() {
	
	}
	
	public List<Contribution> getFundingContributions() {
	
	}
	
	public void setParticipations(java.lang.String Map<participationType, List<Participation<NormalUser participations, Object Idea>>>) {
	
	}
	
	public abstract void nextStep();
}
