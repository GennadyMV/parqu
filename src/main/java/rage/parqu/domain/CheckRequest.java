package rage.parqu.domain;

import java.util.UUID;

public class CheckRequest {
    
    private Integer id;
    private UUID answerID;
    private String answer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
