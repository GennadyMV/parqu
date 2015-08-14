package rage.parqu.abstractquestioncreators;

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
        Mustache mustache = mf.compile("templates/" + templateName);
        
        randomizeParameters();
        
        HashMap<String, Object> scopes = setUpScope();
        
        StringWriter writer = new StringWriter();
        mustache.execute(writer, scopes);
        
        Question question = setUpQuestionAndAnswers();
        question.setCode(writer.getBuffer().toString());
        question.setCorrectAnswer(determineRightAnswer());
        question.setParameters(scopes.values().toArray());
        addNote(question);
        
        return question;
    }
    
    /**
     * Used to randomize all the parameters for a new instance of an exercise.
     */
    protected abstract void randomizeParameters();
    /**
     * Place to store the parameters and send them to the template.
     * @return A map that maps template names to the actual randomizable variable values.
     */
    protected abstract HashMap<String, Object> setUpScope();
    /**
     * Add question text and answering options.
     * 
     * Should include the right answer
     * 
     * @return A newly created Question object with the question and answers set
     */
    protected abstract Question setUpQuestionAndAnswers();
    /**
     * Construct the right answer from the parameters.
     * @return The right answer as it appears in the answering options.
     */
    protected abstract String determineRightAnswer();

    protected String getTemplateName() {
        return templateName;
    }

    protected void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    protected void addNote(Question question) {
    }
}
