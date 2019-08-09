package br.com.registerdomain.usersvc.user.api;

import br.com.registerdomain.usersvc.user.model.User;
import org.springframework.hateoas.RepresentationModel;

public class UserResource extends RepresentationModel {
    private User user;

    public UserResource(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
