package br.com.registerdomain.usersvc.user.model;

import br.com.registerdomain.usersvc.address.model.Address;
import br.com.registerdomain.usersvc.user.api.CreateUserRequestParam;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id_user", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
    private String password;

    @Column(name = "login_number")
    private int loginNumber;

    @Column(name = "date_user_created")
    private LocalDateTime dateCreated;

    @Column(name = "date_user_updated")
    private LocalDateTime dateUpdated;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Address.class, mappedBy = "userId", orphanRemoval = true)
    private List<Address> listAddress;

    public static User of(CreateUserRequestParam createUserRequestParam){
        var user = new User();
        user.setName(createUserRequestParam.getName());
        user.setEmail(createUserRequestParam.getEmail());
        user.setPassword(createUserRequestParam.getPassword());
        user.setLoginNumber(0);
        user.setDateCreated(LocalDateTime.now());
        user.setDateUpdated(null);
        return user;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLoginNumber() {
        return loginNumber;
    }

    public void setLoginNumber(int loginNumber) {
        this.loginNumber = loginNumber;
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

    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public List<Address> getListAddress() {
        return listAddress;
    }

    public void setListAddress(List<Address> listAddress) {
        this.listAddress = listAddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", loginNumber=" + loginNumber +
                ", dateCreated=" + dateCreated +
                ", dateUpdated=" + dateUpdated +
                //", listAddress=" + listAddress +
                '}';
    }
}
