package rage.parqu.questioncreator;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import java.io.StringWriter;
import java.util.HashMap;
import rage.parqu.domain.Question;

public class BankQuestionCreator implements QuestionCreator{

    @Override
    public Question createQuestion() {
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile("bank.mustache");
        
        HashMap<String, Object> scopes = new HashMap<String, Object>();
        scopes.put("cash", 12);
        scopes.put("value", 50);
        scopes.put("border", 28);
        
        StringWriter writer = new StringWriter();
        
        mustache.execute(writer, scopes);
        
        Question question = new Question();
        question.setCode(writer.getBuffer().toString());
        question.setCorrectAnswer("tööt");
        question.setQuestionText("Mitä auto sanoo?");
        question.setAnswers("tööt", "piip", "nakki", "pate");
        
        return question;
    }
    
}
