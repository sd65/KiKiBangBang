package bean;

import java.util.Date;

public class Question extends Participation {
	private String question;
	private String answer;
	private Date dateAnswer;
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Date getDateAnswer() {
		return dateAnswer;
	}
	public void setDateAnswer(Date dateAnswer) {
		this.dateAnswer = dateAnswer;
	}
}
