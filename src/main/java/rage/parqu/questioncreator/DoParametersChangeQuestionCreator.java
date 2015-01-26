package rage.parqu.questioncreator;

import rage.parqu.abstractquestioncreators.ValuesAndOperatorQuestionCreator;

public class DoParametersChangeQuestionCreator extends ValuesAndOperatorQuestionCreator{
    
    public DoParametersChangeQuestionCreator(){
        super.setTemplateName("doparameterschange.mustache");
    }

    @Override
    public String determineRightAnswer(){
        return "" + super.modifier;
    }
}
