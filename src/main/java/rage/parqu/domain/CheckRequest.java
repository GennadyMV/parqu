package rage.parqu.domain;

import java.util.UUID;

public class CheckRequest {
    
    private String studentID;
    private UUID answerID;
    private String answer;
    private int questionID;

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
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

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }
}
