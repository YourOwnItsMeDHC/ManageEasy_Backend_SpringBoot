package com.deepak.dorg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepak.dorg.model.SentEmail;
import com.deepak.dorg.model.Vendor;
import com.deepak.dorg.repository.SentEmailRepository;

@Service
public class EmailService {
	
	@Autowired
	private SentEmailRepository sentEmailRepository;
	
    public void sendEmail(Vendor vendor) {
        System.out.println("Sending payments to vendor " + vendor.getName() + " at upi " + vendor.getUpi());
    }

	public List<SentEmail> getAllSentEmails() {
		List<SentEmail> sentEmail = sentEmailRepository.findAll();
		return sentEmail;
	}	
}