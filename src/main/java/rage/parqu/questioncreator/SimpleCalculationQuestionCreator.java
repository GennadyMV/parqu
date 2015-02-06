package rage.parqu.questioncreator;

import rage.parqu.abstractquestioncreators.TwoValuesAndOperatorQuestionCreator;

public class SimpleCalculationQuestionCreator extends TwoValuesAndOperatorQuestionCreator{

    public SimpleCalculationQuestionCreator() {
        super.setTemplateName("simpleprint.mustache");
    }

}
