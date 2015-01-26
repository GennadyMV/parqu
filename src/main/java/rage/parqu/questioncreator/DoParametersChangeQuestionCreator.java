package rage.parqu.questioncreator;

public class DoParametersChangeQuestionCreator extends SimpleCalculationQuestionCreator{
    
    public DoParametersChangeQuestionCreator(){
        super.setTemplateName("doparameterschange.mustache");
    }

    @Override
    public String determineRightAnswer(){
        return "" + super.modifier;
    }
}
