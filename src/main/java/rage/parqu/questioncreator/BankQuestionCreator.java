package rage.parqu.questioncreator;

import java.util.HashMap;
import rage.parqu.domain.Question;
import static rage.parqu.util.Randomizer.randomSmallPositiveInteger;

public class BankQuestionCreator extends QuestionCreator{
    
    private int cash;
    private int value;
    private int border;

    public BankQuestionCreator() {
        super.setTemplateName("bank.mustache");
    }

    @Override
    protected void randomizeParameters() {
        cash = randomSmallPositiveInteger();
        value = randomSmallPositiveInteger();
        border = randomSmallPositiveInteger();
    }  
    
    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Mikä numero tulostetaan?");
        question.setAnswers("" + (cash + border), "" + (cash + value), "" + (value + border), "" + cash);
        return question;
    }

    @Override
    protected HashMap<String, Object> setUpScope() {
        HashMap<String, Object> scopes = new HashMap<>();
        scopes.put("cash", cash);
        scopes.put("value", value);
        scopes.put("border", border);
        return scopes;
    }

    @Override
    protected String determineRightAnswer() {
        if(value > border){
            return "" + (cash + border);
        } else {
            return "" + (cash + value);
        }
    }
}
