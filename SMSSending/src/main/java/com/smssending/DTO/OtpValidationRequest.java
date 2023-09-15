/**
 * @author: windows
 * @Created_Date:Sep 13, 2023
 * @File_Name:OtpValidationRequest.java
 *
 */
package com.smssending.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * This class is used to take the input for checking the provided OTP is valids or not.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OtpValidationRequest 
{
	private String mobileNumber;
	private String otpNumber;
}
