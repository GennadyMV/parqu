package rage.parqu.questioncreator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import rage.parqu.abstractquestioncreators.QuestionCreator;
import rage.parqu.domain.Question;
import static rage.parqu.util.Randomizer.randomPositiveIntegerFromOne;
import static rage.parqu.util.Randomizer.randomString;

public class SetSizeQuestionCreator extends QuestionCreator {

    private List<String> names;
    private int values;
    private int repeats;

    public SetSizeQuestionCreator() {
        super.setTemplateName("setsize.mustache");
    }

    @Override
    protected void randomizeParameters() {
        repeats = randomPositiveIntegerFromOne(3);
        values = randomPositiveIntegerFromOne(3);
        if(repeats > values){
            this.randomizeParameters();
            return;
        }
        names = new ArrayList();
        while (names.size() < 3) {
            String newName = randomString();
            names.add(newName);
        }
    }

    @Override
    protected HashMap<String, Object> setUpScope() {
        HashMap<String, Object> scopes = new HashMap<>();
        for (int i = 1; i <= repeats; i++) {
            scopes.put("name" + i, names.get(i-1));        
        }
        for (int i = 1; i <= values; i++) {
            scopes.put("repeat" + i, names.get(i-1));                    
        }
        return scopes;
    }

    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Mikä on setin koko?");
        question.setAnswers("" + 0, "" + 1, "" + 2, "" + 3, "" + 4, "" + 5, "" + 6);
        return question;
    }

    @Override
    protected String determineRightAnswer() {
        return "" + Math.max(values, repeats);
    }

}

