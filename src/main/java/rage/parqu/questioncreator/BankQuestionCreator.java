package rage.parqu.questioncreator;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import java.io.StringWriter;
import java.util.HashMap;
import rage.parqu.domain.Question;
import rage.parqu.util.Randomizer;

public class BankQuestionCreator implements QuestionCreator{

    @Override
    public Question createQuestion() {
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile("bank.mustache");
        
        HashMap<String, Object> scopes = new HashMap<>();
        
        int cash = Randomizer.randomIntegerParameter();
        int value = Randomizer.randomIntegerParameter();
        int border = Randomizer.randomIntegerParameter();
        
        scopes.put("cash", cash);
        scopes.put("value", value);
        scopes.put("border", border);
        
        StringWriter writer = new StringWriter();
        
        mustache.execute(writer, scopes);
        
        Question question = new Question();
        question.setCode(writer.getBuffer().toString());
        question.setCorrectAnswer(determineRightAnswer(cash,value,border));
        question.setQuestionText("What is the printed number?");
        question.setAnswers("" + (cash + border), "" + (cash + value), "" + (value + border), "" + cash);
        
        return question;
    }

    private String determineRightAnswer(int cash,int value, int border) {
        if(value > border){
            return "" + (cash + border);
        } else {
            return "" + (cash + value);
        }
    }
    
}
