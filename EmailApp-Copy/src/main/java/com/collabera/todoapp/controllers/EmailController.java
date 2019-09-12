package com.collabera.todoapp.controllers;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.collabera.todoapp.model.Email;
import com.collabera.todoapp.service.EmailService;

// CODE HAS BEEN MODIFIED BY ALEXANDER SCHALK

@Controller
@SessionAttributes("name")
public class EmailController {

	@Autowired
	EmailService emailService;

	@RequestMapping(value="/newemail", method = RequestMethod.GET)
	public String showAddEmail(ModelMap model) {

		model.addAttribute("email", new Email());
		return "newemail";
	}

	@RequestMapping(value="/newemail", method = RequestMethod.POST)
	public String addEmail(ModelMap model, @Valid Email email, BindingResult result) throws MailException, MessagingException {

		if(result.hasErrors()) {
			return "newemail";
		}
		if(email.getEmailAttachment() == "") {
			emailService.sendEmail(email.getEmailAddress(), email.getEmailSubject(), email.getEmailMessage());
		} else {
			emailService.sendEmailWithAttachment(email.getEmailAddress(), email.getEmailSubject(), email.getEmailMessage(), email.getEmailAttachment());
		}
		return "redirect:/newemail";
	}
}