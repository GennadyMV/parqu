package rage.parqu.questioncreator;

import rage.parqu.abstractquestioncreators.ThreeValuesAndOperatorQuestionCreator;
import rage.parqu.domain.Question;
import rage.parqu.util.Operator;

public class VariableVisibilityQuestionCreator extends ThreeValuesAndOperatorQuestionCreator{
    
    public VariableVisibilityQuestionCreator() {
        super.setTemplateName("variablevisibility.mustache");
    }

    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Mikä arvo tulostetaan?");
        question.setAnswers("" + startingValue, "" + firstModifier, "" + secondModifier, "" + (secondModifier + startingValue), "" + (secondModifier - firstModifier), "" + (secondModifier + firstModifier), "" + (secondModifier + startingValue + firstModifier), "" + (secondModifier + startingValue - firstModifier));
        return question;       
    }

    @Override
    protected String determineRightAnswer() {
        if(operator == Operator.PLUS){
            return "" + (startingValue + firstModifier);
        } else if (operator == Operator.MINUS){
            return "" + (startingValue - firstModifier);
        } else {
            return "töttöröö";
        }        
    }

}
