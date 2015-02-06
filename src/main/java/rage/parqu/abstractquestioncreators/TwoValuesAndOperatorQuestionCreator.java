package rage.parqu.abstractquestioncreators;

import java.util.HashMap;
import rage.parqu.domain.Question;
import rage.parqu.util.Operator;
import static rage.parqu.util.Randomizer.randomOperator;
import static rage.parqu.util.Randomizer.randomSmallPositiveInteger;

public abstract class TwoValuesAndOperatorQuestionCreator extends QuestionCreator{
    
    protected int startingValue;
    protected int firstModifier;
    protected Operator operator;

    @Override
    protected void randomizeParameters() {
        startingValue = randomSmallPositiveInteger();
        firstModifier = randomSmallPositiveInteger();
        if(startingValue == firstModifier){
            randomizeParameters();
        }
        operator = randomOperator();
    }

    @Override
    protected HashMap<String, Object> setUpScope() {
        HashMap<String, Object> scopes = new HashMap<>();
        scopes.put("operator", operator.toString());
        scopes.put("value", startingValue);
        scopes.put("first", firstModifier);
        
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
