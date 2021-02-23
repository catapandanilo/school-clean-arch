package school;

import java.util.ArrayList;
import java.util.List;

public class Student {

	private CPF cpf;
	private String name;
	private Email email;
	private List<Phone> phones = new ArrayList<>();
	
	

	public void addPhone(String ddd, String number) {
		this.phones.add(new Phone(ddd, number));
	}

	public CPF getCpf() {
		return cpf;
	}

	public String getName() {
		return name;
	}

	public Email getEmail() {
		return email;
	}

	public List<Phone> getPhones() {
		return phones;
	}
	
	
}
