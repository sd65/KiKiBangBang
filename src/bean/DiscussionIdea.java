package bean;

public class DiscussionIdea extends Idea {

	public void addQuestion(Question q) {
		getDiscussionQuestions().add(q);
	}

	public void addVote(DiscussionVote v) {
		getDiscussionVotes().add(v);
		if (getDiscussionScore()>= ApplicationConstants.IDEA_NEXTSTEP_DISCUSSION){
			nextStep();
		}
	}
	
	public boolean userAlreadyVote(User u){
		for (DiscussionVote dv : getDiscussionVotes()){
			if (dv.getUser().getId() == u.getId()) return true;
		}
		
		
		return false;
	}

}
