package rage.parqu.questioncreator;

import java.util.HashMap;
import rage.parqu.domain.Question;
import rage.parqu.util.Operator;
import static rage.parqu.util.Randomizer.randomIntegerParameter;
import static rage.parqu.util.Randomizer.randomOperator;

public class ClassCalculatorQuestionCreator extends QuestionCreator{
    
    private String name = "Calculator";
    private String type = "int";
    private String attributeName = "value";
    private String functionName = "modify";
    private String parameterName = "modifier";
    private Operator operator;
    private int modifier;
    private int value;
    
    public ClassCalculatorQuestionCreator(){
        super.setTemplateName("classcalculator.mustache");
    }

    @Override
    void randomizeParameters() {
        modifier = randomIntegerParameter();
        value = randomIntegerParameter();
        operator = randomOperator();
    }

    @Override
    HashMap<String, Object> setUpScope() {
        HashMap<String, Object> scopes = new HashMap<>();
        scopes.put("name", name);
        scopes.put("type", type);
        scopes.put("attributeName", attributeName); 
        scopes.put("functionName", functionName);
        scopes.put("parameterName", parameterName);
        scopes.put("operator", operator.toString());
        scopes.put("value", value);
        scopes.put("modifier", modifier);
        
        return scopes;
    }

    @Override
    Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("What is the printed number?");
        question.setAnswers("" + (value + modifier), "" + (modifier - value), "" + (value - modifier), "" + value);
        return question;    }

    @Override
    String determineRightAnswer() {
        if(operator == Operator.PLUS){
            return "" + (value + modifier);
        } else if (operator == Operator.MINUS){
            return "" + (value - modifier);
        } else {
            return "töttöröö";
        }
    }

}
