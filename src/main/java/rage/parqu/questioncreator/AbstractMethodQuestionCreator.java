package rage.parqu.questioncreator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import rage.parqu.abstractquestioncreators.QuestionCreator;
import rage.parqu.domain.Question;
import static rage.parqu.util.Randomizer.randomFunctionName;
import static rage.parqu.util.Randomizer.randomPositiveIntegerFromZero;

public class AbstractMethodQuestionCreator extends QuestionCreator {

    private List<Function> functionsInAbstract;
    private List<Function> functionsInInterface;
    private List<Function> functionsInClass;
    private List<String> functionNames;
    private int functionsToImplement;
    private int functionsImplemented;
    

    public AbstractMethodQuestionCreator() {
        super.setTemplateName("abstractmethods.mustache");
    }

    @Override
    protected void randomizeParameters() {
        functionsImplemented = randomPositiveIntegerFromZero(2);
        functionsToImplement = functionsImplemented + randomPositiveIntegerFromZero(5);
       
        functionNames = new ArrayList<>();
        while(functionNames.size() < functionsToImplement){
            String newName = randomFunctionName();
            if(!functionNames.contains(newName)){
                functionNames.add(newName);
            }
        }
        functionsInAbstract = new ArrayList<>();
        functionsInClass = new ArrayList<>();

        for (String name : functionNames) {
            functionsInAbstract.add(new Function(name));
        }

        int i = 0;
        Collections.shuffle(functionNames);
        for (String name : functionNames) {
            if(i >= functionsImplemented){
                break;
            }            
            functionsInClass.add(new Function(name));
             i++;
        }
    }

    @Override
    protected HashMap<String, Object> setUpScope() {
        HashMap<String, Object> scopes = new HashMap<>();

        scopes.put("abstractfunctions", functionsInAbstract);
        scopes.put("implementedfunctions", functionsInClass);

        return scopes;
    }

    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Kuinka monta metodia luokkaan Fuksi täytyy toteuttaa?");
        question.setAnswers(0 + "", 1 + "", 2 + "", 3+ "", 4 + "", 5 + "", 6 + "", 7 + "");
        return question;
    }

    @Override
    protected String determineRightAnswer() {
        return "" + (functionsToImplement - functionsImplemented);
    }

    static class Function {

        Function(String name) {
            this.name = name;
        }
        String name;
        
        @Override
        public String toString(){
            return name;
        }
    }
}
