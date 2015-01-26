package rage.parqu.questioncreator;

import rage.parqu.abstractquestioncreators.ValuesAndOperatorQuestionCreator;

public class ChangeObjectParameterQuestionCreator extends ValuesAndOperatorQuestionCreator{
    
    public ChangeObjectParameterQuestionCreator(){
        super.setTemplateName("changeobjectparameter.mustache");
    }

}
