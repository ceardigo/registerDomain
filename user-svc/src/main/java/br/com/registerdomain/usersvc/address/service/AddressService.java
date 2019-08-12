package br.com.registerdomain.usersvc.address.service;

import br.com.registerdomain.usersvc.address.model.Address;

import java.util.List;

public interface AddressService {
    Address retrieveAddressById(int idAddress);
    List<Address> retriveAllAddressesByUserId(int userId);
    int createAddress(List<Address> listAddresses);
}
