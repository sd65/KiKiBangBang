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
	
	// Nombre de points (somme des votes) nécessaire pour passer en phase de rédaction
	public final static int IDEA_NEXTSTEP_DISCUSSION = 10;
	// Temps (en jours) nécessaire pour passer en phase d'évaluation
	public final static int IDEA_NEXTSTEP_REDACTION = 1;
	// Nombre de points (somme des votes tous critères) nécessaire pour passer en phase de funding
	public final static int IDEA_NEXTSTEP_EVALUATION = 20;
	// Temps (en jours) nécessaire pour atteindre les fonds requis sous peine d'être supprimé
	public final static int IDEA_NEXTSTEP_FUNDING = 2;
}
