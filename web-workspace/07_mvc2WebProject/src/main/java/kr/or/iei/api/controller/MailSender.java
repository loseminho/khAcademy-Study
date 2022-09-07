package kr.or.iei.api.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {

	public boolean sendMail(String mailTitle, String receiver, String mailContent) {
		boolean result = false;
		//이메일 통신설정
		Properties prop = System.getProperties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", 465);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		//인증정보설정(로그인)
		Session session = Session.getDefaultInstance(prop, 
				new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						PasswordAuthentication pa = new PasswordAuthentication("loseminho", "kzzkkxnlcaoninmt");
						return pa;
					}
				}
		);
		//이메일을 작성해서 전송하는 객체
		MimeMessage msg = new MimeMessage(session);
		
		//이메일 작성
		try {
			//메일 전송 날짜 설정
			msg.setSentDate(new Date());
			//보내는 사람 정보
			msg.setFrom(new InternetAddress("loseminho@gmail.com","KH 당산 A 클래스"));
			//받는 사람 정보
			InternetAddress to = new InternetAddress(receiver);
			msg.setRecipient(Message.RecipientType.TO, to);
			//이메일 제목 설정
			msg.setSubject(mailTitle,"UTF-8");
			//이메일 본문 설정
			msg.setContent(mailContent,"text/html;charset=utf-8");
			//이메일 전송
			Transport.send(msg);
			result = true;
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
	
}
