package rage.parqu.questioncreator;

import rage.parqu.domain.Question;

public class BankQuestionCreator implements QuestionCreator{

    @Override
    public Question createQuestion() {
        Question question = new Question();
        question.setCode("System.out.println(\"tööt\");");
        question.setCorrectAnswer("tööt");
        question.setQuestionText("Mitä auto sanoo?");
        question.setAnswers("tööt", "piip", "nakki", "pate");
        
        return question;
    }
    
}
