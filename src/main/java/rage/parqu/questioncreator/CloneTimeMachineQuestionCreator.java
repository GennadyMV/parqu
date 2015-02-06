package rage.parqu.questioncreator;

import rage.parqu.domain.Question;

public class CloneTimeMachineQuestionCreator extends TimeMachineQuestionCreator {
    
    public CloneTimeMachineQuestionCreator() {
        super.setTemplateName("clonetimemachine.mustache");
    }
    
    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Mitä tulostetaan?");
        question.setAnswers("" + (startingYear + modifier), "" + startingYear, "" + (startingYear - modifier), "" + (modifier - startingYear), "" + (startingYear + 2 * modifier), "" + (startingYear + 3 * modifier));
        return question;       
    }
    
    @Override
    protected String determineRightAnswer() {
        return "" + (startingYear + modifier);
    }

}
