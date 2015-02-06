package rage.parqu.questioncreator;

import rage.parqu.abstractquestioncreators.TwoValuesAndOperatorQuestionCreator;

public class ClassCalculatorQuestionCreator extends TwoValuesAndOperatorQuestionCreator{
    
    public ClassCalculatorQuestionCreator(){
        super.setTemplateName("classcalculator.mustache");
    }
}
