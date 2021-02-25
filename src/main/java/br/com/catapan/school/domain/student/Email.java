package br.com.catapan.school.domain.student;

public class Email {

	public Email(String address) {
		if (address == null || !address.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
			throw new IllegalArgumentException("Invalid e-mail");
		}

		this.address = address;
	}

	private String address;

	public String getAddress() {
		return address;
	}
}
