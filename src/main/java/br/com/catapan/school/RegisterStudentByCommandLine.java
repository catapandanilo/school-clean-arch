package br.com.catapan.school;

import br.com.catapan.school.application.student.register.RegisterStudent;
import br.com.catapan.school.application.student.register.RegisterStudentDto;
import br.com.catapan.school.infra.student.StudentRepositoryInMemory;

public class RegisterStudentByCommandLine {

	public static void main(String[] args) {
		String name = "Danilo Catapan";
		String cpf = "123.123.123-00";
		String email = "dcatapan@gmail.com";

		RegisterStudent register = new RegisterStudent(new StudentRepositoryInMemory());
		register.execute(new RegisterStudentDto(name, cpf, email));

	}

}
