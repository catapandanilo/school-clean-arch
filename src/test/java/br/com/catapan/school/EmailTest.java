package br.com.catapan.school;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.catapan.school.student.Email;

class EmailTest {

	@Test
	void notCreateEmailWithInvalidEmail() {
		assertThrows(IllegalArgumentException.class, () -> new Email(null));
		assertThrows(IllegalArgumentException.class, () -> new Email(""));
		assertThrows(IllegalArgumentException.class, () -> new Email("invalid"));
	}

}
