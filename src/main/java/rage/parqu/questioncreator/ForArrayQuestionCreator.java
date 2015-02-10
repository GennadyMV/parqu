package rage.parqu.questioncreator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import rage.parqu.abstractquestioncreators.QuestionCreator;
import rage.parqu.domain.Question;
import static rage.parqu.util.Randomizer.randomPositiveIntegerFromZero;

public class ForArrayQuestionCreator extends QuestionCreator {

    private List<Integer> numbers;
    private int steps;
    private int startingValue;

    public ForArrayQuestionCreator() {
        super.setTemplateName("forarray.mustache");
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
        steps = randomPositiveIntegerFromZero(4);
        startingValue = randomPositiveIntegerFromZero(4);
    }

    @Override
    protected HashMap<String, Object> setUpScope() {
        HashMap<String, Object> scopes = new HashMap<>();
        for (int i = 0; i < numbers.size(); i++) {
            scopes.put("value" + (i+1), numbers.get(i));
        }
        scopes.put("steps", steps);
        scopes.put("startingValue", startingValue);
        return scopes;
    }

    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Mikä numero poistetaan listalta?");
        question.setAnswers(buildAnswers());
        return question;
    }

    @Override
    protected String determineRightAnswer() {
        if(steps + startingValue < numbers.size() - 1){
            return "" + numbers.get(steps + startingValue);
        } else {
            return "Ohjelma ei printtaa mitään";
        }
    }

    private Set<String> buildAnswers() {
        Set<String> answers = new HashSet();

        for (Integer number : numbers) {
            answers.add("" + number);
        }
        
        answers.add("Ohjelma ei printtaa mitään");
        
        return answers;
    }
}
