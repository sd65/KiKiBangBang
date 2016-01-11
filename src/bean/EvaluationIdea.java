package bean;
public class EvaluationIdea extends Idea {
	public void addEvaluationVote(EvaluationVote e) {
		getEvaluationVotes().add(e);
	}
	
	public void nextStep() {
	
	}
}
