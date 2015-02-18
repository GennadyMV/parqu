package rage.parqu.questioncreator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import rage.parqu.abstractquestioncreators.QuestionCreator;
import rage.parqu.domain.Question;
import static rage.parqu.util.Randomizer.randomPositiveIntegerFromZero;

public class ForBorderQuestionCreator extends QuestionCreator {

    private List<Integer> numbers;
    private int loops;

    public ForBorderQuestionCreator() {
        super.setTemplateName("forborder.mustache");
    }

    @Override
    protected void randomizeParameters() {
        numbers = new ArrayList();
        while (numbers.size() < 8) {
            int newNumber = randomPositiveIntegerFromZero(20);
            if (!numbers.contains(newNumber)) {
                numbers.add(newNumber);
            }
        }
        loops = randomPositiveIntegerFromZero(4) + 3;
    }

    @Override
    protected HashMap<String, Object> setUpScope() {
        HashMap<String, Object> scopes = new HashMap<>();
        for (int i = 0; i < numbers.size(); i++) {
            scopes.put("value" + (i + 1), numbers.get(i));
        }
        scopes.put("loops", loops);
        return scopes;
    }

    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Korvaa kohta \"xxxxxx\" koodipätkällä. Millä näistä ohjelma tulostaa \"Oikein!\"?");
        question.setAnswers(buildAnswers());
        return question;
    }

    @Override
    protected String determineRightAnswer() {
        int stepsFromEdge = ((numbers.size() - loops));
        return "i <= " + ((numbers.size() - stepsFromEdge) - 1);
    }

    private Set<String> buildAnswers() {
        Set<String> answers = new HashSet();
                
        for (int i = 0; i < 9; i++) {
            answers.add("i <= " + i);
        }
        
        return answers;
    }
}