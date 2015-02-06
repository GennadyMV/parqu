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
        question.setAnswers("" + (startingYear + modifier), "" + startingYear, "" + (startingYear - modifier), "" + (modifier - startingYear), "" + (startingYear + (modifier * 2)), "" + (startingYear + (modifier * 3)));
        return question;       
    }
    
    @Override
    protected String determineRightAnswer() {
        return "" + (startingYear + modifier * 2);
    }

}
