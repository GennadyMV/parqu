package rage.parqu.questioncreator;

import rage.parqu.abstractquestioncreators.TwoValuesAndOperatorQuestionCreator;

public class EditValueQuestionCreator extends TwoValuesAndOperatorQuestionCreator{
    
    public EditValueQuestionCreator(){
        super.setTemplateName("editvalue.mustache");
    }

    @Override
    protected String determineRightAnswer() {
        return "" + startingValue;
    }
}