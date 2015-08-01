package qcom.tryandriod;

public class Stock {
	private double currentStockPrice = 56.5; //Price in dollars.
	public Stock(double stockPrice) {
		this.currentStockPrice = stockPrice;
	}
	public Stock(){
		// dummy constructor
	}
	public double getCurrentPrice(){
		return currentStockPrice;
	}

}
