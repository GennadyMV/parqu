package rage.parqu.domain;

import java.util.UUID;

public class CheckRequest {
    
    private int studentNumber;
    private UUID answerID;
    private String answer;

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public UUID getAnswerID() {
        return answerID;
    }

    public void setAnswerID(UUID answerID) {
        this.answerID = answerID;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
