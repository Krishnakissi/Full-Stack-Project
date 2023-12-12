package com.xworkz.rto.configuration;

import java.util.Properties;

import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfiguration {
	
	public JavaMailSender getJavaMailSender() {
		
	
		JavaMailSenderImpl mailSender=new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);

		mailSender.setUsername("krishna5.xworkz@gmail.com");
		mailSender.setPassword("ooam dzec hwne nbbe");

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");
		//  props.put("server.ssl.enabled-protocols ", "TLSv1.2");

		return mailSender;
		

	
	}

}
