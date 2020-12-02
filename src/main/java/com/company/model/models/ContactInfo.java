package com.company.model.models;

public class ContactInfo {

    private String firstName;
    private String lastName;
    private String email;
    private String streetAddress;
    private String city;
    private String zipCode;

    public ContactInfo(String firstName, String lastName, String email, String streetAddress, String city, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.streetAddress = streetAddress;
        this.city = city;
        this.zipCode = zipCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    @Override
    public String toString() {
        return "First Name: " + firstName + '\n' +
                "Last Name: " + lastName + '\n' +
                "Email: " + email + '\n' +
                "Street Address: " + streetAddress + '\n' +
                "City: " + city + '\n' +
                "Zip Code: " + zipCode + '\n';
    }
}
