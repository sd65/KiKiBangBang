package bean;
public class RedactionIdea extends Idea {
	public void addComment(Comment c) {
		getRedactionComments().add(c);
	}
	
	public void nextStep() {
	
	}
}
