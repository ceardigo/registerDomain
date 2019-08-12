package br.com.registerdomain.usersvc.address.api;

public class CreateAddressResponseParam {

    private int id;

    public CreateAddressResponseParam(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
