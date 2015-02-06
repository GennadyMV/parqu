package rage.parqu.abstractquestioncreators;

import java.util.HashMap;
import rage.parqu.domain.Question;
import rage.parqu.util.Operator;
import static rage.parqu.util.Randomizer.randomOperator;

public abstract class TwoValuesAndOperatorQuestionCreator extends TwoValueQuestionCreator{

    protected Operator operator;

    @Override
    protected void randomizeParameters() {
        super.randomizeParameters();
        operator = randomOperator();
    }

    @Override
    protected HashMap<String, Object> setUpScope() {
        HashMap<String, Object> scopes = super.setUpScope();
        scopes.put("operator", operator.toString());
        
        return scopes;    
    }

    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Mikä numero tulostetaan?");
        question.setAnswers("" + (startingValue + firstModifier), "" + (startingValue - firstModifier), "" + (firstModifier - startingValue), "" + startingValue, "" + firstModifier);
        return question;       
    }

    @Override
    protected String determineRightAnswer() {
        if(operator == Operator.PLUS){
            return "" + (startingValue + firstModifier);
        } else if (operator == Operator.MINUS){
            return "" + (startingValue - firstModifier);
        } else {
            return "töttöröö";
        }    
    }

}
