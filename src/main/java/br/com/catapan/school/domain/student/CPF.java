package br.com.catapan.school.domain.student;

public class CPF {

	public CPF(String number) {
		if (number == null || !number.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
			throw new IllegalArgumentException("Invalid CPF");
		}
		
		this.number = number;
	}

	private String number;

	public String getNumber() {
		return number;
	}

}
