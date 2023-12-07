package pairmatching.Controller.DecoratorController;

import pairmatching.Controller.PairSearchController;
import pairmatching.Exception.InvalidInputException;

public class PairSearchControllerDeco extends PairSearchController {

    public PairSearchControllerDeco() {
        super();
    }

    @Override
    public void run() {
        try {
            super.run();
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }
}
