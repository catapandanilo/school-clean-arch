package br.com.catapan.school.recommendation;

import java.time.LocalDateTime;

import br.com.catapan.school.student.Student;

public class Recommendation {

	private Student indicated;
	private Student indicator;
	private LocalDateTime dateRecommendation;
	
	public Recommendation(Student indicated, Student indicator) {
		this.indicated = indicated;
		this.indicator = indicator;
		this.dateRecommendation = LocalDateTime.now();
	}

	public Student getIndicated() {
		return indicated;
	}

	public Student getIndicator() {
		return indicator;
	}

	public LocalDateTime getDateRecommendation() {
		return dateRecommendation;
	}
}
