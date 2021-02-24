package br.com.catapan.school.infra.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.catapan.school.domain.student.CPF;
import br.com.catapan.school.domain.student.Email;
import br.com.catapan.school.domain.student.Phone;
import br.com.catapan.school.domain.student.Student;
import br.com.catapan.school.domain.student.StudentNotFound;
import br.com.catapan.school.domain.student.StudentRepository;

public class StudentRepositoryJDBC implements StudentRepository {

	private final Connection connection;

	public StudentRepositoryJDBC(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void register(Student student) {
		try {
			String sql = "INSERT INTO STUDENT VALUES(?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, student.getCpf());
			ps.setString(2, student.getName());
			ps.setString(3, student.getEmail());
			ps.execute();

			sql = "INSERT INTO PHONE VALUES(?, ?)";
			ps = connection.prepareStatement(sql);
			for (Phone phone : student.getPhones()) {
				ps.setString(1, phone.getDdd());
				ps.setString(2, phone.getNumber());
				ps.execute();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public Student findByCPF(CPF cpf) {
		try {
			String sql = "SELECT id, name, email FROM STUDNET WHERE cpf = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, cpf.getNumber());

			ResultSet rs = ps.executeQuery();
			boolean encontrou = rs.next();
			if (!encontrou) {
				throw new StudentNotFound(cpf);
			}

			String name = rs.getString("name");
			Email email = new Email(rs.getString("email"));
			Student found = new Student(cpf, name, email);

			Long id = rs.getLong("id");
			sql = "SELECT ddd, number FROM TELEFONE WHERE student_id = ?";
			ps = connection.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				String number = rs.getString("number");
				String ddd = rs.getString("ddd");
				found.addPhone(ddd, number);
			}

			return found;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Student> listAllStudents() {
		try {
			String sql = "SELECT id, cpf, name, email FROM STUDENT";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Student> students = new ArrayList<>();
			while (rs.next()) {
				CPF cpf = new CPF(rs.getString("cpf"));
				String name = rs.getString("name");
				Email email = new Email(rs.getString("email"));
				Student student = new Student(cpf, name, email);

				Long id = rs.getLong("id");
				sql = "SELECT ddd, number FROM TELEFONE WHERE student_id = ?";
				PreparedStatement psTelefone = connection.prepareStatement(sql);
				psTelefone.setLong(1, id);
				ResultSet rsTelefone = psTelefone.executeQuery();
				while (rsTelefone.next()) {
					String number = rsTelefone.getString("number");
					String ddd = rsTelefone.getString("ddd");
					student.addPhone(ddd, number);
				}

				students.add(student);
			}

			return students;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
