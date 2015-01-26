package rage.parqu.questioncreator;

import rage.parqu.abstractquestioncreators.QuestionCreator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import rage.parqu.domain.Question;
import static rage.parqu.util.Randomizer.randomSmallPositiveInteger;

public class IntegerListRemoveQuestionCreator extends QuestionCreator {

    private List<Integer> numbers;
    protected int index;

    public IntegerListRemoveQuestionCreator() {
        super.setTemplateName("integerlistremove.mustache");
    }

    @Override
    protected void randomizeParameters() {
        numbers = new ArrayList();
        while (numbers.size() < 4) {
            int newNumber = randomSmallPositiveInteger(6);
            if (!numbers.contains(newNumber)) {
                numbers.add(newNumber);
            }
        }
        index = findPotentialIndex(numbers);
        if(index == numbers.get(index)){
            randomizeParameters();
        }
    }

    @Override
    protected HashMap<String, Object> setUpScope() {
        HashMap<String, Object> scopes = new HashMap<>();
        for (int i = 0; i < numbers.size(); i++) {
            scopes.put("value" + (i+1), numbers.get(i));
        }
        scopes.put("index", index);
        return scopes;
    }

    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Mikä numero poistetaan listalta?");
        question.setAnswers("" + numbers.get(0), "" + numbers.get(1), "" + numbers.get(2), "" + numbers.get(3));
        return question;
    }

    @Override
    protected String determineRightAnswer() {
        return "" + numbers.get(index);
    }

    private int findPotentialIndex(List<Integer> numbers) {
        for (Integer integer : numbers) {
            if(integer < numbers.size()){
                return integer;
            }
        }
        return 0;
    }

}
