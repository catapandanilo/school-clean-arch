package br.com.catapan.school.domain.student;

public class StudentNotFound extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public StudentNotFound(CPF cpf) {
		super("Student not found with CPF: " + cpf.getNumber());
	}

}
