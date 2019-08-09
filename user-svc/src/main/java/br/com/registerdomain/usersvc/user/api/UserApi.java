package br.com.registerdomain.usersvc.user.api;

import br.com.registerdomain.usersvc.user.model.User;
import br.com.registerdomain.usersvc.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/user")
@Validated
public class UserApi {

    @Autowired
    private UserService userService;

    /**
     * Get all users
     *
     * @return List<User>
     */
    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers() {
        return this.userService.listUsers();

    }

    /**
     * Get specific user
     *
     * @param userId - User ID to retrieve
     * @return User
     */
    @GetMapping(path = "/{id}", produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public UserResource getUserById(@PathVariable("id") @Min(value = 1) int userId) {
        UserResource userResource = new UserResource(this.userService.retrieveUserById(userId));
        userResource.add(WebMvcLinkBuilder.linkTo(UserApi.class).slash(userId).withSelfRel());

        //return this.userService.retrieveUserById(userId);
        return userResource;
    }

    /**
     * Create a new user
     *
     * @param createUserRequestParam - Parameters necessary to create user
     * @return ID created
     */
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateUserResponseParam createNewUser(@Valid @RequestBody CreateUserRequestParam createUserRequestParam) {
        int id = this.userService.createUser(User.of(createUserRequestParam));
        return new CreateUserResponseParam(id);
    }

}
