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
        while (numbers.size() < 7) {
            int newNumber = randomPositiveIntegerFromZero(20);
            if (!numbers.contains(newNumber)) {
                numbers.add(newNumber);
            }
        }
        loops = randomPositiveIntegerFromZero(4) + 2;
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
        question.setQuestionText("Korvaa kohta \"xxxxxx\" koodirivillä. Millä rivillä ohjelma tulostaa \"Oikein!\" ");
        question.setAnswers(buildAnswers());
        return question;
    }

    @Override
    protected String determineRightAnswer() {
        return "i < luvut.length" + "- " + (numbers.size() - loops);
    }

    private Set<String> buildAnswers() {
        Set<String> answers = new HashSet();

        String[] modifiers = {"+ 1", "- 1", "- 2", "- 3"};
        
        answers.add("i < luvut.length");
        answers.add("i <= luvut.length");
        
        for (String modifier : modifiers) {
            answers.add("i < luvut.length " + modifier);
        }
        
        return answers;
    }
}