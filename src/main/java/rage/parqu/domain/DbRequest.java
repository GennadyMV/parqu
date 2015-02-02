package rage.parqu.domain;

import java.util.UUID;
import javax.persistence.Entity;
import org.joda.time.DateTime;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class DbRequest extends AbstractPersistable<Long>{
    
    private String studentID;
    private int questionID;
    private String timeStamp;
    private UUID answerID;

    public DbRequest() {
    }

    public DbRequest(String studentID, int questionID, DateTime timeStamp, UUID answerID) {
        this.studentID = studentID;
        this.questionID = questionID;
        this.answerID = answerID;
        this.timeStamp = timeStamp.toString();
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

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
    
}
