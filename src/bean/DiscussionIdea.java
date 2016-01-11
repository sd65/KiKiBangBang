package bean;

public class DiscussionIdea extends Idea {

	public void addQuestion(Question q) {
		getDiscussionQuestions().add(q);
	}

	public void addVote(DiscussionVote v) {
		getDiscussionVotes().add(v);
	}

	public void nextStep() {

	}
}
