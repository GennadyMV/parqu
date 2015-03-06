package rage.parqu.questioncreator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import rage.parqu.abstractquestioncreators.QuestionCreator;
import rage.parqu.domain.Question;
import static rage.parqu.util.Randomizer.randomPositiveIntegerFromZero;

public class MapGetQuestionCreator extends QuestionCreator {

    private List<Integer> numberStrings;
    private List<Integer> numbers;
    private int index;

    public MapGetQuestionCreator() {
        super.setTemplateName("mapget.mustache");
    }

    @Override
    protected void randomizeParameters() {
        numbers = new ArrayList();
        numberStrings = new ArrayList();
        while (numbers.size() < 3) {
            int newNumber = randomPositiveIntegerFromZero(10);
            if (!numbers.contains(newNumber)) {
                numbers.add(newNumber);
            }
        }
        for (int i = numbers.size() - 1; i >= 0 ; i--) {
            numberStrings.add(numbers.get(i));
        }
        index = randomPositiveIntegerFromZero(2);
        if(numbers.get(index) == numberStrings.get(index)){
            this.randomizeParameters();
        }
    }

    @Override
    protected HashMap<String, Object> setUpScope() {
        HashMap<String, Object> scopes = new HashMap<>();
        for (int i = 0; i < numbers.size(); i++) {
            scopes.put("number" + (i+1), numbers.get(i));
            scopes.put("numberString" + (i + 1), numberStrings.get(i));
        }
        scopes.put("number", numbers.get(2 - index));
        return scopes;
    }

    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Millä get komennolla saadaa hajautustaulusta luku" + numbers.get(2 - index) + "?");
        question.setAnswers(setupAnswers());
        return question;
    }

    @Override
    protected String determineRightAnswer() {
        return "muutostaulu.get(\"" + numberStrings.get(2 - index) + "\")";
    }

    private Set<String> setupAnswers() {
        Set<String> answers = new HashSet<>();
        
        for (int i = 0; i < numbers.size(); i++) {
            answers.add("muutostaulu.get(" + numbers.get(i) + ")");
            answers.add("muutostaulu.get(\"" + numbers.get(i) + "\")");
        }
        
        return answers;
    }


}
