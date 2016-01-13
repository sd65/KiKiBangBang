package bean;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import dao.IdeaDao;

public class FundingIdea extends Idea {
	public void addContribution(Contribution c) {
		getFundingContributions().add(c);
		Date now = new Date();
		Calendar cal = new GregorianCalendar();
		cal.setTime(getStepDate());
		cal.add(Calendar.DATE, ApplicationConstants.IDEA_NEXTSTEP_FUNDING);
		Date nextStepTheoricalDate = cal.getTime();
		if (now.after(nextStepTheoricalDate)){
			if (getRaisedFunds().compareTo(getFundsRequired())>=0)
			nextStep();
			else
				IdeaDao.
		}
	}

}
