package rage.parqu.domain;

import java.util.Arrays;
import javax.persistence.Entity;
import org.joda.time.DateTime;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class DbRequest extends AbstractPersistable<Long>{
    
    private String studentID;
    private String questionParameters;
    private int questionID;
    private String timeStamp;

    public DbRequest(String studentID, Object[] parameters, int questionID, DateTime timeStamp) {
        this.studentID = studentID;
        this.questionParameters = Arrays.toString(parameters);
        this.questionID = questionID;
        this.timeStamp = timeStamp.toString();
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getQuestionParameters() {
        return questionParameters;
    }

    public void setQuestionParameters(String questionParameters) {
        this.questionParameters = questionParameters;
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
