package br.com.catapan.school.application.student.register;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.catapan.school.domain.student.CPF;
import br.com.catapan.school.domain.student.Student;
import br.com.catapan.school.infra.student.StudentRepositoryInMemory;

class RegisterStudentTest {

	@Test
	void studentShouldBeRegistered() {
		StudentRepositoryInMemory repository = new StudentRepositoryInMemory();
		RegisterStudent useCase = new RegisterStudent(repository);

		RegisterStudentDto data = new RegisterStudentDto("david", "123.123.123-00", "email@email.com");
		useCase.execute(data);
		
		Student found = repository.findByCPF(new CPF("123.123.123-00"));
		assertEquals("david", found.getName());
		assertEquals("123.123.123-00", found.getCpf());
		assertEquals("email@email.com", found.getEmail());
	}

}
 