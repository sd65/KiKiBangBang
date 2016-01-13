package bean;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class RedactionIdea extends Idea {
	public void addComment(Comment c) {
		getRedactionComments().add(c);
		Date now = new Date();
		Calendar cal = new GregorianCalendar();
		cal.setTime(getStepDate());
		cal.add(Calendar.DATE, ApplicationConstants.IDEA_NEXTSTEP_REDACTION);
		Date nextStepTheoricalDate = cal.getTime();
		if (now.after(nextStepTheoricalDate)){
			nextStep();
		}
		
	}
	
}
