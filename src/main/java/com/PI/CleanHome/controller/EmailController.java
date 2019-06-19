package com.PI.CleanHome.controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailController {

	public static void enviarEmailCleaner(String emailUsuario, String nomeUsuario) {

		Properties props = new Properties();
		/** Parâmetros de conexão com servidor Gmail */
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.debug", "true");
		props.put("mail.mime.charset", "ISO-8859-1");
		props.put("mail.smtp.port", "465");

		Session autentication = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() { // Remetente Senha
				return new PasswordAuthentication("suportecleanhome@gmail.com", "cl34n123");
			}
		});

		/** Ativa Debug para sessão */
		autentication.setDebug(true);

		try {

			// Remetente
			Message message = new MimeMessage(autentication);
			message.setFrom(new InternetAddress("suportecleanhome@gmail.com"));

			// Destinatário
			message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(emailUsuario));

			// Assunto do Email
			message.setSubject("Clean Home - Confirmação de Cadastro");

			// Mensagem do Email

			message.setText("Olá, Como vai Sr(a) " + nomeUsuario + ", "
					+ "\n\nSeu cadastro está em análise. Em breve entreremos em contato para dar o retorno do seu cadastro.");

			/** Método para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("Email Enviado");

		} catch (MessagingException e) {
			System.out.println(e);
			throw new RuntimeException(e);
		}
	}
	
	
	/***************************************/

	public static void enviarEmailCliente(String emailUsuario, String nomeUsuario) {

		Properties props = new Properties();
		/** Parâmetros de conexão com servidor Gmail */
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.debug", "true");
		props.put("mail.mime.charset", "ISO-8859-1");
		props.put("mail.smtp.port", "465");

		/* Senha e email do remetente */
		Session autentication = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("suportecleanhome@gmail.com", "cl34n123");
			}
		});

		/** Ativa Debug para sessão */
		autentication.setDebug(true);

		try {

			// Remetente
			Message message = new MimeMessage(autentication);
			message.setFrom(new InternetAddress("suportecleanhome@gmail.com"));

			// Destinatário
			message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(emailUsuario));

			// Assunto do Email
			message.setSubject("Clean Home - Confirmação de Cadastro");

			// Mensagem do Email
			message.setText("Olá, Como vai Sr(a) " + nomeUsuario + ", "
					+ "\n\nSeu cadastro foi criado com sucesso! Esperamos que "
					+ "aproveite todos os recursos oferecidos pelo nosso sistema.");

			/** Método para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("Email Enviado");

		} catch (MessagingException e) {
			System.out.println(e);
			throw new RuntimeException(e);
		}
	}
	
	
	/***************************************/

	public static void enviarEmailCleanerConfirmacao(String emailUsuario, String textoEmail, String assuntoEmail) {

		Properties props = new Properties();
		/** Parâmetros de conexão com servidor Gmail */
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.debug", "true");
		props.put("mail.mime.charset", "ISO-8859-1");
		props.put("mail.smtp.port", "465");

		/* Senha e email do remetente */
		Session autentication = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("suportecleanhome@gmail.com", "cl34n123");
			}
		});

		/** Ativa Debug para sessão */
		autentication.setDebug(true);

		try {

			// Remetente
			Message message = new MimeMessage(autentication);
			message.setFrom(new InternetAddress("suportecleanhome@gmail.com"));

			// Destinatário
			message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(emailUsuario));

			// Assunto do Email
			message.setSubject("Clean Home - " + assuntoEmail);

			// Mensagem do Email
			message.setText(textoEmail);

			/** Método para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("Email Enviado");

		} catch (MessagingException e) {
			System.out.println(e);
			throw new RuntimeException(e);
		}
	}


}
