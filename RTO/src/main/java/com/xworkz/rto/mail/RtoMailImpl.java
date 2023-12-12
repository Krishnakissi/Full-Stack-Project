package com.xworkz.rto.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.xworkz.rto.configuration.MailConfiguration;

@Service
public class RtoMailImpl implements RtoMail{
	@Autowired
	private MailConfiguration mailcon;
	
	@Override
	public boolean sendMail(String email, String otp) {
		SimpleMailMessage mailMessage= new SimpleMailMessage();
		mailMessage.setTo(email);
		mailMessage.setSubject("OTP for Login");
		mailMessage.setText("Your otp for login: " +otp);
		mailcon.getJavaMailSender().send(mailMessage);
		System.out.println("mail sent successfully");
		return true;
		
	}@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
