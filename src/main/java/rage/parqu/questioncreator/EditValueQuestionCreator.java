package rage.parqu.questioncreator;

import rage.parqu.abstractquestioncreators.ValuesAndOperatorQuestionCreator;

public class EditValueQuestionCreator extends ValuesAndOperatorQuestionCreator{
    
    public EditValueQuestionCreator(){
        super.setTemplateName("editvalue.mustache");
    }

    @Override
    protected String determineRightAnswer() {
        return "" + value;
    }
}