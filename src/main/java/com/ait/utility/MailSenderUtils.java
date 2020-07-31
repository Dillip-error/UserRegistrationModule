package com.ait.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.ait.bind.RegistrationForm;

@Component
public class MailSenderUtils {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public boolean sendUserAccUnlockMail1(RegistrationForm form) {
		boolean isSent = false;
		try {
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setTo(form.getEmail());
			msg.setSubject("Registration Email");
			msg.setText(getUnlockAccUserBody(form));
			mailSender.send(msg);
			isSent = true;
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return isSent;
		
	}
	
	
	public boolean sendUserAccUnlockMail2(RegistrationForm form) {
		boolean isSent = false;
		try {
			MimeMessage msg = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg);
			helper.setTo(form.getEmail());
			helper.setSubject("unlock your Account for Varification ");
			helper.setText(getUnlockAccUserBody(form), true);
			mailSender.send(msg);
			isSent = true;
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return isSent;
		
	}
	
	
	
	private String getUnlockAccUserBody(RegistrationForm form) throws IOException {
		StringBuffer sb = new StringBuffer();
		//file reader read data char by char
		FileReader fr = new FileReader("UNLOCK-ACC-EMAIL-BODY-TEMPLATE.txt");
		//Buffer reader read data line by line
		BufferedReader br = new BufferedReader(fr);
		String readLine = br.readLine();
		
		while(readLine != null) {
			sb.append(readLine);
			readLine = br.readLine();
		}
		br.close();
		
		// format mail body
				String mailBody = sb.toString();
				mailBody = mailBody.replace("{FNAME}", form.getFirstName());
				mailBody = mailBody.replace("{LNAME}", form.getLastName());
				mailBody = mailBody.replace("{TEMP-PWD}", form.getPassword());
				mailBody = mailBody.replace("{EMAIL}", form.getEmail());

		return mailBody;
		
	};

}
