package br.com.catapan.school.application.student.register;

import br.com.catapan.school.domain.student.CPF;
import br.com.catapan.school.domain.student.Email;
import br.com.catapan.school.domain.student.Student;

public class RegisterStudentDto {

	private String nameStudent;
	private String cpfStudent;
	private String emailStudent;

	public RegisterStudentDto(String nameStudent, String cpfStudent, String emailStudent) {
		this.nameStudent = nameStudent;
		this.cpfStudent = cpfStudent;
		this.emailStudent = emailStudent;
	}

	public Student create() {
		return new Student(new CPF(cpfStudent), nameStudent, new Email(emailStudent));
	}
}
