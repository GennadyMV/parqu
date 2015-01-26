package rage.parqu.questioncreator;

import java.util.HashMap;
import rage.parqu.domain.Question;
import rage.parqu.util.Operator;
import rage.parqu.util.Randomizer;
import static rage.parqu.util.Randomizer.randomFunctionName;
import static rage.parqu.util.Randomizer.randomOperator;
import static rage.parqu.util.Randomizer.randomSmallPositiveInteger;

public class CallObjectMethodQuestionCreator extends QuestionCreator{
    
    private Operator operator;
    private int amount;
    private String function;
    private String name;
    
    public CallObjectMethodQuestionCreator(){
        super.setTemplateName("callobjectmethod.mustache");
    }

    @Override
    protected void randomizeParameters() {
        amount = randomSmallPositiveInteger();
        operator = randomOperator();
        function = randomFunctionName();
        name = Randomizer.randomString().toLowerCase();
    }

    @Override
    protected HashMap<String, Object> setUpScope() {
        HashMap<String, Object> scopes = new HashMap<>();
        scopes.put("operator", operator.toString());
        scopes.put("amount", amount);
        scopes.put("function", function);
        scopes.put("name", name);
        
        return scopes;
    }

    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Mikä näistä koodiriveistä ei aiheuta virhettä?");
        question.setAnswers(name + "." + function + ";", function + "();",name + "." + function + "();", "Opiskelija." + function + ";", "Opiskelija." + function + "();");
        return question;    
    }

    @Override
    protected String determineRightAnswer() {
        return name + "." + function + "();";
    }
}
