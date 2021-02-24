package br.com.catapan.school.infra.student;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.com.catapan.school.domain.student.PasswordEncryptor;

public class PasswordEncryptorWithMD5 implements PasswordEncryptor {

	@Override
	public String encrypt(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Error to encrypt the password!");
		}
	}

	@Override
	public boolean valid(String encrypted, String password) {
		return encrypted.equals(encrypt(password));
	}

}
