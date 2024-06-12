package Case_Study.repositories;

import Case_Study.models.Villa;
import Case_Study.utils.CSVUltils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VillaRepo {
    private static final String VILLA_FILE_PATH = "D:\\CodegymFT\\module2\\src\\Case_Study\\data\\villa.csv";

    public List<Villa> getAllVillas() {
        List<String> lines = CSVUltils.read(VILLA_FILE_PATH);
        List<Villa> villas = new ArrayList<>();
        for (String line : lines) {
            String[] fields = line.split(",");
            villas.add(new Villa(fields[0], Integer.parseInt(fields[1]), Double.parseDouble(fields[2]), fields[3], fields[4], Double.parseDouble(fields[5])));
        }
        return villas;
    }

    public void saveVillas(List<Villa> villas) {
        List<String> lines = villas.stream().map(villa -> villa.getServiceName() + "," + villa.getNumberOfPeople() + "," + villa.getRentalCost() + "," + villa.getRoomStandard() + "," + villa.getRentalType() + "," + villa.getPoolArea()).collect(Collectors.toList());
        CSVUltils.write(VILLA_FILE_PATH, lines);
    }
}

