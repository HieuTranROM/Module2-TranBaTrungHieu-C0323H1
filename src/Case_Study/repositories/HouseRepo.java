package Case_Study.repositories;

import Case_Study.models.House;
import Case_Study.utils.CSVUltils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HouseRepo {
    private static final String HOUSE_FILE_PATH = "D:\\CodegymFT\\module2\\src\\Case_Study\\data\\house.csv";

    public List<House> getAllHouses() {
        List<String> lines = CSVUltils.read(HOUSE_FILE_PATH);
        List<House> houses = new ArrayList<>();
        for (String line : lines) {
            String[] fields = line.split(",");
            houses.add(new House(fields[0], Integer.parseInt(fields[1]), Double.parseDouble(fields[2]), fields[3], fields[4], Integer.parseInt(fields[5])));
        }
        return houses;
    }

    public void saveHouses(List<House> houses) {
        List<String> lines = houses.stream().map(house -> house.getServiceName() + "," + house.getNumberOfPeople() + "," + house.getRentalCost() + "," + house.getRoomStandard() + "," + house.getRentalType() + "," + house.getNumberOfFloors()).collect(Collectors.toList());
        CSVUltils.write(HOUSE_FILE_PATH, lines);
    }


}
