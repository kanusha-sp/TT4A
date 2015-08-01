package qcom.tryandriod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;


public class ReportMaker {
	public static double stockPrice;
	public static List<Client> clientList = new ArrayList<Client>();
	public static void main(String[] argv) throws AddressException, MessagingException{
		Stock stockMain = new Stock();
		stockPrice = stockMain.getCurrentPrice();
		clientList = getClients();
		ComputeClientProfit();

	}
	public static void ComputeClientProfit() throws AddressException, MessagingException{
		JavaEmail javaEmail = new JavaEmail();
		javaEmail.setMailServerProperties();
		
		//List<Client> clientList = new ArrayList<Client>();
		
		
		Iterator<Client> clientItr = clientList.iterator();
		
		while(clientItr.hasNext()){
			List<Option> optionList = new ArrayList<Option>();
			Client client = clientItr.next();
			optionList = client.optionList;
			Iterator<Option> optionItr = optionList.iterator();
			
			
			while(optionItr.hasNext()){
				Option option = optionItr.next();
				double strikePrice = option.getStrikePrice();
				String operation = option.getOperation();
				if (strikePrice > stockPrice){
					if (operation.equals("put")) {
						client.premiumAmount = client.premiumAmount + strikePrice;
						System.out.println(client.premiumAmount);
						//TODO code to delete the option from his list of options.
					}else if (operation.equals("call")){
						//TODO code to delete the option from his list of options.
					}
				}else if (strikePrice <= stockPrice){
					option.setIsExpired("YES");
				}
				client.EmailString.append(option.getName() + " " + option.getIsExpired() + "\n");
			}
			javaEmail.createEmailMessage(client.EmailString, client.cEmail);
			javaEmail.sendEmail();
		}
	}
	public static List<Client> getClients() {
		Option op1 = new Option();
		Option op2 = new Option();
		Option op3 = new Option();
		op1.setName("IBM");
		op1.setStrikePrice(45);
		op1.setOperation("put");
		
		op2.setName("IBM");
		op2.setStrikePrice(70);
		op2.setOperation("put");
		
		op3.setName("TATA");
		op3.setStrikePrice(65);
		op3.setOperation("put");
		
		List<Option> c1List = new ArrayList<Option>(); 
		List<Option> c2List = new ArrayList<Option>();  
		c1List.add(op1);
		c1List.add(op3);
		c2List.add(op2);
		List<Client> clientDetails = new ArrayList<Client>();
		
		Client c1 = new Client("Client1", 500, c1List, "kanusha.sp@gmail.com");
		Client c2 = new Client("Client2", 500, c2List, "shwethanarayan.18@gmail.com");
		clientDetails.add(c1);
		clientDetails.add(c2);
		
		return clientDetails;
	}

}
