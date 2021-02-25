package br.com.catapan.school.application.student.register;

import br.com.catapan.school.domain.student.Student;
import br.com.catapan.school.domain.student.StudentRepository;

public class RegisterStudent {

	private final StudentRepository repository;

	public RegisterStudent(StudentRepository repository) {
		this.repository = repository;
	}

	public void execute(RegisterStudentDto data) {
		Student student = data.create();
		repository.register(student);
	}

}
