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
        question.setParameters(scopes.values().toArray());
        
        return question;
    }
    
    protected abstract void randomizeParameters();
    protected abstract HashMap<String, Object> setUpScope();
    protected abstract Question setUpQuestionAndAnswers();
    protected abstract String determineRightAnswer();

    protected String getTemplateName() {
        return templateName;
    }

    protected void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
}
