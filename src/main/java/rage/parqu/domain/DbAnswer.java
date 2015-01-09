package rage.parqu.domain;

import java.util.Arrays;
import java.util.List;
import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class DbAnswer extends AbstractPersistable<Long> {
        
    private int studentNumber;
    private boolean correct;
    private String questionParameters;
    private int questionID;
    private String answer;

    public DbAnswer() {
    }

    public DbAnswer(int studentNumber, boolean correct, Object[] parameters, int questionID, String answer) {
        this.studentNumber = studentNumber;
        this.correct = correct;
        this.questionParameters = Arrays.toString(parameters);
        this.questionID = questionID;
        this.answer = answer;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
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
