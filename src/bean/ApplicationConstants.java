package bean;

public class ApplicationConstants {
	public final static String IDEA_DISCUSSION_QUESTION = "Question";
	public final static String IDEA_DISCUSSION_VOTE = "DiscussionVote";
	public final static String IDEA_REDACTION_COMMENT = "Comment";
	public final static String IDEA_EVALUALATION_VOTE = "EvaluationVote";
	public final static String IDEA_FUNDING_CONTRIBUTION = "Contribution";
	
	/*
	 * USERS CONSTANTS
	 */
	public final static int ACCOUNTSTATUS_ACTIVE = 1;
	public final static int ACCOUNTSTATUS_INACTIVE = 0;
	
	/*
	 * IDEAS CONSTANTS 
	 */
	public final static int IDEA_STEP_PROPOSAL = 1;
	public final static int IDEA_STEP_DISCUSSION = 2;
	public final static int IDEA_STEP_REDACTION = 3;
	public final static int IDEA_STEP_EVALUATION = 4;
	public final static int IDEA_STEP_FUNDING = 5;
	public final static int IDEA_STEP_PRODUCTION = 6;
	public final static String IDEA_STEPNAME_PROPOSAL = "Proposal";
	public final static String IDEA_STEPNAME_DISCUSSION = "Discussion";
	public final static String IDEA_STEPNAME_REDACTION = "Redaction";
	public final static String IDEA_STEPNAME_EVALUATION = "Evaluation";
	public final static String IDEA_STEPNAME_FUNDING = "Funding";
	public final static String IDEA_STEPNAME_PRODUCTION = "Production";
	
	// Nombre de points (somme des votes) n�cessaire pour passer en phase de r�daction
	public final static int IDEA_NEXTSTEP_DISCUSSION = 10;
	// Temps (en jours) n�cessaire pour passer en phase d'�valuation
	public final static int IDEA_NEXTSTEP_REDACTION = 1;
	// Nombre de points (somme des votes tous crit�res) n�cessaire pour passer en phase de funding
	public final static int IDEA_NEXTSTEP_EVALUATION = 20;
	// Temps (en jours) n�cessaire pour atteindre les fonds requis sous peine d'�tre supprim�
	public final static int IDEA_NEXTSTEP_FUNDING = 2;
}
