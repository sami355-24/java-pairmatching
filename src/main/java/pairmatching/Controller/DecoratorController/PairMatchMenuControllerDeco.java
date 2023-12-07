package pairmatching.Controller.DecoratorController;

import pairmatching.Controller.PairMatchMenuController;
import pairmatching.Exception.InvalidInputException;
import pairmatching.Exception.RetryException;

public class PairMatchMenuControllerDeco extends PairMatchMenuController {

    public PairMatchMenuControllerDeco() {
        super();
    }

    @Override
    public void matchPair() {
        while (true) {
            try {
                super.matchPair();
                break;
            } catch (RetryException e) {
                System.out.println(e.getMessage());
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println();
            }
        }
    }
}
