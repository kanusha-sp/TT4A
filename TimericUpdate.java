package qcom.tryandriod;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Timer.*;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

class SayHelloPrint extends TimerTask {
    public void run() {
    	
    	ReportMaker reportMaker = new ReportMaker();
    	try {
			ReportMaker.ComputeClientProfit();
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       System.out.println("Hello World!"); 
    }
 }
public class TimericUpdate{
 // And From your main() method or any other method
	public static void main(String[] argv){
		Timer timer = new Timer();
		timer.schedule(new SayHelloPrint(), 0, 5000);
	}
}