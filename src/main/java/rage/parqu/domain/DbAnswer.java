package rage.parqu.domain;

import java.util.Arrays;
import java.util.UUID;
import javax.persistence.Entity;
import org.joda.time.DateTime;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class DbAnswer extends AbstractPersistable<Long> {
        
    private String studentID;
    private boolean correct;
    private String questionParameters;
    private int questionID;
    private String answer;
    private String timeStamp;
    private UUID answerID;

    public DbAnswer() {
    }

    public DbAnswer(String studentID, boolean correct, Object[] parameters, int questionID, String answer, DateTime timeStamp, UUID answerID) {
        this.studentID = studentID;
        this.correct = correct;
        this.questionParameters = Arrays.toString(parameters);
        this.questionID = questionID;
        this.answer = answer;
        this.timeStamp = timeStamp.toString();
        this.answerID = answerID;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public UUID getAnswerID() {
        return answerID;
    }

    public void setAnswerID(UUID answerID) {
        this.answerID = answerID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getQuestionParameters() {
        return questionParameters;
    }

    public void setQuestionParameters(String questionParameters) {
        this.questionParameters = questionParameters;
    }
}
