package br.com.registerdomain.usersvc.user.api;

import br.com.registerdomain.usersvc.user.model.User;
import br.com.registerdomain.usersvc.user.service.UserService;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@Validated
public class UserApi {

    private final UserService userService;

    @Autowired
    public UserApi(UserService userService) {
        this.userService = userService;
    }

    /**
     * Get all users
     *
     * @return List<User>
     */
    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Timed("GetUsers")
    public List<UserResource> getAllUsers() {
        return this.userService.listUsers()
                .stream()
                .map(UserResource::new)
                .collect(Collectors.toList());

    }

    /**
     * Get specific user
     *
     * @param userId - User ID to retrieve
     * @return User
     */
    @GetMapping(path = "/{id}", produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @Timed("GetSpecificUser")
    public UserResource getUserById(@PathVariable("id") @Min(value = 1) int userId) {
        return new UserResource(this.userService.retrieveUserById(userId));
    }

    /**
     * Create a new user
     *
     * @param createUserRequestParam - Parameters necessary to create user
     * @return ID created
     */
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @Timed("CreateUsers")
    public CreateUserResponseParam createNewUser(@Valid @RequestBody CreateUserRequestParam createUserRequestParam) {
        int id = this.userService.createUser(User.of(createUserRequestParam));
        return new CreateUserResponseParam(id);
    }

}
