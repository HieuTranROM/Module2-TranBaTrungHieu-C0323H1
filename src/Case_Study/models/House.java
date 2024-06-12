package Case_Study.models;

public class House extends Facility {
    private int numberOfFloors;

    public House() {
    }

    public House(String serviceName, int numberOfPeople, double rentalCost, String roomStandard, String rentalType, int numberOfFloors) {
        super(serviceName, numberOfPeople, rentalCost, roomStandard, rentalType);
        this.numberOfFloors = numberOfFloors;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return "House{" +
                "serviceName='" + getServiceName() + '\'' +
                ", numberOfPeople=" + getNumberOfPeople() +
                ", rentalCost=" + getRentalCost() +
                ", roomStandard='" + getRoomStandard() + '\'' +
                ", rentalType='" + getRentalType() + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }
}