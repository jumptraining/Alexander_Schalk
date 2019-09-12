package com.collabera.todoapp.model;

import org.springframework.stereotype.Component;
/**
 * Date :July 25,2018
 * @author MukulJaiswal
 * @version 1.0
 * CODE HAS BEEN MODIFIED BY ALEXANDER SCHALK
 */
@Component
public class Email {

	public String emailAddress;
	public String emailSubject;
	public String emailMessage;
	public String emailAttachment;

	public Email() {}	

	//constructor without attachment
	public Email(String emailAddress, String emailSubject, String emailMessage) {
		// TODO Auto-generated constructor stub
		super();
		this.emailAddress = emailAddress;
		this.emailSubject = emailSubject;
		this.emailMessage = emailMessage;
	}
	
	//constructor with attachment
	public Email(String emailAddress, String emailSubject, String emailMessage, String emailAttachment) {
		// TODO Auto-generated constructor stub
		super();
		this.emailAddress = emailAddress;
		this.emailSubject = emailSubject;
		this.emailMessage = emailMessage;
		this.emailAttachment = emailAttachment;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public String getEmailMessage() {
		return emailMessage;
	}

	public void setEmailMessage(String emailMessage) {
		this.emailMessage = emailMessage;
	}
	
	public String getEmailAttachment() {
		return emailAttachment;
	}

	public void setEmailAttachment(String emailAttachment) {
		this.emailAttachment = emailAttachment;
	}
}