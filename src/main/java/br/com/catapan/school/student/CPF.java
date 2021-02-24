package br.com.catapan.school.student;

public class CPF {

	public CPF(String number) {
		if (number == null || !number.matches("^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)")) {
			throw new IllegalArgumentException("Invalid CPF");
		}
		
		this.number = number;
	}

	private String number;

}
