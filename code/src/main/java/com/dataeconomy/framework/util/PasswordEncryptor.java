package com.dataeconomy.framework.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.apache.commons.codec.binary.Base64;



/**
 *
 * Guvala
 */
public class PasswordEncryptor {

	private static final String SALT_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

	public static final String SPECIAL_CHARACTERS = "!@#$%^&*()~`-=_+[]{}|:\";',./<>?";
	public static final int MIN_PASSWORD_LENGTH = 8;
	public static final int MAX_PASSWORD_LENGTH = 20;

	public static String generateSalt() {
		StringBuffer salt = new StringBuffer();
		Random rnd = new Random();

		// build a random 16 chars salt
		while (salt.length() < 16) {
			int index = (int) (rnd.nextFloat() * SALT_CHARS.length());
			salt.append(SALT_CHARS.substring(index, index + 1));
		}
		return salt.toString();
	}

	public static String applySalt(String password) {
		return password + generateSalt();
	}

	public static String applySHA256(final String password) {
		String encodedSalt = "";
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes("UTF-8"));

			byte[] byteSHA = md.digest();

			encodedSalt = Base64.encodeBase64String(byteSHA);

		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return encodedSalt;
	}

	public static boolean isValidPassword(String password, final String dbHash) {
		final String hashedPassword = applySHA256(password);
		return hashedPassword.equals(dbHash);
	}

}
