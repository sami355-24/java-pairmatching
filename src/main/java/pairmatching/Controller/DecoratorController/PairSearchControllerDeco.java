package pairmatching.Controller.DecoratorController;

import pairmatching.Controller.PairSearchController;
import pairmatching.Exception.InvalidInputException;
import pairmatching.Exception.NoHistoryException;

public class PairSearchControllerDeco extends PairSearchController {

    public PairSearchControllerDeco() {
        super();
    }

    @Override
    public void run() {
        while (true) {
            try {
                super.run();
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            } catch (NoHistoryException e) {
                System.out.println(e.getMessage());
                return;
            } finally {
                System.out.println();
            }
        }
    }
}
