package br.com.registerdomain.usersvc.address.api;

import br.com.registerdomain.usersvc.address.model.Address;
import br.com.registerdomain.usersvc.user.api.UserApi;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

public class AddressResource extends RepresentationModel {
    private static final String ADDRESSES = "/addresses/";
    private static final String USERS = "USERS";
    private Address address;

    public AddressResource(Address address) {
        this.address = address;
        this.add(WebMvcLinkBuilder.linkTo(AddressApi.class).slash(address.getId()).withSelfRel());
        this.add(WebMvcLinkBuilder.linkTo(UserApi.class).slash(address.getUserId()).withRel(USERS));
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
