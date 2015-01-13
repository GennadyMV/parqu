package rage.parqu.questioncreator;

import java.util.HashMap;
import rage.parqu.domain.Question;
import static rage.parqu.util.Randomizer.randomSmallPositiveInteger;

public class SimpleInsertQuestionCreator extends QuestionCreator{

    private int first;
    private int second;

    public SimpleInsertQuestionCreator() {
        super.setTemplateName("simpleinsertion.mustache");
    }

    @Override
    protected void randomizeParameters() {
        first = randomSmallPositiveInteger();
        second = randomSmallPositiveInteger();
        if(first == second){
            randomizeParameters();
        }
    }

    @Override
    protected HashMap<String, Object> setUpScope() {
        HashMap<String, Object> scopes = new HashMap<>();
        scopes.put("first", first);
        scopes.put("second", second);
        
        return scopes;    
    }

    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Mikä numero tulostetaan?");
        question.setAnswers("" + (first + second), "" + (first - second), "" + first, "" + second);
        return question;       
    }

    @Override
    protected String determineRightAnswer() {
        return "" + second;
    }
    
}
