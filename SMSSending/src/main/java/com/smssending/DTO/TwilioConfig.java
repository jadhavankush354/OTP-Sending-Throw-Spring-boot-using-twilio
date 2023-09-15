/**
 * @author: windows
 * @Created_Date:Sep 13, 2023
 * @File_Name:twilioConfig.java
 *
 */
package com.smssending.DTO;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Data;

/*
 * This class is used to use the twilio account details in our application to send the message/OTP.
 */
@Configuration
@Component
@Data
@ConfigurationProperties(prefix = "twilio") // this annotation is used to get the twilio account details from the application.properties file.
public class TwilioConfig 
{
	private String accountSid;
	private String authToken;
	private String mobileNumber;
}
