package rage.parqu.questioncreator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import rage.parqu.domain.Question;
import static rage.parqu.util.Randomizer.randomSmallPositiveInteger;
import static rage.parqu.util.Randomizer.randomString;

public class CharAtQuestionCreator extends QuestionCreator{

    private String first;
    private String second;
    private int firstIndex;
    private int secondIndex;

    public CharAtQuestionCreator() {
        super.setTemplateName("charat.mustache");
    }

    @Override
    protected void randomizeParameters() {
        first = randomString();
        second = randomString();
        if(!first.equals(second)){
            firstIndex = randomSmallPositiveInteger();
            secondIndex = randomSmallPositiveInteger();
        } else {
            randomizeParameters();  
        }
    }

    @Override
    protected HashMap<String, Object> setUpScope() {
        HashMap<String, Object> scopes = new HashMap<>();
        scopes.put("first", first);
        scopes.put("second", second);
        scopes.put("firstIndex", firstIndex);
        scopes.put("secondIndex", secondIndex);
        
        return scopes;    
    }

    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Mitä tulostetaan?");
        question.setAnswers(buildAnswers());
        return question;       
    }

    @Override
    protected String determineRightAnswer() {
        System.out.println("" + first.charAt(firstIndex) + second.charAt(secondIndex));
        return "" + first.charAt(firstIndex) + second.charAt(secondIndex);
    }

    private List<String> buildAnswers() {
        List<String> answers = new ArrayList();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j < 1; j++) {
                answers.add("" + first.charAt(firstIndex + i) + second.charAt(secondIndex + j));        
            }
        }        
        return answers;
    }
    
}
