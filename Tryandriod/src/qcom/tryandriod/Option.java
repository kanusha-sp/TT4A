package qcom.tryandriod;
public class Option {
	private String name;

	private double strikePrice;

	private String operation;

	private String IsExpired = "NO";
	
	public String getIsExpired() {
		return IsExpired;
	}

	public void setIsExpired(String isExpired) {
		IsExpired = isExpired;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getStrikePrice() {
		return strikePrice;
	}

	public void setStrikePrice(double strikePrice) {
		this.strikePrice = strikePrice;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

}