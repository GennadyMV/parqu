package rage.parqu.questioncreator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import rage.parqu.abstractquestioncreators.QuestionCreator;
import rage.parqu.domain.Question;
import static rage.parqu.util.Randomizer.randomPositiveIntegerInclusive;
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
            firstIndex = randomPositiveIntegerInclusive(first.length() - 1);
            secondIndex = randomPositiveIntegerInclusive(second.length()- 1);
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
        return "" + first.charAt(firstIndex) + second.charAt(secondIndex);
    }

    private Set<String> buildAnswers() {
        Set<String> answers = new HashSet();
        int iStart = determineStartingIndex(first, firstIndex);
        int jStart = determineStartingIndex(second, secondIndex);
        
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                answers.add("" + first.charAt(iStart + i) + second.charAt(jStart + j));        
            }
        }        
        return answers;
    }

    private int determineStartingIndex(String string, int index) {
        if(index == 0){
            return 0;
        } else if(string.equals("Leo")){
            return 0;
        } else if (index >= (string.length() - 2)){
            return string.length() - 3;
        } 
        return 0;
    }
    
}
