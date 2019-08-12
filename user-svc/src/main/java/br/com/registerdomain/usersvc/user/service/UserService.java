package br.com.registerdomain.usersvc.user.service;

import br.com.registerdomain.usersvc.exception.RecordNotFoundException;
import br.com.registerdomain.usersvc.user.boundary.UserRepository;
import br.com.registerdomain.usersvc.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> listUsers(){
        return this.userRepository.findAll();
    }

    public User retrieveUserById(int userId){
        var user = this.userRepository.findById(userId);
        if (!user.isPresent()){
            throw new RecordNotFoundException("User not found");
        }

        return user.get();
    }

    public int createUser(User user){
        return this.userRepository.save(user).getId();
    }

}
