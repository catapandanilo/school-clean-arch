package br.com.catapan.school.infra.student;

import java.util.ArrayList;
import java.util.List;

import br.com.catapan.school.domain.student.CPF;
import br.com.catapan.school.domain.student.Student;
import br.com.catapan.school.domain.student.StudentNotFound;
import br.com.catapan.school.domain.student.StudentRepository;

public class StudentRepositoryInMemory implements StudentRepository {

	private List<Student> registered = new ArrayList<>();

	@Override
	public void register(Student student) {
		this.registered.add(student);

	}

	@Override
	public Student findByCPF(CPF cpf) {
		return this.registered.stream()
				.filter(a -> a.getCpf().equals(cpf.getNumber()))
				.findFirst()
				.orElseThrow(() -> new StudentNotFound(cpf));
	}

	@Override
	public List<Student> listAllStudents() {
		return this.registered;
	}

}
