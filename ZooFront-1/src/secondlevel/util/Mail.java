package com.Zoo.util;
import java.sql.*;

import java.util.Properties;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;

public class Mail {
		
	public void sendEmail( String body,String mailId,String subject) {
	    // Set the properties
	    Properties props = new Properties();
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.port", "587");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");

	    // Get the Session object
	    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
	        protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication("mailmymailidd@gmail.com", "dysjaafgpvusvmxk");
	        }
	    });
	   // String mailId = "barath2221@gmail.com";
	    try {
	        // Create a default MimeMessage object
	        MimeMessage message = new MimeMessage(session);

	        // Set the sender and the recipient
	        //message.setFrom(new InternetAddress(""));
	        message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailId));

	        // Set the subject and the body of the email
	        message.setSubject(subject);
	        message.setText(body);
	        // Send the message
	        Transport.send(message);

	        System.out.println("Email sent successfully...");
	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }
	}

	
}

