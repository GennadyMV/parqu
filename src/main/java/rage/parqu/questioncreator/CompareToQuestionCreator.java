package rage.parqu.questioncreator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import rage.parqu.abstractquestioncreators.QuestionCreator;
import rage.parqu.domain.Question;
import static rage.parqu.util.Randomizer.randomBookObject;

public class CompareToQuestionCreator extends QuestionCreator{

    private String objectName;

    public CompareToQuestionCreator() {
        super.setTemplateName("compareto.mustache");
    }

    @Override
    protected void randomizeParameters() {
        objectName = randomBookObject();
    }

    @Override
    protected HashMap<String, Object> setUpScope() {
        HashMap<String, Object> scopes = new HashMap<>();
        scopes.put("bookObject", objectName);
        
        return scopes;    
    }

    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Minkä koodipätkän avulla saadaan kirjat sivumäärältään pienimmästä suurimpaan?");
        question.setAnswers(buildAnswers());
        return question;       
    }
    
    private Set<String> buildAnswers() {
        Set<String> answers = new HashSet();

        answers.add("this.sivuMaara - " + objectName + ".sivuMaara");
        answers.add("this.sivuMaara + " + objectName + ".sivuMaara");
        answers.add("this.sivuMaara < " + objectName + ".sivuMaara");
        answers.add("this.sivuMaara > " + objectName + ".sivuMaara");
        answers.add(objectName + ".sivuMaara - " + "this.sivuMaara");
        answers.add(objectName + ".sivuMaara + " + "this.sivuMaara");

        return answers;
    }

    @Override
    protected String determineRightAnswer() {
        return "this.sivuMaara - " + objectName + ".sivuMaara";
    }
}