package bean;
public class EvaluationIdea extends Idea {
	public void addEvaluationVote(EvaluationVote e) {
		getEvaluationVotes().add(e);
		if (getEvaluationScore() >= ApplicationConstants.IDEA_NEXTSTEP_EVALUATION){
			nextStep();
		}
	}
	
}
