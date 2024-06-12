package Case_Study.service;

import Case_Study.common.InvalidInputException;
import Case_Study.models.Contract;

import java.io.IOException;
import java.util.List;

public interface ContractService {
    void addContract() throws InvalidInputException, IOException;
    void deleteContract(String id) throws IOException;
    List<Contract> getAllContracts();
}

