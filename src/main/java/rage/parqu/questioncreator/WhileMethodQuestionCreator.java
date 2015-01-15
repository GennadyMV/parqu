package rage.parqu.questioncreator;

import java.util.HashMap;
import rage.parqu.domain.Question;
import static rage.parqu.util.Randomizer.randomSmallNegativeInteger;
import static rage.parqu.util.Randomizer.randomSmallPositiveInteger;

public class WhileMethodQuestionCreator extends QuestionCreator{

    protected int first;
    protected int second;

    public WhileMethodQuestionCreator() {
        super.setTemplateName("complicatedmethod.mustache");
    }

    @Override
    protected void randomizeParameters() {
        first = randomSmallPositiveInteger();
        second = first + randomSmallPositiveInteger() + 1;
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
        question.setQuestionText("Kuinka monta askelta otetaan/tulostetaan?");
        int range = randomSmallNegativeInteger();
        int rightAnswer = (((first + second)/2) - first);
        question.setAnswers("" + (rightAnswer + (range)), "" + (rightAnswer + (range + 1)),  "" + (rightAnswer + (range + 2)),  "" + (rightAnswer + (range + 3)));
        return question;       
    }

    @Override
    protected String determineRightAnswer() {
        return "" + (((first + second)/2) - first);
    }
    
}
