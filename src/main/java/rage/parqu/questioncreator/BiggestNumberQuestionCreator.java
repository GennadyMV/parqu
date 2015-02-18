package rage.parqu.questioncreator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import rage.parqu.abstractquestioncreators.QuestionCreator;
import rage.parqu.domain.Question;
import rage.parqu.util.Randomizer;
import static rage.parqu.util.Randomizer.randomPositiveIntegerFromZero;

public class BiggestNumberQuestionCreator extends QuestionCreator {

    private List<Integer> numbers;
    private String variableName;

    public BiggestNumberQuestionCreator() {
        super.setTemplateName("biggestnumber.mustache");
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
        variableName = Randomizer.randomVariableName();
    }

    @Override
    protected HashMap<String, Object> setUpScope() {
        HashMap<String, Object> scopes = new HashMap<>();
        for (int i = 0; i < numbers.size(); i++) {
            scopes.put("value" + (i + 1), numbers.get(i));
        }
        scopes.put("variableName", variableName);
        return scopes;
    }

    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Millä koodipätkällä suurinLuku-metodi toimii oikein?");
        question.setAnswers(buildAnswers());
        return question;
    }

    @Override
    protected String determineRightAnswer() {
        return variableName + " > suurin";
    }

    private Set<String> buildAnswers() {
        Set<String> answers = new HashSet();

        answers.add(variableName + " > suurin");
        answers.add(variableName + " < suurin");
        answers.add(variableName + " <= suurin");
        answers.add("suurin > " + variableName);
        answers.add("suurin >= " + variableName);
        answers.add(variableName + " > luvut[i]");
        answers.add(variableName + " < luvut[i]");
        answers.add("luvut > suurin");
        answers.add("luvut.length > suurin");
        
        return answers;
    }
}