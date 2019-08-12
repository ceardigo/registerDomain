package br.com.registerdomain.usersvc.address.api;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateAddressRequestParam {

    @Min(value = 1)
    private int userId;

    @NotBlank
    @Size(min = 10, max = 255)
    private String street;

    @NotBlank
    @Size(min = 10, max = 255)
    private String city;

    @NotBlank
    @Size(min = 10, max = 255)
    private String state;

    @NotBlank
    @Size(min = 10, max = 255)
    private String zipCode;

    @NotBlank
    @Size(min = 10, max = 255)
    private String country;

    @NotBlank
    @Size(min = 10, max = 255)
    private String description;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
