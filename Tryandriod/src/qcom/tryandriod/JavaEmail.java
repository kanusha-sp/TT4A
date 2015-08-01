package qcom.tryandriod;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaEmail {

	Properties emailProperties;
	Session mailSession;
	MimeMessage emailMessage;



	public void setMailServerProperties() {

		String emailPort = "587";//gmail's smtp port

		emailProperties = System.getProperties();
		emailProperties.put("mail.smtp.port", emailPort);
		emailProperties.put("mail.smtp.auth", "true");
		emailProperties.put("mail.smtp.starttls.enable", "true");

	}

	public void createEmailMessage(StringBuilder emailBody, String toEmail) throws AddressException,
			MessagingException {
		//String[] toEmails = { "sudeshnapal12@gmail.com" };
		String emailSubject = "Java Email";

		mailSession = Session.getDefaultInstance(emailProperties, null);
		emailMessage = new MimeMessage(mailSession);

		//for (int i = 0; i < toEmails.length; i++) {
 			emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
 		//}
 
 		emailMessage.setSubject(emailSubject);
 		emailMessage.setContent(emailBody.toString(), "text/html");//for a html email
 		//emailMessage.setText(emailBody);// for a text email
 
 	}
 
 	public void sendEmail() throws AddressException, MessagingException {
 
 		String emailHost = "smtp.gmail.com";
 		String fromUser = "javatesting111@gmail.com";//just the id alone without @gmail.com
 		String fromUserEmailPassword = "morganstanley";
 
 		Transport transport = mailSession.getTransport("smtp");
 
 		transport.connect(emailHost, fromUser, fromUserEmailPassword);
 		transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
 		transport.close();
 		System.out.println("Email sent successfully.");
 	}
}