/**
 * @author: windows
 * @Created_Date:Sep 13, 2023
 * @File_Name:SmsService.java
 *
 */
package com.smssending.Service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smssending.DTO.OtpRequest;
import com.smssending.DTO.OtpResponseDto;
import com.smssending.DTO.OtpStatus;
import com.smssending.DTO.OtpValidationRequest;
import com.smssending.DTO.TwilioConfig;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService
{
	@Autowired
	private TwilioConfig twilioConfig;
	
	Map<String, String> otpMap = new HashMap<>();

	public OtpResponseDto sendSMS(OtpRequest otpRequest)
	{
		OtpResponseDto otpResponseDto = null;
		try 
		{
			String otp = generateOTP();
			
			PhoneNumber to = new PhoneNumber(otpRequest.getMobileNumber());
			PhoneNumber from = new PhoneNumber(twilioConfig.getMobileNumber());
			String otpMessage = "Your OTP is : "+ otp;
			
			Message.creator(to, from, otpMessage).create();
			
			otpMap.put(otpRequest.getMobileNumber(), otp);
			otpResponseDto = new OtpResponseDto(OtpStatus.DELIVERED, otpMessage);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			otpResponseDto = new OtpResponseDto(OtpStatus.FAILED, e.getMessage());
		}
		return otpResponseDto;
	}
	
	public String validateOtp(OtpValidationRequest otpValidationRequest)
	{
		Set<String> mobileNumbers = otpMap.keySet();
		for (String mobileNumber : mobileNumbers) // key is the username
		{
			if (otpValidationRequest.getMobileNumber().equals(mobileNumber)) 
			{
				if (otpValidationRequest.getOtpNumber().equals(otpMap.get(mobileNumber)))
				{
					otpMap.remove(mobileNumber, otpValidationRequest.getOtpNumber());
					return "OTP is valid!";
				}
				else
					return "OTP is invalid!";
			}
		}
			return "First generate OTP.";
	}
	
	private String generateOTP() 
	{
		return new DecimalFormat("000000")
				.format(new Random().nextInt(999999));
	}
}
