package hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value="ttx")
//@Table(name="Tellertx")
public class TellerTx extends Tx {
	private String teller;
	private String branch;
	public String getTeller() {
		return teller;
	}
	public void setTeller(String teller) {
		this.teller = teller;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public TellerTx() {

	}
	@Override
	public String toString() {
		return "TellerTx [teller=" + teller + ", branch=" + branch + ", getId()=" + getId() + ", getAmount()="
				+ getAmount() + "]";
	}
	public TellerTx(double amount, String teller, String branch) {
		super(amount);
		this.teller = teller;
		this.branch = branch;
	}
	
}
