package Case_Study.service.impl;

import Case_Study.common.InvalidInputException;
import Case_Study.models.House;
import Case_Study.models.Villa;
import Case_Study.repositories.HouseRepo;
import Case_Study.repositories.VillaRepo;
import Case_Study.service.FacilityService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {
    private HouseRepo houseRepo;
    private VillaRepo villaRepo;

    public FacilityServiceImpl() {
        this.houseRepo = new HouseRepo();
        this.villaRepo = new VillaRepo();
    }

    @Override
    public void addHouse() throws InvalidInputException, IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter service name: ");
        String serviceName = scanner.nextLine();

        System.out.print("Enter number of people: ");
        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter rental cost: ");
        double rentalCost = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter room standard: ");
        String roomStandard = scanner.nextLine();

        System.out.print("Enter rental type: ");
        String rentalType = scanner.nextLine();

        System.out.print("Enter number of floors: ");
        int numberOfFloors = Integer.parseInt(scanner.nextLine());

        House house = new House(serviceName, numberOfPeople, rentalCost, roomStandard, rentalType, numberOfFloors);
        List<House> houses = houseRepo.getAllHouses();
        houses.add(house);
        houseRepo.saveHouses(houses);

        System.out.println("New house added successfully.");
    }

    @Override
    public void addVilla() throws InvalidInputException, IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter service name: ");
        String serviceName = scanner.nextLine();

        System.out.print("Enter number of people: ");
        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter rental cost: ");
        double rentalCost = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter room standard: ");
        String roomStandard = scanner.nextLine();

        System.out.print("Enter rental type: ");
        String rentalType = scanner.nextLine();

        System.out.print("Enter pool area: ");
        double poolArea = Double.parseDouble(scanner.nextLine());

        Villa villa = new Villa(serviceName, numberOfPeople, rentalCost, roomStandard, rentalType, poolArea);
        List<Villa> villas = villaRepo.getAllVillas();
        villas.add(villa);
        villaRepo.saveVillas(villas);

        System.out.println("New villa added successfully.");
    }

    @Override
    public void displayAllFacilities() {
        System.out.println("Houses:");
        List<House> houses = houseRepo.getAllHouses();
        for (House house : houses) {
            System.out.println(house);
        }

        System.out.println("Villas:");
        List<Villa> villas = villaRepo.getAllVillas();
        for (Villa villa : villas) {
            System.out.println(villa);
        }
    }

    @Override
    public void deleteFacility(String serviceName) throws IOException {
        boolean houseRemoved = false;
        List<House> houses = houseRepo.getAllHouses();
        houseRemoved = houses.removeIf(house -> house.getServiceName().equals(serviceName));
        if (houseRemoved) {
            houseRepo.saveHouses(houses);
            System.out.println("House with service name " + serviceName + " deleted successfully.");
            return;
        }

        boolean villaRemoved = false;
        List<Villa> villas = villaRepo.getAllVillas();
        villaRemoved = villas.removeIf(villa -> villa.getServiceName().equals(serviceName));
        if (villaRemoved) {
            villaRepo.saveVillas(villas);
            System.out.println("Villa with service name " + serviceName + " deleted successfully.");
            return;
        }

        System.out.println("Facility with service name " + serviceName + " not found.");
    }
}
