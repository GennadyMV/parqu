package rage.parqu.questioncreator;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import rage.parqu.abstractquestioncreators.QuestionCreator;
import rage.parqu.domain.Question;

public class OverloadingMethodQuestionCreator extends QuestionCreator {

    private String name1;
    private String name2;
    private int age1;
    private int age2;

    public OverloadingMethodQuestionCreator() {
        super.setTemplateName("overloadedconstructor.mustache");
    }

    @Override
    protected void randomizeParameters() {

    }

    @Override
    protected HashMap<String, Object> setUpScope() {
        HashMap<String, Object> scopes = new HashMap<>();
        scopes.put("name1", name1);
        scopes.put("name2", name2);
        scopes.put("age1", age1);
        scopes.put("age2", age2);
        return scopes;
    }

    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Mitkä lemmikit printataan?");
        question.setAnswers(buildAnswers());
        return question;
    }

    @Override
    protected String determineRightAnswer() {
        return fakeToString(name1, age1) + ", " + fakeToString(name2, 0 ) + ", " + fakeToString("Musti", age2);
    }
    
    private String fakeToString(String name, int age){
        return "" + name + " (" + age + "vuotta)";
    }
    
    private String[] buildAnswers() {
        Set<String> answers = new TreeSet();
        
        answers.add(fakeToString(name1, age1) + ", " + fakeToString(name2, 0 ) + ", " + fakeToString("Musti", age2));
        answers.add(fakeToString(name1, age1) + ", " + fakeToString(name1, 0 ) + ", " + fakeToString(name1, age2));
        answers.add(fakeToString(name1, age1) + ", " + fakeToString(name2, 0 ) + ", " + fakeToString(name1, age2));
        answers.add(fakeToString(name1, age1) + ", " + fakeToString(name2, age1 ) + ", " + fakeToString("Musti", age1));
        answers.add(fakeToString(name1, age1) + ", " + fakeToString(name2, age2 ) + ", " + fakeToString("Musti", age1));
        answers.add(fakeToString("Musti", age1) + ", " + fakeToString("Musti", 0 ) + ", " + fakeToString("Musti", age2));
        answers.add(fakeToString(name1, 0) + ", " + fakeToString(name2, 0 ) + ", " + fakeToString("Musti", 0));
        answers.add(fakeToString(name1, age2) + ", " + fakeToString(name2, age2 ) + ", " + fakeToString("Musti", age2));
        answers.add(fakeToString(name1, age2) + ", " + fakeToString(name1, age2 ) + ", " + fakeToString("Musti", age2));
        
        return answers.toArray(new String[0]);
    }

}
