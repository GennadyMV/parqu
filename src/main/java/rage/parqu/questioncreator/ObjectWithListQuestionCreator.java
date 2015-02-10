package rage.parqu.questioncreator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import rage.parqu.abstractquestioncreators.QuestionCreator;
import rage.parqu.domain.Question;
import static rage.parqu.util.Randomizer.randomPositiveIntegerFromZero;

public class ObjectWithListQuestionCreator extends QuestionCreator {

    private List<Integer> numbers;
    protected int index;
    private int index2;

    public ObjectWithListQuestionCreator() {
        super.setTemplateName("objectwithlist.mustache");
    }

    @Override
    protected void randomizeParameters() {
        numbers = new ArrayList();
        while (numbers.size() < 6) {
            int newNumber = randomPositiveIntegerFromZero(8);
            if (!numbers.contains(newNumber)) {
                numbers.add(newNumber);
            }
        }
        index = findPotentialIndex(numbers);
        if(index == numbers.get(index)){
            randomizeParameters();
        }
        index2 = index + randomPositiveIntegerFromZero((numbers.size() - index) - 2);
        if(index2 == numbers.get(index2 + 1)){
            randomizeParameters();
        }
    }

    @Override
    protected HashMap<String, Object> setUpScope() {
        HashMap<String, Object> scopes = new HashMap<>();
        for (int i = 0; i < numbers.size(); i++) {
            scopes.put("value" + (i+1), numbers.get(i));
        }
        scopes.put("index1", index);
        scopes.put("index2", index2);
        return scopes;
    }

    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Mikä numero tulostetaan?");
        question.setAnswers("" + numbers.get(0), "" + numbers.get(1), "" + numbers.get(2), "" + numbers.get(3),  "" + numbers.get(4),  "" + numbers.get(5));
        return question;
    }

    @Override
    protected String determineRightAnswer() {        
        return "" + numbers.get(index2 + 1);
    }

    private int findPotentialIndex(List<Integer> numbers) {
        for (Integer integer : numbers) {
            if(integer < numbers.size() - 1){
                return integer;
            }
        }
        return 0;
    }

}
