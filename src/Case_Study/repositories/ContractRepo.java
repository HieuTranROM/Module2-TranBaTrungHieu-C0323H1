package Case_Study.repositories;

import Case_Study.models.Contract;
import Case_Study.utils.CSVUltils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepo {
    private final String filePath = "D:\\CodegymFT\\module2\\src\\Case_Study\\data\\contract.csv";

    public List<Contract> getAllContracts() {
        List<Contract> contracts = new ArrayList<>();
        List<String> lines = CSVUltils.read(filePath);
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length == 5) {
                Contract contract = new Contract(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]), Double.parseDouble(parts[4]));
                contracts.add(contract);
            } else {
                System.out.println("Invalid line format: " + line);
            }
        }
        return contracts;
    }

    public void saveContracts(List<Contract> contracts) {
        List<String> lines = new ArrayList<>();
        for (Contract contract : contracts) {
            lines.add(contract.toString());
        }
        CSVUltils.write(filePath, lines);
    }

    public boolean isDuplicateId(String id) {
        List<Contract> contracts = getAllContracts();
        return contracts.stream().anyMatch(contract -> contract.getContractId().equals(id));
    }
}

