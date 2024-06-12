package Case_Study.models;

public class Villa extends Facility {
    private double poolArea;

    public Villa() {
    }

    public Villa(String serviceName, int numberOfPeople, double rentalCost, String roomStandard, String rentalType, double poolArea) {
        super(serviceName, numberOfPeople, rentalCost, roomStandard, rentalType);
        this.poolArea = poolArea;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "serviceName='" + getServiceName() + '\'' +
                ", numberOfPeople=" + getNumberOfPeople() +
                ", rentalCost=" + getRentalCost() +
                ", roomStandard='" + getRoomStandard() + '\'' +
                ", rentalType='" + getRentalType() + '\'' +
                ", poolArea=" + poolArea +
                '}';
    }

}
