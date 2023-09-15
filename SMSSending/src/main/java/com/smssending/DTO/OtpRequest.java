/**
 * @author: windows
 * @Created_Date:Sep 13, 2023
 * @File_Name:OtpRequest.java
 *
 */
package com.smssending.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
 * This class is used to get the inputs for sending the OTP.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OtpRequest
{
	private String username;		
	private String mobileNumber;
}
