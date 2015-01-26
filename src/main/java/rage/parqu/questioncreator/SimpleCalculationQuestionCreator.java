package rage.parqu.questioncreator;

import rage.parqu.abstractquestioncreators.ValuesAndOperatorQuestionCreator;

public class SimpleCalculationQuestionCreator extends ValuesAndOperatorQuestionCreator{

    public SimpleCalculationQuestionCreator() {
        super.setTemplateName("simpleprint.mustache");
    }

}
