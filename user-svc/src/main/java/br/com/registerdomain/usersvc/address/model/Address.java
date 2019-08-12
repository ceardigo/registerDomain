package br.com.registerdomain.usersvc.address.model;

import br.com.registerdomain.usersvc.address.api.CreateAddressRequestParam;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @Column(name = "id_address", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    @Column(name = "id_user")
    private int userId;

    private String street;
    private String city;
    private String state;

    @Column(name = "zip_code")
    private String zipCode;

    private String country;
    private String description;

    @Enumerated(EnumType.STRING)
    private AddressStatus status;

    @Column(name = "date_address_created")
    private LocalDateTime dateCreated;

    @Column(name = "date_address_updated")
    private LocalDateTime dateUpdated;

    public static Address of(CreateAddressRequestParam createAddressRequestParam) {
        var address = new Address();
        address.setUserId(createAddressRequestParam.getUserId());
        address.setStreet(createAddressRequestParam.getStreet());
        address.setCity(createAddressRequestParam.getCity());
        address.setState(createAddressRequestParam.getState());
        address.setZipCode(createAddressRequestParam.getZipCode());
        address.setCountry(createAddressRequestParam.getCountry());
        address.setDescription(createAddressRequestParam.getDescription());
        address.setStatus(AddressStatus.ACTIVE);
        address.setDateCreated(LocalDateTime.now());

        return address;
    }

    public int getId() {
        return id;
    }

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

    public AddressStatus getStatus() {
        return status;
    }

    public void setStatus(AddressStatus status) {
        this.status = status;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", userId=" + userId +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", dateCreated=" + dateCreated +
                ", dateUpdated=" + dateUpdated +
                '}';
    }
}
