package org.books.bookstore.cucumber.stepdefinitions;

import org.books.data.dto.AddressDTO;
import org.books.data.dto.CreditCardDTO;
import org.books.data.dto.Customer;
import org.books.data.dto.RegistrationDTO;
import org.books.data.CreditCardType;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

public class CustomerSteps {
	private AddressDTO address = null;
	private CreditCardDTO creditCard = null;
	private Customer customer = null;
	private RegistrationDTO registration = null;

	@Given("^registration: username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void registration_username_and_password(String username, String password) throws Throwable {
		customer = new Customer();
		customer.setAddress(address);
		
		registration = new RegistrationDTO();
		registration.setPassword(password);
		registration.setCustomer(customer);
	}

	@Given("^address: city \"([^\"]*)\" and country \"([^\"]*)\" and street \"([^\"]*)\" and postal code \"([^\"]*)\"$")
	public void address_city_and_country_and_street_and_postal_code(String city, String country, String street,
			String postalCode) throws Throwable {

		System.out.println("Creating address..");
		address = new AddressDTO();
		address.setCity(city);
		address.setCountry(country);
		address.setPostalCode(postalCode);
		address.setStreet(street);
	}
 
    @Given("^credit card: type \"(MasterCard|Visa)\" and number \"([^\"]\\d+)\" and expiration month \"([^\"][\\d{2}])\" and expiration year \"([^\"][\\d{2}])\"$")
	public void credit_card_type_and_number(String type, String number, String month, String year) throws Throwable {
		creditCard = new CreditCardDTO();
		CreditCardType type1 = null;
		creditCard.setType(convertToCreditCardType(type));
		creditCard.setNumber(number);
	}
	
	private static CreditCardType convertToCreditCardType(String strType){
		CreditCardType type = null;
		switch(strType){
		case "MasterCard":
			type = CreditCardType.MasterCard;
			break;
		case "Visa":
			type = CreditCardType.Visa;
			break;
		default:
			throw new IllegalArgumentException(strType);
		}
		return type;
	}

}
