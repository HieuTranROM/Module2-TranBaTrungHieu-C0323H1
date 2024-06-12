package Case_Study.models;

public class Employee extends Person{
    private int salary;
    private String position;

    public Employee() {
    }

    public Employee(int salary, String position) {
        this.salary = salary;
        this.position = position;
    }

    public Employee(String id, String email, String phoneNumber, String idCard, String gender, String birthDate, String name, String position, int salary) {
        super(id, email, phoneNumber, idCard, gender, birthDate, name);
        this.position = position;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String toString() {
        return "Employee{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", dob='" + getBirthDate() + '\'' +
                ", gender='" + getGender() + '\'' +
                ", idCard='" + getIdCard() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", position='" + getPosition() + '\'' +
                ", salary=" + getSalary() +
                '}';
    }
}
