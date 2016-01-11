package bean;

import java.math.BigDecimal;

public class Contribution extends Participation {
	private BigDecimal amount;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
