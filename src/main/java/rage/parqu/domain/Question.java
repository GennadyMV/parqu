package rage.parqu.domain;

import java.util.Arrays;
import java.util.List;

public class Question {
    
    private List<String> answers;
    private String questionText;
    private String code;
    private String correctAnswer;

    public Question() {
    }

    public Question(List<String> answers, String questionText, String code, String answer) {
        this.answers = answers;
        this.questionText = questionText;
        this.code = code;
        this.correctAnswer = answer;
    }
    
    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
    
    public void setAnswers(String... answers) {
        this.answers = Arrays.asList(answers);
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
    
    
    
}
