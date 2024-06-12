package Case_Study.models;

public class Customer extends Person {
    private String type;
    private String address;

    public Customer() {
    }

    public Customer(String id, String email, String phoneNumber, String idCard, String gender, String birthDate, String name, String address, String type) {
        super(id, email, phoneNumber, idCard, gender, birthDate, name);
        this.address = address;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", dob='" + getBirthDate() + '\'' +
                ", gender='" + getGender() + '\'' +
                ", idCard='" + getIdCard() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", type='" + getType() + '\'' +
                ", address=" + getAddress() +
                '}';
    }
}
