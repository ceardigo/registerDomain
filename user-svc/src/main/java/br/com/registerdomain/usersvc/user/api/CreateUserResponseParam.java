package br.com.registerdomain.usersvc.user.api;

public class CreateUserResponseParam {

    private int id;

    public CreateUserResponseParam(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
