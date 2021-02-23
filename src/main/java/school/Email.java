package school;

public class Email {

	public Email(String address) {
		if(address == null || !address.matches("/^[a-z0-9.]+@[a-z0-9]+\\.[a-z]+\\.([a-z]+)?$/i")) {
			throw new IllegalArgumentException("Invalid e-mail");
		}
		
 		this.address = address;
	}

	private String address;
}
