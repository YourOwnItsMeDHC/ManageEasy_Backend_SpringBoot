package com.deepak.dorg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepak.dorg.model.SentEmail;
import com.deepak.dorg.model.Vendor;
import com.deepak.dorg.repository.SentEmailRepository;
import com.deepak.dorg.repository.VendorRepository;
import com.deepak.dorg.service.EmailService;
import com.deepak.dorg.service.VendorService;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {
	@Autowired
	private VendorService vendorService;

	@Autowired
	private EmailService emailService;

	@Autowired
	private VendorRepository vendorRepository;

	@Autowired
	private SentEmailRepository sentEmailRepository;

	@PostMapping
	public Vendor createVendor(@RequestBody Vendor vendor) {
		return vendorService.saveVendor(vendor);
	}

	@GetMapping
	public List<Vendor> getAllVendors() {
		return vendorService.getAllVendors();
	}

	@GetMapping("/sent-emails")
	public List<SentEmail> getAllSentEmails() {
		return emailService.getAllSentEmails();
	}

	@PostMapping("/send-email")
	public void sendEmail(@RequestBody EmailData emailData) {
		System.out.println("Email Data: " + emailData);

		emailData.getRecipients().forEach(email -> {
			System.out.println("DC - email : " + email);
			SentEmail sentEmail = new SentEmail();
			sentEmail.setSubject(emailData.getSubject());
			sentEmail.setMessage(emailData.getMessage());
			sentEmail.setEmail(email);

			Optional<Vendor> vendor = vendorRepository.findById(email);
			if (vendor.isPresent()) {
				emailService.sendEmail(vendor.get());
				sentEmailRepository.save(sentEmail);
			} else {
				System.out.println("Oops! No any vendor registered by mail id : " + email);
			}
		});
	}

	public static class EmailData {
		private String subject;
		private String message;
		private List<String> recipients;

		public String getSubject() {
			return subject;
		}

		public void setSubject(String subject) {
			this.subject = subject;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public List<String> getRecipients() {
			return recipients;
		}

		public void setRecipients(List<String> recipients) {
			this.recipients = recipients;
		}

		@Override
		public String toString() {
			return "EmailData{" + "subject='" + subject + '\'' + ", message='" + message + '\'' + ", recipients="
					+ recipients + '}';
		}
	}

}