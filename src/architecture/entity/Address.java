package architecture.entity;

public class Address {
    //
    private String streetAddress;
    private int zipCode;
    private String nation;
    private AddressType addressType;

    private Address(){
        //
        nation = "South Korea";
        addressType = AddressType.HOME;
    }

    public Address(String streetAddress){
        //
        this();
        this.streetAddress = streetAddress;
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
