package com.smssending;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.smssending.DTO.TwilioConfig;
import com.twilio.Twilio;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class SmsSendingApplication 
{
	@Autowired
	private TwilioConfig twilioConfig;
	
	// This method is used to instantiate the twilio environment for using the twilio services.
	@PostConstruct
	private void setup() 
	{
		Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken()); 
	}
	
	public static void main(String[] args) 
	{
		SpringApplication.run(SmsSendingApplication.class, args);
	}

}
