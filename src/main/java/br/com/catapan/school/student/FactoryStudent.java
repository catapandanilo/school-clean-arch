package br.com.catapan.school.student;

public class FactoryStudent {
	private Student student;

	public FactoryStudent withNameCPFEmail(String name, String cpf, String email) {
		this.student = new Student(new CPF(cpf), name, new Email(email));
		return this; // use chain
	}

	public FactoryStudent withPhone(String ddd, String number) {
		this.student.addPhone(ddd, number);
		return this; // use chain
	}
	
	public Student create() {
		return this.student;
	}
	
	public static void main(String[] args) {
		FactoryStudent factory = new FactoryStudent();
		factory.withNameCPFEmail("", "", "")
			.withPhone("", "")
			.create();
	}
}
