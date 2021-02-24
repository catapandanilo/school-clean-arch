package br.com.catapan.school.domain.student;

import java.util.List;

public interface StudentRepository {

	void register(Student student);

	Student findByCPF(CPF cpf);

	List<Student> listAllStudents();
}
