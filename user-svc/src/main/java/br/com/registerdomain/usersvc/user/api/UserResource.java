package br.com.registerdomain.usersvc.user.api;

import br.com.registerdomain.usersvc.address.api.AddressApi;
import br.com.registerdomain.usersvc.user.model.User;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

public class UserResource extends RepresentationModel {
    public static final String USERS = "/users/";
    public static final String ADDRESSES = "addresses";
    private User user;

    public UserResource(User user) {
        this.user = user;
        this.add(WebMvcLinkBuilder.linkTo(UserApi.class).slash(user.getId()).withSelfRel());
        this.add(WebMvcLinkBuilder.linkTo(AddressApi.class).slash(USERS).slash(user.getId()).withRel(ADDRESSES));

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
