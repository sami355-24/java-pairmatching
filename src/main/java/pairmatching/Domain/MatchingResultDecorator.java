package pairmatching.Domain;

import static pairmatching.Message.Excepton.ExceptionPrompt.CAN_NOT_MATCHED;


public class MatchingResultDecorator extends MatchingResult{

    MatchingResult target;

    public MatchingResultDecorator(String option) {
        super(option);
        this.target = new MatchingResult(option);
    }


    @Override
    public void makeMatchingResult() {
        int count = 0;
        while (count < 3){
            try {
                super.makeMatchingResult();
                break;
            } catch (IllegalArgumentException e) {
                count++;
            }
        }
        System.out.println(CAN_NOT_MATCHED.getPrompt());
    }
}
