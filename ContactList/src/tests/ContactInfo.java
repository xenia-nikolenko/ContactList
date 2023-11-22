package tests;

import java.util.Objects;

public class ContactInfo {
	private String firstName;
	private String lastName;
	private String birth;
	private String email;
	private String phone;
	private String address;
	private String city;
	private String privince;
	private String zip;
	private String country;
	
	public ContactInfo() {
	}

	public ContactInfo(String firstName, String lastName, String birth, String email, String phone, String address,
			String city, String privince, String zip, String country) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birth = birth;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.city = city;
		this.privince = privince;
		this.zip = zip;
		this.country = country;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPrivince() {
		return privince;
	}

	public void setPrivince(String privince) {
		this.privince = privince;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, birth, city, country, email, firstName, lastName, phone, privince, zip);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactInfo other = (ContactInfo) obj;
		return Objects.equals(address, other.address) && Objects.equals(birth, other.birth)
				&& Objects.equals(city, other.city) && Objects.equals(country, other.country)
				&& Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(phone, other.phone)
				&& Objects.equals(privince, other.privince) && Objects.equals(zip, other.zip);
	}

	@Override
	public String toString() {
		return "ContactInfo [firstName=" + firstName + ", lastName=" + lastName + ", birth=" + birth + ", email="
				+ email + ", phone=" + phone + ", address=" + address + ", city=" + city + ", privince=" + privince
				+ ", zip=" + zip + ", country=" + country + "]";
	}
	
	

}
