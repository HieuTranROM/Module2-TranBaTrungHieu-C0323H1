package Case_Study.service;

import Case_Study.common.InvalidInputException;

import java.io.IOException;

public interface FacilityService {
    void addHouse() throws InvalidInputException, IOException;
    void addVilla() throws InvalidInputException, IOException;
    void displayAllFacilities();
    void deleteFacility(String serviceName) throws IOException;
}
