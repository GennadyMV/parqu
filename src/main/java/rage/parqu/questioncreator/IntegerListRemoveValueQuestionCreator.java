package rage.parqu.questioncreator;

public class IntegerListRemoveValueQuestionCreator extends IntegerListRemoveQuestionCreator{
    
    public IntegerListRemoveValueQuestionCreator() {
        super.setTemplateName("integerlistremovevalue.mustache");
    }

    @Override
    protected String determineRightAnswer() {
        return "" + super.index;
    }
}
