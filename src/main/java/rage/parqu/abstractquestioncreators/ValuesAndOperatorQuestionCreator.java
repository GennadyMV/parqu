package rage.parqu.abstractquestioncreators;

import java.util.HashMap;
import rage.parqu.domain.Question;
import rage.parqu.util.Operator;
import static rage.parqu.util.Randomizer.randomOperator;
import static rage.parqu.util.Randomizer.randomSmallPositiveInteger;

public abstract class ValuesAndOperatorQuestionCreator extends QuestionCreator{
    
    private int value;
    protected int modifier;
    private Operator operator;

    @Override
    protected void randomizeParameters() {
        value = randomSmallPositiveInteger();
        modifier = randomSmallPositiveInteger();
        if(value == modifier){
            randomizeParameters();
        }
        operator = randomOperator();
    }

    @Override
    protected HashMap<String, Object> setUpScope() {
        HashMap<String, Object> scopes = new HashMap<>();
        scopes.put("operator", operator.toString());
        scopes.put("value", value);
        scopes.put("modifier", modifier);
        
        return scopes;    
    }

    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Mikä numero tulostetaan?");
        question.setAnswers("" + (value + modifier), "" + (value - modifier), "" + (modifier - value), "" + value, "" + modifier);
        return question;       
    }

    @Override
    protected String determineRightAnswer() {
        if(operator == Operator.PLUS){
            return "" + (value + modifier);
        } else if (operator == Operator.MINUS){
            return "" + (value - modifier);
        } else {
            return "töttöröö";
        }    
    }

}
