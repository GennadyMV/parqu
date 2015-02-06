package rage.parqu.questioncreator;

import rage.parqu.abstractquestioncreators.ThreeValueQuestionCreator;
import rage.parqu.domain.Question;
import rage.parqu.util.Operator;

public class VariableVisibilityQuestionCreator extends ThreeValueQuestionCreator{
    
    public VariableVisibilityQuestionCreator() {
        super.setTemplateName("variablevisibility.mustache");
    }

    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Mikä arvo tulostetaan?");
        question.setAnswers("" + first, "" + second, "" + startingValue, "" + (startingValue + first), "" + (startingValue - second), "" + (startingValue + second), "" + (startingValue + first + second), "" + (startingValue + first - second));
        return question;       
    }

    @Override
    protected String determineRightAnswer() {
        if(operator == Operator.PLUS){
            return "" + (startingValue + second);
        } else if (operator == Operator.MINUS){
            return "" + (startingValue - second);
        } else {
            return "töttöröö";
        }        
    }

}
