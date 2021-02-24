package br.com.catapan.school.domain.student;

public interface PasswordEncryptor {
	String encrypt(String password);

	boolean valid(String encrypted, String password);
}
