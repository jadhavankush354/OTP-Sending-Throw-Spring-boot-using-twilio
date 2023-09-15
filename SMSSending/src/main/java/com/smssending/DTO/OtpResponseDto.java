/**
 * @author: windows
 * @Created_Date:Sep 13, 2023
 * @File_Name:OtpResponseDto.java
 *
 */
package com.smssending.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
 * This class is used to send the response to the user who has requested for the OTP.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OtpResponseDto 
{
	// Status of the message
	private OtpStatus status;
	private String message;
}
