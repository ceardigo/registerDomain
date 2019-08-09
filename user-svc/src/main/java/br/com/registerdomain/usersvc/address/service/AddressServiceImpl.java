package br.com.registerdomain.usersvc.address.service;

import br.com.registerdomain.usersvc.address.boundary.AddressRepository;
import br.com.registerdomain.usersvc.address.model.Address;
import br.com.registerdomain.usersvc.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public Address retrieveAddressById(int idAddress) {
        var address = this.addressRepository.findById(idAddress);

        if (!address.isPresent()){
            throw new RecordNotFoundException("Address not found");
        }

        return address.get();
    }

    @Override
    public List<Address> retriveAllAddressesByUserId(int userId) {
        return this.addressRepository.getAddressByUserId(userId);
    }

    @Override
    public int createAddress(List<Address> listAddresses) {
        try{
            var x = this.addressRepository.saveAll(listAddresses);
            System.out.println(x);
            return 1;
        }
        catch(DataIntegrityViolationException e){
            //throw new RecordNotFoundException(String.format("User [%d] does not exists", address.getUserId()));
            throw new RecordNotFoundException("User [%d] does not exists");
        }
    }


}
