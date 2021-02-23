package school;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PhoneTest {

	@Test
	void notCreatePhoneWithInvalidDDD() {
		assertThrows(IllegalArgumentException.class, () -> new Phone(null, "123456789"));
		assertThrows(IllegalArgumentException.class, () -> new Phone("", "123456789"));
		assertThrows(IllegalArgumentException.class, () -> new Phone("1", "123456789"));
	}
	
	@Test
	void notCreatePhoneWithInvalidNumber() {
		assertThrows(IllegalArgumentException.class, () -> new Phone("11", null));
		assertThrows(IllegalArgumentException.class, () -> new Phone("11", ""));
		assertThrows(IllegalArgumentException.class, () -> new Phone("11", "123"));
	}
	
	@Test
	void createPhoneWithValidDDAndValidNumber() {
		String ddd = "11";
		String number = "123456789";
		Phone phone = new Phone(ddd, number);
		assertEquals(ddd, phone.getDdd());
		assertEquals(number, phone.getNumber());
	}

}
