package rage.parqu.questioncreator;

import rage.parqu.abstractquestioncreators.QuestionCreator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import rage.parqu.domain.Question;
import static rage.parqu.util.Randomizer.randomSmallPositiveInteger;
import static rage.parqu.util.Randomizer.randomString;

public class ArrayListIndexQuestionCreator extends QuestionCreator {

    private List<String> names;
    private int correctIndex;

    public ArrayListIndexQuestionCreator() {
        super.setTemplateName("arraylistindex.mustache");
    }

    @Override
    protected void randomizeParameters() {
        names = new ArrayList();
        while (names.size() < 3) {
            String newName = randomString();
            if (!names.contains(newName)) {
                names.add(newName);
            }
        }
        correctIndex = randomSmallPositiveInteger(2);
    }

    @Override
    protected HashMap<String, Object> setUpScope() {
        HashMap<String, Object> scopes = new HashMap<>();
        scopes.put("name", names.get(0));
        scopes.put("name2", names.get(1));
        scopes.put("name3", names.get(2));
        return scopes;
    }

    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Mikä on merkkijonon \"" + names.get(correctIndex) + "\" indeksi?");
        question.setAnswers("" + 0, "" + 1, "" + 2, "" + 3);
        return question;
    }

    @Override
    protected String determineRightAnswer() {
        return "" + correctIndex;
    }

}
