package rage.parqu.questioncreator;

import java.util.HashMap;
import rage.parqu.domain.Question;
import rage.parqu.util.Operator;
import static rage.parqu.util.Randomizer.randomOperator;
import static rage.parqu.util.Randomizer.randomSmallPositiveInteger;

public class EditValueQuestionCreator extends QuestionCreator{
    
    private Operator operator;
    private int modifier;
    private int value;
    
    public EditValueQuestionCreator(){
        super.setTemplateName("editvalue.mustache");
    }

    @Override
    protected void randomizeParameters() {
        modifier = randomSmallPositiveInteger();
        value = randomSmallPositiveInteger();
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
        question.setAnswers("" + (value + modifier), "" + (modifier - value), "" + (value - modifier), "" + value, "" + modifier);
        return question;    
    }

    @Override
    protected String determineRightAnswer() {
        return "" + value;
    }
}