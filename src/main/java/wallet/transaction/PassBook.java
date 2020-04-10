package wallet.transaction;

public class PassBook {
	String timeStamp;
	String transactionType;
	double amount;
	public String getTimeStamp() {
		return timeStamp;
	}
	
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "PassBook [timeStamp=" + timeStamp + ", transactionType=" + transactionType + ", amount=" + amount + "]";
	}
}
