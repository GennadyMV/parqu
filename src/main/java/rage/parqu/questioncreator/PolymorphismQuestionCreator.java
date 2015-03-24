package rage.parqu.questioncreator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import rage.parqu.abstractquestioncreators.QuestionCreator;
import rage.parqu.domain.Question;
import static rage.parqu.util.Randomizer.randomPositiveIntegerFromOne;
import static rage.parqu.util.Randomizer.randomPositiveIntegerFromZero;
import static rage.parqu.util.Randomizer.randomString;

public class PolymorphismQuestionCreator extends QuestionCreator {

    protected int age;
    protected int studyCredits;
    private String name;

    public PolymorphismQuestionCreator() {
        super.setTemplateName("polymorphism.mustache");
    }

    @Override
    protected void randomizeParameters() {
        age =  15 + randomPositiveIntegerFromZero(30);
        studyCredits = randomPositiveIntegerFromOne(300);
        name = randomString();
    }

    @Override
    protected HashMap<String, Object> setUpScope() {
        HashMap<String, Object> scopes = new HashMap<>();
        scopes.put("age", age);
        scopes.put("credits", studyCredits);
        scopes.put("name", name);
        
        return scopes;    
    }

    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Mitä tulostetaan?");

        question.setAnswers(buildAnswers());
        return question;       
    }

    @Override
    protected String determineRightAnswer() {
        String personPrint = name + " (" + age + ") "; 
        String studentPrint = personPrint + studyCredits + " op";
        
        return studentPrint + ", " + studentPrint + ", " + studentPrint;
    }

    private Set<String> buildAnswers() {
        Set<String> answers = new HashSet<>();
        
        String personPrint = name + " (" + age + ") "; 
        String studentPrint = personPrint + studyCredits + " op";
        
        answers.add("Opiskelija@728edb84, Opiskelija@728edb84, Opiskelija@728edb84");
        answers.add("Opiskelija@728edb84, Henkilo@728edb84, Object@728edb84");
        answers.add(studentPrint + ", " + personPrint + ", " + "Object@728edb84");
        answers.add(studentPrint + ", " + studentPrint + ", " + studentPrint);
        answers.add(studentPrint + ", " + personPrint + ", " + personPrint);
        answers.add(personPrint + ", " + personPrint + ", " + personPrint);
        
        return answers;
    }
    
}