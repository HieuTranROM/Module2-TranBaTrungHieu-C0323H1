package Case_Study.models;

public abstract class Facility {
    private String serviceName;
    private int numberOfPeople;
    private double rentalCost;
    private String roomStandard;
    private String rentalType;

    public Facility() {
    }

    public Facility(String serviceName, int numberOfPeople, double rentalCost, String roomStandard, String rentalType) {
        this.serviceName = serviceName;
        this.numberOfPeople = numberOfPeople;
        this.rentalCost = rentalCost;
        this.roomStandard = roomStandard;
        this.rentalType = rentalType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(double rentalCost) {
        this.rentalCost = rentalCost;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "serviceName='" + serviceName + '\'' +
                ", numberOfPeople=" + numberOfPeople +
                ", rentalCost=" + rentalCost +
                ", roomStandard='" + roomStandard + '\'' +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }
}

