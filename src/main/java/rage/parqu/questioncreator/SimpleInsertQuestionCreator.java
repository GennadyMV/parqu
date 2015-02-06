package rage.parqu.questioncreator;

import rage.parqu.abstractquestioncreators.TwoValueQuestionCreator;
import rage.parqu.domain.Question;

public class SimpleInsertQuestionCreator extends TwoValueQuestionCreator{

    public SimpleInsertQuestionCreator() {
        super.setTemplateName("simpleinsertion.mustache");
    }

    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Mikä numero tulostetaan?");
        question.setAnswers("" + (startingValue + firstModifier), "" + (startingValue - firstModifier), "" + startingValue, "" + firstModifier);
        return question;       
    }

    @Override
    protected String determineRightAnswer() {
        return "" + firstModifier;
    }
    
}
