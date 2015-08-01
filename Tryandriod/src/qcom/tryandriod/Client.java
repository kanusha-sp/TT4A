package qcom.tryandriod;
import java.util.ArrayList;
import java.util.List;


public class Client {
    public String clientName; 
    public double premiumAmount;
    public String cEmail;
	public List<Option> optionList=new ArrayList<Option>();
	public StringBuilder EmailString = new StringBuilder("");

	public Client(String clientName,double premiumAmount,List<Option> option, String email) {
		this.clientName=clientName;
		this.premiumAmount=premiumAmount;
		this.optionList=option;
		this.cEmail = email;
	}
	
}