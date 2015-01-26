package rage.parqu.questioncreator;

import rage.parqu.abstractquestioncreators.QuestionCreator;
import java.util.HashMap;
import rage.parqu.domain.Question;
import rage.parqu.util.Operator;
import static rage.parqu.util.Randomizer.randomOperator;
import static rage.parqu.util.Randomizer.randomSmallPositiveInteger;

public class EditValueAndIncrementQuestionCreator extends QuestionCreator{
    
    private Operator operator;
    private int value;
    private int firstModifier;
    private int secondModifier;
    
    public EditValueAndIncrementQuestionCreator(){
        super.setTemplateName("editvalueplus.mustache");
    }

    @Override
    protected void randomizeParameters() {
        firstModifier = randomSmallPositiveInteger();
        secondModifier = randomSmallPositiveInteger();
        while(firstModifier == secondModifier){
           firstModifier = randomSmallPositiveInteger();
           secondModifier = randomSmallPositiveInteger(); 
        }
        value = randomSmallPositiveInteger();
        operator = randomOperator();
    }

    @Override
    protected HashMap<String, Object> setUpScope() {
        HashMap<String, Object> scopes = new HashMap<>();
        scopes.put("operator", operator.toString());
        scopes.put("value", value);
        scopes.put("first", firstModifier);
        scopes.put("second", secondModifier);
        
        return scopes;
    }

    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Mikä numero tulostetaan?");
        question.setAnswers("" + (value + firstModifier), "" + (value - firstModifier), "" + (value - (firstModifier + secondModifier)), "" + value, "" + (value + (firstModifier + secondModifier)), "" + (value + secondModifier), "" + (value - secondModifier));
        return question;    
    }

    @Override
    protected String determineRightAnswer() {
        if(operator == Operator.PLUS){
            return "" + (value + secondModifier);
        } else if (operator == Operator.MINUS){
            return "" + (value - secondModifier);
        } else {
            return "töttöröö";
        }    
    }
}