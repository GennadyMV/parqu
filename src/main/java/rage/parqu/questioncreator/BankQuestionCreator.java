package rage.parqu.questioncreator;

import java.util.HashMap;
import rage.parqu.domain.Question;
import rage.parqu.util.Randomizer;

public class BankQuestionCreator extends QuestionCreator{
    
    private int cash;
    private int value;
    private int border;

    public BankQuestionCreator() {
        super.setTemplateName("bank.mustache");
    }

    @Override
    protected void randomizeParameters() {
        cash = Randomizer.randomIntegerParameter();
        value = Randomizer.randomIntegerParameter();
        border = Randomizer.randomIntegerParameter();
    }  
    
    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("What is the printed number?");
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
