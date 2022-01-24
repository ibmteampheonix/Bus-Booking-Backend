package com.ibm.service;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
	
	public void conn(String recipient,String name)
	{
		String sender="teampheonix.ibm@gmail.com";
		
		String host= "smtp.gmail.com";
		
		Properties properties=System.getProperties();
		
		properties.setProperty("mail.smtp.auth", "true");
		
		properties.setProperty("mail.smtp.ssl.enable", "true");
		
		properties.setProperty("mail.smtp.host", host);
		
		properties.setProperty("mail.smtp.port", "465");
		
		Session session=Session.getDefaultInstance(properties,new javax.mail.Authenticator()
				{
					protected PasswordAuthentication getPasswordAuthentication()
					{
						return new PasswordAuthentication("teampheonix.ibm@gmail.com", "eqrnupykpyaqdejp");
					}
				});
		
		
		try {
			MimeMessage message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress(sender));
			
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			
			message.setSubject("Blockbusters");
			
			message.setContent(name,"text/html");
			
			Transport.send(message);
			
			System.out.println("mail successfully sent");
		} 
		catch (AddressException e) {
			e.printStackTrace();
		} 
		catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void confirmedBooking(String email_id, int booking_id) {
		conn(email_id, "<h2> Your Seat is booked</h2>" + booking_id);
	}

	@Override
	public void cancelledBooking(String email_id, int booking_id) {
		conn(email_id, "<h2> Your booking is cancelled</h2>" + booking_id);
	}

	@Override
	public void emailRegistered(String email_id, String user_name) {
		conn(email_id,"<h2>Hi </h2>"+ user_name+"<h2> You are registered successfully!</h2>");

	}

}
