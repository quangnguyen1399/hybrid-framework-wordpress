package utilitiesConfig;

import java.util.Locale;

import com.github.javafaker.Faker;

public class FakerConfig {
	private Locale locale = new Locale("en");
	private Faker faker = new Faker(locale);
	
	public static FakerConfig getData() {
		return new FakerConfig();
	}
	
	public String getFirstName() {
		return faker.name().firstName();
	}
	
	public String getLastName() {
		return faker.name().lastName();	
	}
	
	public String getCompanyName() {
		return faker.company().name();
	}
	
	public String getFulltName() {
		return faker.name().fullName();
	}
	
	public String getEmail() {
		return faker.internet().emailAddress();
	}
	
	public String getPhone() {
		return faker.phoneNumber().phoneNumber();
	}
	
	public String getCity() {
		return faker.address().city();
	}
	
	public String getCityName() {
		return faker.address().cityName();
	}
	
	public String getPassword() {
		return faker.internet().password();
	}
}
