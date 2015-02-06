package rage.parqu.questioncreator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import rage.parqu.abstractquestioncreators.QuestionCreator;
import rage.parqu.domain.Question;
import static rage.parqu.util.Randomizer.randomPet;
import static rage.parqu.util.Randomizer.randomSmallPositiveInteger;

public class OverloadedConstructorQuestionCreator extends QuestionCreator {

    private String name1;
    private String name2;
    private int age1;
    private int age2;

    public OverloadedConstructorQuestionCreator() {
        super.setTemplateName("overloadedconstructor.mustache");
    }

    @Override
    protected void randomizeParameters() {
        age1 = randomSmallPositiveInteger();
        age2 = randomSmallPositiveInteger();
        if(age1 == age2){
            randomizeParameters();
        }
        name1 = randomPet();
        name2 = randomPet();
        if(name1.equals(name2)){
            randomizeParameters();
        }
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
        return fakeToString(name1, age1) + ", " + fakeToString(name2, 0 ) + ", " + fakeToString("Musti", age2)+ ", ";
    }
    
    private String fakeToString(String name, int age){
        return "" + name + " (" + age + " vuotta)";
    }
    
    private Set<String> buildAnswers() {
        Set<String> answers = new HashSet();
        
        answers.add(fakeToString(name1, age1) + ", " + fakeToString(name2, 0 ) + ", " + fakeToString("Musti", age2) + ", ");
        answers.add(fakeToString(name1, age1) + ", " + fakeToString(name2, age1 ) + ", " + fakeToString("Musti", age2) + ", ");
        answers.add(fakeToString(name1, age1) + ", " + fakeToString(name2, 0) + ", " + fakeToString(name1, age2) + ", ");
        answers.add(fakeToString(name1, age1) + ", " + name2 + ", (" + age2 + " vuotta)" + ", ");
        answers.add(fakeToString(name1, age1) + ", " + name2 + " ( vuotta), (" + age2 + " vuotta)" + ", ");
        answers.add(fakeToString(name1, age1) + ", " + fakeToString(name2, age1) + ", " + fakeToString("Musti", age2) + ", ");
        answers.add(fakeToString(name1, age1) + ", " + fakeToString(name2, age1) + ", " + fakeToString(name2, age2) + ", "); 
        
        return answers;
    }

}
