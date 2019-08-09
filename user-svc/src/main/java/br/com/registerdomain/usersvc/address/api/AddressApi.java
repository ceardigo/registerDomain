package br.com.registerdomain.usersvc.address.api;

import br.com.registerdomain.usersvc.address.model.Address;
import br.com.registerdomain.usersvc.address.model.AddressStatus;
import br.com.registerdomain.usersvc.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/address")
@Validated
public class AddressApi {

    @Autowired
    private AddressService addressService;

    /**
     * Get specific address
     *
     * @param idAddress - ID
     * @return Address
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Address getAddressById(@PathVariable("id") @Min(value = 1) int idAddress){
        return this.addressService.retrieveAddressById(idAddress);
    }

    /**
     * Get all addresses for a user, could be filtered or not
     *
     * @param userId - User ID
     * @param addressStatus - If populated, will filter the results
     * @return List<Address>
     */
    @GetMapping(path = "/user/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<Address> getAllAddressByUserId(@PathVariable("id") @Min(value = 1) int userId, @RequestParam(value = "status", required = false) AddressStatus addressStatus) {
        return filterAddressResponse(this.addressService.retriveAllAddressesByUserId(userId), addressStatus);
    }


    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateAddressResponseParam createNewAddress(@RequestBody @Valid CreateAddressRequestParam[] createAddressRequestParam) {


        List listAddresses = Arrays.stream(createAddressRequestParam)
                .map(a -> Address.of(a))
                .collect(Collectors.toList());


        int addressId = this.addressService.createAddress(listAddresses);
        return new CreateAddressResponseParam(1);
    }


    /**
     * Filter address if necessary
     *
     * @param listAddress - List of address found
     * @param addressStatus - Status to filter
     * @return List filtered
     */
    private List<Address> filterAddressResponse(List<Address> listAddress, AddressStatus addressStatus) {
        if (addressStatus == null) {
            return listAddress;
        }

        return listAddress.stream()
                .filter(a -> a.getStatus() == addressStatus)
                .collect(Collectors.toList());
    }



}
