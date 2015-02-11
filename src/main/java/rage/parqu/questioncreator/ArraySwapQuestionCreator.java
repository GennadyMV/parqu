package rage.parqu.questioncreator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import rage.parqu.abstractquestioncreators.QuestionCreator;
import rage.parqu.domain.Question;
import static rage.parqu.util.Randomizer.randomPositiveIntegerFromZero;

public class ArraySwapQuestionCreator extends QuestionCreator {

    private List<Integer> numbers;
    private int firstIndex;
    private int secondIndex;

    public ArraySwapQuestionCreator() {
        super.setTemplateName("arrayswap.mustache");
    }

    @Override
    protected void randomizeParameters() {
        firstIndex = randomPositiveIntegerFromZero(6);
        secondIndex = randomPositiveIntegerFromZero(6);
        if(firstIndex == secondIndex){
            randomizeParameters();
        }
        
        numbers = new ArrayList();
        while (numbers.size() < 7) {
            int newNumber = randomPositiveIntegerFromZero(20);
            if (!numbers.contains(newNumber)) {
                numbers.add(newNumber);
            }
        }
    }

    @Override
    protected HashMap<String, Object> setUpScope() {
        HashMap<String, Object> scopes = new HashMap<>();
        for (int i = 0; i < numbers.size(); i++) {
            scopes.put("value" + (i + 1), numbers.get(i));
        }
        scopes.put("first", firstIndex);
        scopes.put("second", secondIndex);
        return scopes;
    }

    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Mitä ohjelma tulostaa?");
        question.setAnswers(buildAnswers());
        return question;
    }

    @Override
    protected String determineRightAnswer() {
        return "" + numbers.get(secondIndex);
    }

    private Set<String> buildAnswers() {
        Set<String> answers = new HashSet();

        for (Integer number : numbers) {
            answers.add("" + number);
        }

        return answers;
    }
}
