package bean;
public class FundingIdea extends Idea {
	public void addContribution(Contribution c) {
		getFundingContributions().add(c);
	}
	
	public void nextStep() {
	
	}
}
