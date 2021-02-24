package br.com.catapan.school.application;

import br.com.catapan.school.domain.student.Student;

public interface SendEmailRecommendation {
	void sendTo(Student indicated);
}
