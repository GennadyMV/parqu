package rage.parqu.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.joda.time.DateTime;

public class Question {
    
    private Set<String> answers;
    private String questionText;
    private String code;
    @JsonIgnore
    private String correctAnswer;
    private UUID answerID;
    @JsonIgnore
    private Object[] parameters;
    @JsonIgnore
    private final DateTime timeStamp;

    public Question() {
        this.answerID = UUID.randomUUID();
        this.timeStamp = new DateTime();
    }
    
    public Set<String> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<String> answers) {
        this.answers = answers;
    }
    
    public void setAnswers(String... answers) {
        this.setAnswers(new HashSet<>(Arrays.asList(answers)));
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public UUID getAnswerID() {
        return answerID;
    }

    public void setAnswerID(UUID answerID) {
        this.answerID = answerID;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    public DateTime getTimeStamp() {
        return timeStamp;
    }
}
