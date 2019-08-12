package br.com.registerdomain.usersvc.address.api;

import br.com.registerdomain.usersvc.address.model.Address;
import br.com.registerdomain.usersvc.address.model.AddressStatus;
import br.com.registerdomain.usersvc.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/addresses")
@Validated
public class AddressApi {

    private final AddressService addressService;

    @Autowired
    public AddressApi(AddressService addressService) {
        this.addressService = addressService;
    }

    /**
     * Get specific address
     *
     * @param idAddress - ID
     * @return Address
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AddressResource getAddressById(@PathVariable("id") @Min(value = 1) int idAddress){
        return new AddressResource(this.addressService.retrieveAddressById(idAddress));
    }

    /**
     * Get all addresses for a user, could be filtered or not
     *
     * @param userId - User ID
     * @param addressStatus - If populated, will filter the results
     * @return List<Address>
     */
    @GetMapping(path = "/users/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<AddressResource> getAllAddressByUserId(@PathVariable("id") @Min(value = 1) int userId, @RequestParam(value = "status", required = false) AddressStatus addressStatus) {
        List<Address> listAddresses = filterAddressResponse(this.addressService.retriveAllAddressesByUserId(userId), addressStatus);

        return listAddresses
                .stream()
                .map(AddressResource::new)
                .collect(Collectors.toList());
    }


    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewAddress(@RequestBody @Valid CreateAddressRequestParam[] createAddressRequestParam) {


        List<Address> listAddresses = Arrays.stream(createAddressRequestParam)
                .map(Address::of)
                .collect(Collectors.toList());

        this.addressService.createAddress(listAddresses);
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
                .filter(address -> address.getStatus() == addressStatus)
                .collect(Collectors.toList());
    }



}
