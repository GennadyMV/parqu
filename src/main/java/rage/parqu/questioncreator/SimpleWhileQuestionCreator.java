package rage.parqu.questioncreator;

import java.util.HashMap;
import rage.parqu.domain.Question;
import static rage.parqu.util.Randomizer.randomSmallNegativeInteger;
import static rage.parqu.util.Randomizer.randomSmallPositiveInteger;

public class SimpleWhileQuestionCreator extends QuestionCreator{

    private int first;
    private int second;

    public SimpleWhileQuestionCreator() {
        super.setTemplateName("simplewhile.mustache");
    }

    @Override
    protected void randomizeParameters() {
        first = randomSmallPositiveInteger();
        second = randomSmallPositiveInteger();
        if(first == second){
            randomizeParameters();
        } else {
            if(second < first){
                int temp = first;
                first = second;
                second = temp;
            }
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
        question.setQuestionText("Kuinka monta kertaa tulostetaan \"Tööt?\"");
        int range = randomSmallNegativeInteger();
        question.setAnswers( "" + ((second - first) + (range + 4)), "" + ((second - first) + range), "" + ((second - first) + (range + 2)), "" + ((second - first) + (range + 1)), "" + ((second - first) + (range + 3)));
        return question;       
    }

    @Override
    protected String determineRightAnswer() {
        return "" + (second - first);
    }
    
}

