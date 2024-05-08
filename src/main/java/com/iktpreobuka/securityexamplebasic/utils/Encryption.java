package com.iktpreobuka.securityexamplebasic.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encryption {
	
	public static String getPassEncoded(String pass) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(pass);
	}

	public static void main (String [] args) {
		System.out.println(getPassEncoded("pass"));
	}
	
}
