package rage.parqu.questioncreator;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import java.io.StringWriter;
import java.util.HashMap;
import rage.parqu.domain.Question;
import rage.parqu.util.Randomizer;

public class BankQuestionCreator implements QuestionCreator{
    
    private int cash;
    private int value;
    private int border;

    @Override
    public Question createQuestion() {
        MustacheFactory mf = new DefaultMustacheFactory();         
        Mustache mustache = mf.compile("bank.mustache");
        
        HashMap<String, Object> scopes = setUpScope();
        
        StringWriter writer = new StringWriter();
        mustache.execute(writer, scopes);
        
        Question question = setUpQuestion(writer);
        question.setCode(writer.getBuffer().toString());
        
        return question;
    }

    private Question setUpQuestion(StringWriter writer) {
        Question question = new Question();
        question.setQuestionText("What is the printed number?");
        question.setAnswers("" + (cash + border), "" + (cash + value), "" + (value + border), "" + cash);
        question.setCorrectAnswer(determineRightAnswer(cash,value,border));
        return question;
    }

    private HashMap<String, Object> setUpScope() {
        HashMap<String, Object> scopes = new HashMap<>();
        cash = Randomizer.randomIntegerParameter();
        value = Randomizer.randomIntegerParameter();
        border = Randomizer.randomIntegerParameter();
        scopes.put("cash", cash);
        scopes.put("value", value);
        scopes.put("border", border);
        return scopes;
    }

    private String determineRightAnswer(int cash,int value, int border) {
        if(value > border){
            return "" + (cash + border);
        } else {
            return "" + (cash + value);
        }
    }
    
}
