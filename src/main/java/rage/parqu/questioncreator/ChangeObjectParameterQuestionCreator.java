package rage.parqu.questioncreator;

import rage.parqu.abstractquestioncreators.TwoValuesAndOperatorQuestionCreator;

public class ChangeObjectParameterQuestionCreator extends TwoValuesAndOperatorQuestionCreator{
    
    public ChangeObjectParameterQuestionCreator(){
        super.setTemplateName("changeobjectparameter.mustache");
    }

}
