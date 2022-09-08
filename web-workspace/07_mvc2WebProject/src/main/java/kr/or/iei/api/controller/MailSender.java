package kr.or.iei.api.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

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
						PasswordAuthentication pa = new PasswordAuthentication("loseminhos", "csxztamwexevdurk");
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
			msg.setFrom(new InternetAddress("loseminhos@gmail.com","KH 당산 A 클래스"));
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

	public String sendMail2(String email) {
		boolean result = false;
		
		//인증용 랜덤코드 생성
		Random r = new Random();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<8; i++) {
			//숫자, 영어소문자, 영어대문자 섞어서 8개 조합
			//0:0~9, 1:A-Z, 2:a-z 
			int flag = r.nextInt(3);
			if(flag == 0) {
				//0~9
				int randomNum = r.nextInt(10);
				sb.append(randomNum);
				
			}else if(flag == 1) {
				//A~Z
				char randomChar = (char)(r.nextInt(26)+65);
				sb.append(randomChar);
				
			}else if(flag == 2) {
				//a~z
				char randomChar = (char)(r.nextInt(26)+97);
				sb.append(randomChar);
				
			}
		}
		
		
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
						PasswordAuthentication pa = new PasswordAuthentication("loseminhos", "csxztamwexevdurk");
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
			msg.setFrom(new InternetAddress("loseminhos@gmail.com","KH 당산 A 클래스"));
			//받는 사람 정보
			InternetAddress to = new InternetAddress(email);
			msg.setRecipient(Message.RecipientType.TO, to);
			//이메일 제목 설정
			msg.setSubject("hoya 인증메일입니다.","UTF-8");
			//이메일 본문 설정
			msg.setContent("<h1>안녕하세요. Hoya 입니다.</h1>"+
						"<h3>인증번호는 [<span style='color:red'>"+
						sb.toString()+
						"</span>] 입니다.", "text/html;charset=utf-8");
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
		if(result) {
			return sb.toString();
		}else {
			return null;
		}
		
	}
	
}
