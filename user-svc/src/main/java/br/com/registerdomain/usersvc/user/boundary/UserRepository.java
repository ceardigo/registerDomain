package br.com.registerdomain.usersvc.user.boundary;

import br.com.registerdomain.usersvc.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
