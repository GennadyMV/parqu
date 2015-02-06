package rage.parqu.questioncreator;

import rage.parqu.abstractquestioncreators.TwoValuesAndOperatorQuestionCreator;

public class DoParametersChangeQuestionCreator extends TwoValuesAndOperatorQuestionCreator{
    
    public DoParametersChangeQuestionCreator(){
        super.setTemplateName("doparameterschange.mustache");
    }

    @Override
    public String determineRightAnswer(){
        return "" + super.firstModifier;
    }
}
