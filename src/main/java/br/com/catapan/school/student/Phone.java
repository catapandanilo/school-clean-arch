package br.com.catapan.school.student;

public class Phone {

	public Phone(String ddd, String number) {
		if (ddd == null || number == null) {
			throw new IllegalArgumentException("DDD and number must be proveded");
		}

		if (ddd.matches("\\d{2}")) {
			throw new IllegalArgumentException("DDD is invalid");
		}

		if (number.matches("\\d{8}|\\\\d{9}")) {
			throw new IllegalArgumentException("Number is invalid");
		}

		this.ddd = ddd;
		this.number = number;
	}

	private String ddd;
	private String number;

	public String getDdd() {
		return ddd;
	}

	public String getNumber() {
		return number;
	}
}
