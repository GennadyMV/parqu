package rage.parqu.questioncreator;

import rage.parqu.domain.Question;

public class WhileMethodPrintVersionQuestionCreator extends WhileMethodQuestionCreator{
    
    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Mikä on tulostettu muuttujan 'eka' arvo?");
        question.setAnswers("" + first, "" + second, "" + ((first + second)/2), "" + (((first + second)/2) - first));
        return question;       
    }

    @Override
    protected String determineRightAnswer() {
        return "" + first;
    }
    

}
