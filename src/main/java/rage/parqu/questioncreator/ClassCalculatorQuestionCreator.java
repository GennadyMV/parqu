package rage.parqu.questioncreator;

import rage.parqu.abstractquestioncreators.ValuesAndOperatorQuestionCreator;

public class ClassCalculatorQuestionCreator extends ValuesAndOperatorQuestionCreator{
    
    public ClassCalculatorQuestionCreator(){
        super.setTemplateName("classcalculator.mustache");
    }
}
