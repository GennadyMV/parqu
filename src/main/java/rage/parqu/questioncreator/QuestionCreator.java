package rage.parqu.questioncreator;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import java.io.StringWriter;
import java.util.HashMap;
import rage.parqu.domain.Question;

public abstract class QuestionCreator {
    
    private String templateName;
    
    public Question createQuestion() {
        MustacheFactory mf = new DefaultMustacheFactory();         
        Mustache mustache = mf.compile(templateName);
        
        randomizeParameters();
        
        HashMap<String, Object> scopes = setUpScope();
        
        StringWriter writer = new StringWriter();
        mustache.execute(writer, scopes);
        
        Question question = setUpQuestionAndAnswers();
        question.setCode(writer.getBuffer().toString());
        question.setCorrectAnswer(determineRightAnswer());
        
        return question;
    }
    
    abstract void randomizeParameters();
    abstract HashMap<String, Object> setUpScope();
    abstract Question setUpQuestionAndAnswers();
    abstract String determineRightAnswer();

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
}
