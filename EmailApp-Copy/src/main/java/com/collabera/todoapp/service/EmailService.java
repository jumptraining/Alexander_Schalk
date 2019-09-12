package com.collabera.todoapp.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.collabera.todoapp.model.Email;

/**
 * 
 * @author Mukuljaiswal
 * CODE HAS BEEN MODIFIED BY ALEXANDER SCHALK
 */
@Service
public class EmailService {

	/*
	 * The Spring Framework provides an easy abstraction for sending email by using
	 * the JavaMailSender interface, and Spring Boot provides auto-configuration for
	 * it as well as a starter module.
	 */
	private JavaMailSender javaMailSender;

	/**
	 * 
	 * @param javaMailSender
	 */
	@Autowired
	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	/**
	 * This function is used to send mail without attachment.
	 * @param email
	 * @throws MailException
	 */
	
	public void sendEmail(String emailAddress, String emailSubject, String emailMessage) throws MailException {

		/*
		 * This JavaMailSender Interface is used to send Mail in Spring Boot. This
		 * JavaMailSender extends the MailSender Interface which contains send()
		 * function. SimpleMailMessage Object is required because send() function uses
		 * object of SimpleMailMessage as a Parameter
		 */
		Email newEmail = new Email(emailAddress, emailSubject, emailMessage);
		SimpleMailMessage mail = new SimpleMailMessage();
		
		mail.setTo(newEmail.getEmailAddress());
		mail.setSubject(newEmail.getEmailSubject());
		mail.setText(newEmail.getEmailMessage());

		/*
		 * This send() contains an Object of SimpleMailMessage as an Parameter
		 */
		javaMailSender.send(mail);
	}

	/**
	 * This function is used to send mail that contains a attachment.
	 * 
	 * @param email
	 * @throws MailException
	 * @throws MessagingException
	 */

	public void sendEmailWithAttachment(String emailAddress, String emailSubject, String emailMessage, String emailAttachment) throws MailException, MessagingException {

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		Email newEmail = new Email(emailAddress, emailSubject, emailMessage, emailAttachment);
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

		helper.setTo(newEmail.getEmailAddress());
		helper.setSubject(newEmail.getEmailSubject());
		helper.setText(newEmail.getEmailMessage());

		ClassPathResource classPathResource = new ClassPathResource(newEmail.getEmailAttachment());
		helper.addAttachment(classPathResource.getFilename(), classPathResource);

		javaMailSender.send(mimeMessage);
	}

}