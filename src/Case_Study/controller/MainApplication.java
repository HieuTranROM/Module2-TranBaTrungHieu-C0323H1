package Case_Study.controller;

import Case_Study.common.InvalidInputException;
import Case_Study.view.ResortView;

import java.io.IOException;

public class MainApplication {
    public static void main(String[] args) throws IOException, InvalidInputException {
        ResortView resortView = new ResortView();
        resortView.renderView();
    }
}
