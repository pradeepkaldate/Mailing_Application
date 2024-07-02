package com.pk.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service("msgservice")
public class MsgDetailsImp implements IMsgDetails {
   @Autowired
	private JavaMailSender sender;
   @Value("${spring.mail.username}")
	private String fromMail;
	@Override
	public String sendMsg(String[] msg, String[] mails) throws Exception {
		String data=Arrays.toString(msg);
		String res=sendMail(data, mails);
		return res;
	}
	
  private String sendMail(String msg,String[] emails) throws Exception
  {
	  MimeMessage message = sender.createMimeMessage();
	  MimeMessageHelper help=new MimeMessageHelper(message,true);
	  
	  help.setFrom(fromMail);
	  help.setCc(emails);
	  help.setSubject("Mail From Pradeep");
	  help.setSentDate(new Date());
	  help.setText(msg);
	  help.addAttachment("Nature IMAGE", new ClassPathResource("nature.jpg"));
	  sender.send(message);
	  System.out.println("Done");
	  return "mail Send";
  }
}
