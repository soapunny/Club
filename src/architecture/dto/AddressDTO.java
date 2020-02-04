package architecture.dto;

import architecture.entity.Address;
import architecture.entity.AddressType;

public class AddressDTO {
    //
    private String streetAddress;
    private String nation;
    private int zipCode;
    private AddressType addressType;

    private AddressDTO(){
        //
        nation = "South Korea";
        addressType = AddressType.Home;
    }

    public AddressDTO(String streetAddress, String zipCode){
        //
        this.streetAddress = streetAddress;
        setZipCode(zipCode);
    }

    public AddressDTO(Address address){
        //
        this.streetAddress = address.getStreetAddress();
        this.nation = address.getNation();
        this.zipCode = address.getZipCode();
        this.addressType = address.getAddressType();
    }

    public Address toAddress(){
        //
        Address address = new Address(streetAddress);
        address.setNation(nation);
        address.setZipCode(String.valueOf(zipCode));
        address.setAddressType(addressType);

        return address;
    }

    @Override
    public String toString(){
        //
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("[%s] ", addressType))
                     .append(streetAddress)
                     .append(", "+nation)
                     .append(String.format("(%s)",zipCode));

        return stringBuilder.toString();
    }


    public String getStreetAddress() {
        return streetAddress;
    }
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
    public int getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        try {
            if(zipCode.length() != 5)
                throw new NumberFormatException("The zip code must have 5 numbers!!");
            int zipCodeToInt = Integer.parseInt(zipCode);
            this.zipCode = zipCodeToInt;
        }catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
    public String getNation() {
        return nation;
    }
    public void setNation(String nation) {
        this.nation = nation;
    }
    public AddressType getAddressType() {
        return addressType;
    }
    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }
}
