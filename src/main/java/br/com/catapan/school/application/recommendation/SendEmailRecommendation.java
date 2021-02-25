package br.com.catapan.school.application.recommendation;

import br.com.catapan.school.domain.student.Student;

public interface SendEmailRecommendation {
	void sendTo(Student indicated);
}
