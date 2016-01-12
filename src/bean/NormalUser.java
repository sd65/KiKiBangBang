package bean;

import java.math.BigDecimal;
import java.util.Date;

public class NormalUser extends User {
	private int accountStatus;
	private BigDecimal funds;
	private Date lastConnexionDate;

	public void proposeIdea(String name, BigDecimal fundsRequired, String shortDescription) {
		DiscussionIdea di = new DiscussionIdea();
		di.setCreationDate(new Date());
		di.setName(name);
		di.setFundsRequired(fundsRequired);
		di.setShortDescription(shortDescription);
		di.setProposer(this);
		// Qu'en faire ?
		// Créer l'idée dans la DB
	}

	public void doComment(RedactionIdea idea, String text) {
		Comment c = new Comment();
		c.setText(text);
		c.setUser(this);
		c.setDate(new Date());
		idea.addComment(c);
	}

	public void askQuestion(DiscussionIdea idea, String text) {
		Question q = new Question();
		q.setDate(new Date());
		q.setQuestion(text);
		q.setUser(this);
		idea.addQuestion(q);
	}

	public void thumbUp(DiscussionIdea idea) {
		DiscussionVote v = new DiscussionVote();
		v.setDate(new Date());
		v.setUser(this);
		v.setUpDown(1);
		idea.addVote(v);
	}

	public void thumbDown(DiscussionIdea idea) {
		DiscussionVote v = new DiscussionVote();
		v.setDate(new Date());
		v.setUser(this);
		v.setUpDown(-1);
		idea.addVote(v);
	}

	public void voteEvaluationUp(EvaluationIdea idea, String criterion) {
		EvaluationVote v = new EvaluationVote();
		v.setDate(new Date());
		v.setUser(this);
		v.setCriterion(criterion);
		v.setUpDown(1);
		idea.addEvaluationVote(v);
	}

	public void voteEvaluationDown(EvaluationIdea idea, String criterion) {
		EvaluationVote v = new EvaluationVote();
		v.setDate(new Date());
		v.setUser(this);
		v.setCriterion(criterion);
		v.setUpDown(-1);
		idea.addEvaluationVote(v);
	}

	public void contribute(FundingIdea idea, BigDecimal amount) {
		Contribution c = new Contribution();
		c.setDate(new Date());
		c.setUser(this);
		c.setAmount(amount);
		setFunds(getFunds().subtract(amount));
		idea.addContribution(c);
	}

	public int getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(int accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Date getLastConnexionDate() {
		return lastConnexionDate;
	}

	public void setLastConnexionDate(Date lastConnexionDate) {
		this.lastConnexionDate = lastConnexionDate;
	}

	public BigDecimal getFunds() {
		return funds;
	}

	public void setFunds(BigDecimal funds) {
		this.funds = funds;
	}
	
	@Override
	public Boolean login(String pEmail, String pPassword) {
		// Penser au hachage du mdp
		if (pEmail == getEmail() && pPassword == getPassword()){
			setLastConnexionDate(new Date());
			return true;
		}
		return false;

	}
}
