package rage.parqu.questioncreator;

import rage.parqu.abstractquestioncreators.QuestionCreator;
import java.util.HashMap;
import rage.parqu.domain.Question;
import static rage.parqu.util.Randomizer.randomSmallPositiveInteger;
import static rage.parqu.util.Randomizer.randomString;

public class StringsAndNumbersQuestionCreator extends QuestionCreator{

    private int first;
    private int second;
    private String string;

    public StringsAndNumbersQuestionCreator() {
        super.setTemplateName("stringsandnumbers.mustache");
    }

    @Override
    protected void randomizeParameters() {
        first = randomSmallPositiveInteger();
        second = randomSmallPositiveInteger();
        string = randomString();
    }

    @Override
    protected HashMap<String, Object> setUpScope() {
        HashMap<String, Object> scopes = new HashMap<>();
        scopes.put("first", first);
        scopes.put("second", second);
        scopes.put("string", string);
        
        return scopes;    
    }

    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Mitä tulostetaan?");
        question.setAnswers(string + (first + second), string + first + second, string, "merkkijono" + first + second, "merkkijono " + (first + second), string + " " + first + " " + second);
        return question;       
    }

    @Override
    protected String determineRightAnswer() {
        return string + first + second;
    }
    
}

