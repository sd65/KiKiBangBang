package bean;

import java.io.Serializable;
import java.util.Date;

public abstract class Participation implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1285382824572751771L;
	private NormalUser user;
	private Date date;
	public NormalUser getUser() {
		return user;
	}
	public void setUser(NormalUser user) {
		this.user = user;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
