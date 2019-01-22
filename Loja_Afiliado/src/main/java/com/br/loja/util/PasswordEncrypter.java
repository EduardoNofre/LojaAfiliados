package com.br.loja.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncrypter {
	
	private final static int DEFAULT_PASSWORD_MIN_LENGTH = 8;
	
	private final static int DEFAULT_PASSWORD_MAX_LENGTH = 10;
	
	public static String getEncodedLegacyPassword(String clearTextPassword) throws NoSuchAlgorithmException {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(clearTextPassword.getBytes());
			return HexString.bufferToHex(md.digest());
	}

	public static String getEncodedPassword(String clearTextPassword) throws NoSuchAlgorithmException {

		BCryptPasswordEncoder passwordEncrypter = new BCryptPasswordEncoder();
		String passwordEncrypted = passwordEncrypter.encode(clearTextPassword);
		
		return passwordEncrypted;
	}
	
	public static Boolean checkPassword(String senhaDigitada, String senhaCriptografada) {
		BCryptPasswordEncoder passwordEncrypter = new BCryptPasswordEncoder();
		Boolean check = passwordEncrypter.matches(senhaDigitada, senhaCriptografada);
		return check;
	}
	
	public static boolean checkPasswordCompliance(String password) {
		Boolean compliant = false;
		
		if(password.length() >= DEFAULT_PASSWORD_MIN_LENGTH && password.matches("^(?=.*[A-Z])(?=.*\\d).+$")) {
			compliant = true;
		}
		return compliant;
	}
	
	public static String getDefaultPassword() {
		return StringUtil.generateRandomText(DEFAULT_PASSWORD_MIN_LENGTH, DEFAULT_PASSWORD_MAX_LENGTH, true, false, true);
	}
	
	public static boolean testPassword(String clearTextTestPassword, String encodedActualPassword) throws NoSuchAlgorithmException {
		
		String encodedTestPassword = getEncodedPassword(clearTextTestPassword);

		return checkPassword(encodedActualPassword, encodedTestPassword);
	}

	public static void main(String[] args) {

		try {
			if (args != null && args.length > 0 && args[0] != null) {

				System.out.println(getEncodedPassword(args[0]));

			} else {
				System.out.println("123 = " + getEncodedPassword("123"));
			}
			
		} catch (Exception e) {
			
		}
		System.exit(0);
	}

}
