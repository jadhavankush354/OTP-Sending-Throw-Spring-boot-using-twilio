/**
 * @author: windows
 * @Created_Date:Sep 13, 2023
 * @File_Name:OTPController.java
 *
 */
package com.smssending.SMSController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smssending.DTO.OtpRequest;
import com.smssending.DTO.OtpResponseDto;
import com.smssending.DTO.OtpValidationRequest;
import com.smssending.Service.SmsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/otp")
@Slf4j
public class OTPController 
{
	@Autowired
	private SmsService smsService;
	
	@PostMapping("/sent-otp")
	private OtpResponseDto sendOtp(@RequestBody OtpRequest otpRequest) 
	{
		log.info("inside sendOtp :: "+otpRequest.getUsername());
		return smsService.sendSMS(otpRequest);
	}

	@PostMapping("/validate-otp")
	private String validateOtp(@RequestBody OtpValidationRequest otpValidationRequest)
	{
		log.info("inside validateOtp :: "+otpValidationRequest.getOtpNumber());
		return smsService.validateOtp(otpValidationRequest);

	}
}
