package org.farmacia.util;

import java.util.Properties;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class UCorreo {
	static Session session = null;
	static MimeMessage correo = null;
	private static MailcapCommandMap mailcap = null;
	
	public static Session sessionCorreo() {	
			Properties props = new Properties();
			props.put("mail.smtp.auth","true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", 587);		
			final String username = "sispharmape@gmail.com";
			final String password = "sispharmape1";

			session = Session.getInstance(props,
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username, password);
						}
					});
			return session;
	}
	
	public static boolean generarEnviarCorreo(String contenido, String asunto,
			String correoRecibe, String correoEnvio) {
		Session session = sessionCorreo();
		   correo = generarCorreo(contenido, asunto, correoRecibe,correoEnvio, session);
		try {
			Transport.send(correo);
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static MimeMessage generarCorreo(String contenido, String asunto,
			String correoRecibe, String correoEnvia, Session session) {
		try {
			
			if(mailcap ==null){
				mailcap = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
				mailcap.addMailcap("application/pkcs7-signature;; x-java-content-handler=org.bouncycastle.mail.smime.handlers.pkcs7_signature");
				mailcap.addMailcap("application/pkcs7-mime;; x-java-content-handler=org.bouncycastle.mail.smime.handlers.pkcs7_mime");
				mailcap.addMailcap("application/x-pkcs7-signature;; x-java-content-handler=org.bouncycastle.mail.smime.handlers.x_pkcs7_signature");
				mailcap.addMailcap("application/x-pkcs7-mime;; x-java-content-handler=org.bouncycastle.mail.smime.handlers.x_pkcs7_mime");
				mailcap.addMailcap("multipart/signed;; x-java-content-handler=org.bouncycastle.mail.smime.handlers.multipart_signed");
			}
			
		
			CommandMap.setDefaultCommandMap(mailcap);
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setContent(contenido, "text/html");
			MimeMultipart mimeMultipart = new MimeMultipart();
			mimeMultipart.addBodyPart(textBodyPart);

			MimeMessage body = new MimeMessage(session);
			body.setFrom(new InternetAddress(correoEnvia));
			body.setRecipient(Message.RecipientType.TO, new InternetAddress(
					correoRecibe));
			//Acuse de Confirmacion de Lectura			
			//body.addHeader("Disposition-Notification-To",correoEnvia);		
			body.setSubject(asunto);
			body.setContent(mimeMultipart);
			body.saveChanges();

			System.out.println("generarCorreo correctamente");
			return body;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;

	}

	
	
}
