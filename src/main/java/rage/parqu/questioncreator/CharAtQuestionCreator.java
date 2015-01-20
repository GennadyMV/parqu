package rage.parqu.questioncreator;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
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
            firstIndex = randomSmallPositiveInteger(first.length() - 1);
            secondIndex = randomSmallPositiveInteger(second.length()- 1);
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

    private String[] buildAnswers() {
        Set<String> answers = new TreeSet();
        int iStart = determineStartingIndex(first, firstIndex);
        int jStart = determineStartingIndex(second, secondIndex);
        
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                answers.add("" + first.charAt(iStart + i) + second.charAt(jStart + j));        
            }
        }        
        return answers.toArray(new String[0]);
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
