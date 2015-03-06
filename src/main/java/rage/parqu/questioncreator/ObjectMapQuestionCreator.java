package rage.parqu.questioncreator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import rage.parqu.abstractquestioncreators.QuestionCreator;
import rage.parqu.domain.Question;
import static rage.parqu.util.Randomizer.randomPositiveIntegerFromZero;
import static rage.parqu.util.Randomizer.randomString;

public class ObjectMapQuestionCreator extends QuestionCreator {

    private List<String> names;
    private List<Integer> ages;
    private int index;

    public ObjectMapQuestionCreator() {
        super.setTemplateName("objectmap.mustache");
    }

    @Override
    protected void randomizeParameters() {
        ages = new ArrayList();
        names = new ArrayList();
        while (ages.size() < 3) {
            int newNumber = randomPositiveIntegerFromZero(60);
            if (!ages.contains(newNumber)) {
                ages.add(newNumber);
            }
        }
        while (names.size() < 3) {
            String newName = randomString();
            if (!names.contains(newName)) {
                names.add(newName);
            }
        }
        index = randomPositiveIntegerFromZero(2);
    }

    @Override
    protected HashMap<String, Object> setUpScope() {
        HashMap<String, Object> scopes = new HashMap<>();
        for (int i = 0; i < ages.size(); i++) {
            scopes.put("age" + (i+1), ages.get(i));
            scopes.put("name" + (i + 1), names.get(i));
            scopes.put("objectName" + (i + 1), names.get(i).toLowerCase());
        }
        scopes.put("number", ages.get(2 - index));
        return scopes;
    }

    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Millä get komennolla saadaan hajautustaulusta luku " + ages.get(index) + "?");
        question.setAnswers(setupAnswers()); 
        return question;
    }

    @Override
    protected String determineRightAnswer() {
        return "henkilotaulu.get(\"" + names.get(index) + "\").getIka()";
    }

    private Set<String> setupAnswers() {
        Set<String> answers = new HashSet<>();
        
        for (int i = 0; i < ages.size(); i++) {
            answers.add("henkilotaulu.get(\"" + names.get(i) + "\")");
            answers.add("henkilotaulu.get(\"" + ages.get(i) + "\").getIka()");
        }
        
        return answers;
    }


}
